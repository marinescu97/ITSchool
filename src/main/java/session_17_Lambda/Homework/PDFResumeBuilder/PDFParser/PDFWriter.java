package session_17_Lambda.Homework.PDFResumeBuilder.PDFParser;

import org.apache.pdfbox.pdmodel.PDDocument;
import session_17_Lambda.Homework.PDFResumeBuilder.Data.Resume;

import java.io.IOException;

public class PDFWriter {
    private final Resume resume;
    private final String fileName;
    private String profilePicturePath;


    public PDFWriter(Resume resume, String fileName) {
        this.resume = resume;
        this.fileName = fileName;
    }

    public PDFWriter(Resume resume, String fileName, String profilePicturePath) {
        this(resume, fileName);
        this.profilePicturePath = profilePicturePath;
    }

    public void createPDF() throws IOException{
        PDDocument document = new PDDocument();

        ContentCreator contentCreator = profilePicturePath == null ?
                                            new ContentCreator(resume, document) :
                                            new ContentCreator(resume, document, profilePicturePath);
        contentCreator.createContent();

        document.save(fileName);
        document.close();
        System.out.println("PDF created: " + fileName);
    }
}
