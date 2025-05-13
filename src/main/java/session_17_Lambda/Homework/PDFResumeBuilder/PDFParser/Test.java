package session_17_Lambda.Homework.PDFResumeBuilder.PDFParser;

import session_17_Lambda.Homework.PDFResumeBuilder.Data.Resume;
import session_17_Lambda.Homework.PDFResumeBuilder.ResumeParser;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String fileName = "Files/Homework_session_17/Resume.pdf";
        Resume resume = ResumeParser.readFromFile("Files/Homework_session_17/Resume.txt");
        PDFWriter pdfWriter = new PDFWriter(resume, fileName, "Files/Homework_session_17/Icons/user.png");
        pdfWriter.createPDF();
        FileOpener.openFile(new File(fileName));
    }
}
