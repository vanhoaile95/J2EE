/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Binh Nguyen
 */
@Named(value = "printBean")
@SessionScoped
public class printBean implements Serializable {

    /**
     * Creates a new instance of printBean
     */
     private static String FILE = "d:/BaoCao.pdf";
    public void inBaoCao() {
        
        Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream(FILE));

            document.open();
            document.add(new Paragraph("A Hello World PDF document."));
            document.close(); // no need to close PDFwriter?

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
