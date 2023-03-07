package com.loonds.genratepdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private PDFGenerator pdfGenerator;

    @GetMapping("/generate-pdf")
    public void generatePdf() {
        pdfGenerator.generatePDF();
    }

    @GetMapping("/download-pdf")
    public ResponseEntity<byte[]> downloadPdf() {
        byte[] pdfBytes = pdfGenerator.generatePDF2();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "example.pdf");
        headers.setContentLength(pdfBytes.length);

        return new ResponseEntity<>(pdfBytes, headers, 200);
    }
}
