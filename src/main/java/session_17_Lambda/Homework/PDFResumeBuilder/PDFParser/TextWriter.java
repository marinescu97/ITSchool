package session_17_Lambda.Homework.PDFResumeBuilder.PDFParser;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextWriter {
    private final PDDocument document;
    private final PDPageContentStream contentStream;

    public TextWriter(PDDocument document, PDPageContentStream contentStream) {
        this.document = document;
        this.contentStream = contentStream;
    }

    public float writeText(String text, float xPosition, float yPosition, float maxWidth,
                           PDFont font, float fontSize, float leading, Color color) throws IOException {
        List<String> lines = wrapText(text, font, fontSize, maxWidth, false);
        return writeLines(lines, leading, xPosition, yPosition, font, fontSize, color);
    }

    public float writeLines(List<String> lines, float leading, float x, float y,
                            PDFont font, float fontSize, Color color) throws IOException {
        contentStream.beginText();
        contentStream.setFont(font, fontSize);
        contentStream.setNonStrokingColor(color);
        contentStream.setLeading(leading);
        contentStream.newLineAtOffset(x, y);

        for (String line : lines) {
            contentStream.showText(line);
            contentStream.newLine();
        }

        contentStream.endText();
        return y - (leading * lines.size());
    }

    public float writeTextWithBullet(String text, float x, float y, float maxWidth,
                                     PDFont font, float fontSize, Color color) throws IOException {
        String bullet = "•";
        float bulletSize = fontSize + 15f;
        float bulletYOffset = 6f;
        float bulletWidth = getTextWidth(font, bullet, fontSize);
        float textX = x + bulletWidth + 10f;

        writeLines(List.of(bullet), 0f, x, y - bulletYOffset, font, bulletSize, color);
        List<String> wrappedLines = wrapText(text, font, fontSize, maxWidth - textX, false);
        return writeLines(wrappedLines, 25f, textX, y, font, fontSize, color);
    }

    public void writeParagraph(String text, float leading, float maxWidth, float x, float y,
                               PDFont font, float fontSize, Color color) throws IOException {
        List<String> lines = wrapText(text, font, fontSize, maxWidth, true);
        writeLines(lines, leading, x, y, font, fontSize, color);
    }

    public void writeTextWithIcon(String iconPath, String text, float x, float y,
                                  PDFont font, float fontSize, Color color) throws IOException {
        ImagePDF.addImage(document, contentStream, iconPath, x, y, 16f, 16f);
        writeText(text, x + 21f, y + 2f, 400f, font, fontSize, 20f, color); // maxWidth is adjustable
    }

    private List<String> wrapText(String text, PDFont font, float fontSize, float maxWidth, boolean indent) throws IOException {
        List<String> lines = new ArrayList<>();
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();

        if (indent && words.length > 0) {
            words[0] = " ".repeat(10) + words[0];
        }

        for (String word : words) {
            String testLine = line.isEmpty() ? word : line + " " + word;
            float lineWidth = font.getStringWidth(testLine) / 1000 * fontSize;

            if (lineWidth > maxWidth) {
                if (!line.isEmpty()) {
                    lines.add(line.toString());
                }
                line = new StringBuilder(word);
            } else {
                line = new StringBuilder(testLine);
            }
        }

        if (!line.isEmpty()) {
            lines.add(line.toString());
        }

        return lines;
    }

    public static float getTextWidth(PDFont font, String text, float fontSize) throws IOException {
        return font.getStringWidth(text) / 1000 * fontSize;
    }
}
