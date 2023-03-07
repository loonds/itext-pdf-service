package com.loonds.genratepdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

@Component
public class PDFGenerator {

    public void generatePDF() {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("example.pdf"));
            document.open();
            Paragraph paragraph = new Paragraph();
            paragraph.add("Hello, World!");
            document.add(paragraph);
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
