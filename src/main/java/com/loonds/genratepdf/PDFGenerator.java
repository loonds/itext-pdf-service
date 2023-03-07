package com.loonds.genratepdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

    public byte[] generatePDF2() {

        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, baos);
            document.open();


            // Add the invoice header
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            Chunk chunk = new Chunk("Invoice", font);
            document.add(chunk);

            // Add the invoice table
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);

            PdfPCell cell = new PdfPCell(new Phrase("Product"));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Price"));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Quantity"));
            table.addCell(cell);

            table.setHeaderRows(1);

            table.addCell("Item 1");
            table.addCell("$100");
            table.addCell("1");

            table.addCell("Item 2");
            table.addCell("$50");
            table.addCell("2");

            document.add(table);

            // Add the invoice total
            font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            chunk = new Chunk("Total: $250", font);
            document.add(chunk);


            Paragraph paragraph = new Paragraph();
            paragraph.add("Hello, World!");
            document.add(paragraph);
            addLogo(document);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    private void addLogo(Document document) {
        try {
            Image img = Image.getInstance("C:/Users/IT-JAVA/Downloads/avatar.png");
            img.scalePercent(55, 55);
            img.setAlignment(Element.ALIGN_RIGHT);
            document.add(img);
        } catch (DocumentException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void addFooter(Document document) {
        try {
            Image img = Image.getInstance("C:/Users/IT-JAVA/Downloads/avatar.png");
            img.scalePercent(55, 55);
            img.setAlignment(Element.ALIGN_RIGHT);
            document.add(img);
        } catch (DocumentException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
