package session_12_OOP_3;

import java.util.List;

public interface CsvExportable {
    void exportToCsv();
}

abstract class Report{
    public String title;
    public List<String> data;

    public Report(String title, List<String> data) {
        this.title = title;
        this.data = data;
    }

    public void display(){
        System.out.println("Title: " + title);
    }

    public abstract void showPreview();
}

class CsvReport extends Report implements CsvExportable{
    public CsvReport(String title, List<String> data) {
        super(title, data);
    }

    @Override
    public void exportToCsv() {
        System.out.println("Export");
    }

    @Override
    public void showPreview() {
        System.out.println("Preview");
    }
}

interface PDFExportable{
    void exportToPdf();
}

class PdfReport extends Report implements PDFExportable{
    public PdfReport(String title, List<String> data) {
        super(title, data);
    }

    @Override
    public void exportToPdf() {
        System.out.println("Export to PDF");
    }

    @Override
    public void showPreview() {
        System.out.println("preview");
    }
}

class Main{
    public static void main(String[] args) {
        CsvReport csvReport = new CsvReport("Example Table", List.of("1", "2"));
        csvReport.display();
        csvReport.exportToCsv();
        csvReport.showPreview();

        PdfReport pdfReport = new PdfReport("PDF content", List.of("1", "2"));
        pdfReport.display();
        pdfReport.exportToPdf();
        pdfReport.showPreview();
    }
}
