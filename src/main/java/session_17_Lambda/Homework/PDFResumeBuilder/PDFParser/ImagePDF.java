package session_17_Lambda.Homework.PDFResumeBuilder.PDFParser;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class ImagePDF {
    public static void addImage(PDDocument document, PDPageContentStream contentStream, String path, float xPosition, float yPosition, float width, float height) throws IOException {
        PDImageXObject image = PDImageXObject.createFromFile(path, document);
        contentStream.drawImage(image, xPosition, yPosition, width, height);
    }
}
