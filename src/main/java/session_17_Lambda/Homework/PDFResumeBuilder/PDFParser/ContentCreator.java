package session_17_Lambda.Homework.PDFResumeBuilder.PDFParser;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import session_17_Lambda.Homework.PDFResumeBuilder.Data.Resume;
import session_17_Lambda.Homework.PDFResumeBuilder.Validator;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ContentCreator {
    private final Resume resume;
    private final PDDocument document;
    private final PDPage page;
    private final PDPageContentStream contentStream;
    private String profilePicturePath;
    private final PageProperties properties;
    private final TextWriter textWriter;
    private float yPosition;

    public ContentCreator(Resume resume, PDDocument document, String profilePicturePath) throws IOException {
        this(resume, document);
        this.profilePicturePath = profilePicturePath;
    }

    public ContentCreator(Resume resume, PDDocument document) throws IOException {
        this.resume = resume;
        this.document = document;
        this.page = new PDPage(PDRectangle.A4);
        this.contentStream = new PDPageContentStream(document, page);
        this.profilePicturePath = null;
        this.properties = new PageProperties(page);
        this.textWriter = new TextWriter(document, contentStream);
    }

    public void createContent() throws IOException {
        document.addPage(page);

        fillMargin();
        addName();
        addProfilePicture();
        addObjective();
        addPersonalInformation();
        splitPage();
        addWorkExperience();
        addSkills();
        addEducation();

        contentStream.close();
    }

    private void fillMargin() throws IOException{
        properties.setPageWidth(page.getMediaBox().getWidth());
        properties.setPageHeight(page.getMediaBox().getHeight());

        // Top margin
        ShapeDrawer.drawRectangle(contentStream, 0, properties.getPageHeight() - properties.getMargin(), properties.getPageWidth(), properties.getMargin());
        // Bottom margin
        ShapeDrawer.drawRectangle(contentStream, 0, 0, properties.getPageWidth(), properties.getMargin());
        // Left margin
        ShapeDrawer.drawRectangle(contentStream, 0, properties.getMargin(), properties.getMargin(), properties.getPageHeight() - 2 * properties.getMargin());
        // Right margin
        ShapeDrawer.drawRectangle(contentStream, properties.getPageWidth() -properties.getMargin(), properties.getMargin(), properties.getMargin(), properties.getPageHeight() - 2 * properties.getMargin());

        contentStream.fill();

        properties.setPageWidth(properties.getPageWidth() - (properties.getMargin() * 2));
        properties.setPageHeight(properties.getPageHeight() - (properties.getMargin() * 2));

        properties.setCurrentXPosition(properties.getMargin() + 30f);
        properties.decrementCurrentYPosition(70f);
    }

    private void addName() throws IOException{
        String name = validateField("name", resume.getName());

        yPosition = textWriter.writeText(
                name,
                properties.getCurrentXPosition(),
                properties.getCurrentYPosition(),
                properties.getPageWidth() / 2,
                properties.getFont(),
                35f,
                properties.getLeading(),
                properties.getTextColor());

        properties.setCurrentYPosition(yPosition - properties.getMargin());
    }

    private void addProfilePicture() {
        Optional.ofNullable(profilePicturePath).ifPresent(path -> {
            try {
                ImagePDF.addImage(document, contentStream, path,
                        properties.getPageWidth() - 150f,
                        properties.getPageHeight() - 200f,
                        150f, 170f);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void addObjective() throws IOException{
        Predicate<String> condition = str -> Optional.ofNullable(profilePicturePath)
                                                            .map(path -> str.length() < 360)
                                                            .orElse(str.length() < 500);
        String objective = validateField("objective", resume.getObjective(), condition, "The objective field is too large!");

        float maxWidth = properties.getPageWidth() -
                Optional.ofNullable(profilePicturePath)
                        .map((p) -> 200f)
                        .orElse(50f);

        textWriter.writeParagraph(
                objective,
                22f,
                maxWidth,
                properties.getCurrentXPosition(),
                properties.getCurrentYPosition(),
                properties.getFont(),
                properties.getTextFontSize(),
                properties.getTextColor());

        properties.decrementCurrentYPosition(140f);
    }

    private void addPersonalInformation() throws IOException{
        String address = validateField("address", resume.getPersonalInformation().getAddress());
        String phoneNumber = validateField(
                "phone number",
                resume.getPersonalInformation().getPhoneNumber(),
                s -> s.matches("^\\d{3}-\\d{3}-\\d{4}$"),
                "Invalid phone number");

        String emailAddress = validateField(
                "email address",
                resume.getPersonalInformation().getEmail(),
                s -> Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(s).matches(),
                "Invalid email!");

        float labelHeight = 100f;
        ShapeDrawer.drawRectangle(contentStream, properties.getCurrentXPosition(), properties.getCurrentYPosition() - labelHeight, page.getMediaBox().getWidth() - properties.getCurrentXPosition(), labelHeight);

        properties.decrementCurrentYPosition(20f);

        Map<String, String> personalInfo = new LinkedHashMap<>();
        personalInfo.put("Files/Homework_session_17/Icons/location.png", address);
        personalInfo.put("Files/Homework_session_17/Icons/phone.png", phoneNumber);
        personalInfo.put("Files/Homework_session_17/Icons/email.png", emailAddress);

        float iconXPosition = properties.getCurrentXPosition() + 10f;
        float iconYPosition = properties.getCurrentYPosition() - 10f;

        for (Map.Entry<String, String> entry : personalInfo.entrySet()) {
            textWriter.writeTextWithIcon(entry.getKey(), entry.getValue(), iconXPosition, iconYPosition,
                                            properties.getFont(), properties.getTextFontSize(), Color.lightGray);
            iconYPosition -= 28f;
        }

        properties.decrementCurrentYPosition(labelHeight + 20f);
    }

    private void addWorkExperience() throws IOException{
        float tempY = properties.getCurrentYPosition();
        yPosition = textWriter.writeText(
                "WORK EXPERIENCE",
                properties.getCurrentXPosition(),
                properties.getCurrentYPosition(),
                properties.getPageWidth() - properties.getLeftSectionWidth(),
                properties.getFont(),
                properties.getSubtitleFontSize(),
                properties.getLeading(),
                properties.getTextColor());

        properties.setCurrentYPosition(yPosition - properties.getMargin());

        String duration = validateField("work duration", resume.getWorkExperience().getDuration());
        String jobTitle = validateField("job title", resume.getWorkExperience().getJobTitle());
        String company = validateField("company", resume.getWorkExperience().getCompany());

        String[] fields = {duration, jobTitle, company};
        PDFont font = properties.getFont();
        for (String field : fields){
            if (field.equals(resume.getWorkExperience().getJobTitle())){
                font = properties.getBoldFont();
            }
            textWriter.writeText(
                    field,
                    properties.getCurrentXPosition(),
                    properties.getCurrentYPosition(),
                    properties.getPageWidth() - properties.getRightSectionWidth(),
                    font,
                    properties.getTextFontSize(),
                    20f,
                    properties.getTextColor());
            properties.decrementCurrentYPosition(25f);
        }

        if (resume.getWorkExperience().getJobDescription() != null){
            textWriter.writeTextWithBullet(resume.getWorkExperience().getJobDescription(), properties.getCurrentXPosition() + 15f, properties.getCurrentYPosition(), properties.getRightSectionWidth() - 10f, properties.getFont(), properties.getTextFontSize(), properties.getTextColor());
        }

        properties.setCurrentYPosition(tempY);
    }

    private void splitPage() throws IOException{
        properties.setLeftSectionWidth(properties.getPageWidth() / 2.5f);
        properties.setRightSectionWidth(properties.getPageWidth() - properties.getLeftSectionWidth());

        ShapeDrawer.drawVerticalLine(contentStream, properties.getRightSectionWidth(), properties.getCurrentYPosition() + properties.getSubtitleFontSize(), 50f);
    }

    private void addSkills() throws IOException {
        if (!resume.getSkills().isEmpty()){
            ShapeDrawer.drawRectangle(
                    contentStream,
                    properties.getRightSectionWidth() - 6f,
                    properties.getCurrentYPosition(),
                    12f,
                    12f);

            properties.setCurrentXPosition(properties.getRightSectionWidth() + 20f);

            yPosition = textWriter.writeText(
                    "SKILLS",
                    properties.getCurrentXPosition(),
                    properties.getCurrentYPosition(),
                    properties.getPageWidth(),
                    properties.getFont(),
                    properties.getSubtitleFontSize(),
                    properties.getLeading(),
                    properties.getTextColor());

            properties.setCurrentYPosition(yPosition);

            for (String skill : resume.getSkills()){
                yPosition = textWriter.writeTextWithBullet(
                        skill,
                        properties.getCurrentXPosition(),
                        properties.getCurrentYPosition(),
                        properties.getPageWidth(),
                        properties.getFont(),
                        properties.getTextFontSize(),
                        properties.getTextColor());
                properties.setCurrentYPosition(yPosition);
            }

            properties.setCurrentYPosition(yPosition - properties.getMargin());
        }
    }

    private void addEducation() throws IOException{
        String graduationDate = validateField("graduation date", resume.getEducation().getGraduationDate());
        String degree = validateField("degree", resume.getEducation().getDegree());
        String universityName = validateField("university name", resume.getEducation().getUniversityName());

        ShapeDrawer.drawRectangle(
                contentStream,
                properties.getRightSectionWidth() - 6f,
                properties.getCurrentYPosition(),
                12f,
                12f);

        yPosition = textWriter.writeText(
                "EDUCATION",
                properties.getCurrentXPosition(),
                properties.getCurrentYPosition(),
                properties.getPageWidth(),
                properties.getFont(),
                properties.getSubtitleFontSize(),
                properties.getLeading(),
                properties.getTextColor());

        properties.setCurrentYPosition(yPosition - properties.getMargin());

        String[] fields = {graduationDate, degree, universityName};
        PDFont font = properties.getFont();
        for (String field : fields){
            if (field.equals(resume.getEducation().getDegree())){
                font = properties.getBoldFont();
            }
            yPosition = textWriter.writeText(
                    field,
                    properties.getCurrentXPosition(),
                    properties.getCurrentYPosition(),
                    properties.getPageWidth() - properties.getCurrentXPosition(),
                    font,
                    properties.getTextFontSize(),
                    properties.getLeading(),
                    properties.getTextColor());
            properties.setCurrentYPosition(yPosition);
        }
    }

    private String validateField(String field, String value){
        return Validator.checkNull(field).validate(value);
    }

    private String validateField(String field, String value, Predicate<String> condition, String errorMsg){
        return Validator.checkNull(field).thenCheck(condition, errorMsg).validate(value);
    }
}
