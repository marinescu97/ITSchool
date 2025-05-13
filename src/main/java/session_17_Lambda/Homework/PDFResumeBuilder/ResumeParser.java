package session_17_Lambda.Homework.PDFResumeBuilder;

import session_17_Lambda.Homework.PDFResumeBuilder.Data.Resume;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.function.Consumer;

public class ResumeParser {
    private static final Resume resume = new Resume();
    private static String currentSection = "";
    private static String line;

    private static final Map<String, Runnable> sectionSwitch = Map.of(
            "personal information:", () -> currentSection = "personalInformation",
            "objective:", () -> currentSection = "objective",
            "education:", () -> currentSection = "education",
            "work experience:", () -> currentSection = "workExperience",
            "skills:", () -> currentSection = "skills"
    );

    public static Resume readFromFile(String filePath){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            while ((line = reader.readLine()) != null){
                line = line.trim();

                if (!line.isEmpty()){
                    buildResume();
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return resume;
    }

    private static void buildResume(){
        Runnable sectionHandler = sectionSwitch.get(line.toLowerCase());
        if (sectionHandler != null) {
            sectionHandler.run();
        } else {
            handleCurrentSection();
        }
    }

    private static void handleCurrentSection(){
        switch (currentSection) {
            case "personalInformation" -> parsePersonalInfo();
            case "objective" -> resume.setObjective(line);
            case "education" -> parseEducation();
            case "workExperience" -> parseWorkExperience();
            case "skills" -> parseSkills();
        }
    }

    private static void parsePersonalInfo() {
        parseKeyValue(Map.of(
                "name", resume::setName,
                "address", value -> resume.getPersonalInformation().setAddress(value),
                "phone number", value -> resume.getPersonalInformation().setPhoneNumber(value),
                "email", value -> resume.getPersonalInformation().setEmail(value)
        ));
    }

    private static void parseEducation() {
        parseKeyValue(Map.of(
                "university name", value -> resume.getEducation().setUniversityName(value),
                "degree", value -> resume.getEducation().setDegree(value),
                "graduation date", value -> resume.getEducation().setGraduationDate(value)
        ));
    }

    private static void parseWorkExperience() {
        parseKeyValue(Map.of(
                "company name", value -> resume.getWorkExperience().setCompany(value),
                "job title", value -> resume.getWorkExperience().setJobTitle(value),
                "job description", value -> resume.getWorkExperience().setJobDescription(value),
                "duration", value -> resume.getWorkExperience().setDuration(value)
        ));
    }

    private static void parseKeyValue(Map<String, Consumer<String>> handlers) {
        String[] parts = line.split(":", 2);
        if (parts.length < 2) return;

        String key = parts[0].trim().toLowerCase();
        String value = parts[1].trim();

        Consumer<String> handler = handlers.get(key);
        if (handler != null) {
            handler.accept(value);
        }
    }


    private static void parseSkills(){
        if (line.startsWith("- ")) {
            String skill = line.substring(2).trim();
            if (!skill.isEmpty()) {
                resume.addSkill(skill);
            }
        }
    }
}
