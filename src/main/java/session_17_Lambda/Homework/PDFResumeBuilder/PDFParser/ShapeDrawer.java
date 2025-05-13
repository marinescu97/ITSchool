package session_17_Lambda.Homework.PDFResumeBuilder.PDFParser;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.awt.*;
import java.io.IOException;


public class ShapeDrawer {
    private static final Color color = new Color(4, 61, 122);

    public static void drawRectangle(PDPageContentStream contentStream, float xPosition, float yPosition, float labelWidth, float labelHeight) throws IOException{
        contentStream.setNonStrokingColor(color);
        contentStream.addRect(xPosition, yPosition, labelWidth, labelHeight);
        contentStream.fill();
    }

    public static void drawVerticalLine(PDPageContentStream contentStream, float xPosition, float yStart, float yEnd) throws IOException{
        contentStream.setStrokingColor(color);
        contentStream.setLineWidth(1f);

        // Draw the vertical line
        contentStream.moveTo(xPosition, yStart);
        contentStream.lineTo(xPosition, yEnd);
        contentStream.stroke();
    }
}
