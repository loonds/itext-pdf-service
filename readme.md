## Some important terms related to iText jar:
1. Document: It represents a pdf document.
2. Chunk: It specifies the smallest unit of text as a string with pre-defined font.
3. Phrase: It is used to combine the more than one chunks and add spacing between the lines.
4. Paragraph: It is a subclass of Phrase and represents the paragraph of the text. Using Paragraph class we can manage paragraph alignment, spacing etc.
5. Anchor: It is a subclass of Paragraph and represents a link, simply like a website link.
6. List: It represents a list of items and can be ordered or unordered.
7. Table: It is used to add the table in the pdf file. We have to define the number of columns in the PdfTable constructor.
8. Image: It is used to add the image in the pdf file. We can specify the image properties like position, alignment, border etc.
9. Font: It is used to specify the font style of the text.
10. Chapter: It is used to add the chapter in the pdf file.
11. Section: It is used to add the section in the pdf file.