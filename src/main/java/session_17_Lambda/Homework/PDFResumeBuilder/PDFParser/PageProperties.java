package session_17_Lambda.Homework.PDFResumeBuilder.PDFParser;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;

public class PageProperties {
    private float leftSectionWidth;
    private float rightSectionWidth;
    private float currentXPosition;
    private float currentYPosition;
    private float pageWidth;
    private float pageHeight;
    private final PDFont font = PDType1Font.TIMES_ROMAN;
    private final PDFont boldFont = PDType1Font.TIMES_BOLD;
    private final Color textColor = Color.black;

    public PageProperties(PDPage page) {
        this.currentXPosition = 0f;
        this.currentYPosition = page.getMediaBox().getHeight();
        this.pageWidth = page.getMediaBox().getWidth();
        this.pageHeight = page.getMediaBox().getHeight();
    }

    public float getLeftSectionWidth() {
        return leftSectionWidth;
    }

    public void setLeftSectionWidth(float leftSectionWidth) {
        this.leftSectionWidth = leftSectionWidth;
    }

    public float getRightSectionWidth() {
        return rightSectionWidth;
    }

    public void setRightSectionWidth(float rightSectionWidth) {
        this.rightSectionWidth = rightSectionWidth;
    }

    public float getCurrentXPosition() {
        return currentXPosition;
    }

    public void setCurrentXPosition(float currentXPosition) {
        this.currentXPosition = currentXPosition;
    }

    public float getCurrentYPosition() {
        return currentYPosition;
    }

    public void setCurrentYPosition(float currentYPosition) {
        this.currentYPosition = currentYPosition;
    }

    public void decrementCurrentYPosition(float points){
        this.currentYPosition -= points;
    }

    public float getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(float pageWidth) {
        this.pageWidth = pageWidth;
    }

    public float getPageHeight() {
        return pageHeight;
    }

    public void setPageHeight(float pageHeight) {
        this.pageHeight = pageHeight;
    }

    public PDFont getFont() {
        return font;
    }

    public PDFont getBoldFont() {
        return boldFont;
    }

    public Color getTextColor() {
        return textColor;
    }

    public float getSubtitleFontSize() {
        return 25f;
    }

    public float getTextFontSize() {
        return 16f;
    }

    public float getLeading() {
        return 22f;
    }

    public float getMargin(){
        return 20f;
    }
}
