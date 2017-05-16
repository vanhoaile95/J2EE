/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Table;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author phanlam
 */
@Named(value = "printOrderManagedBean")
@RequestScoped
public class PrintOrderManagedBean {

    /**
     * Creates a new instance of PrintOrderManagedBean
     */
    public PrintOrderManagedBean() {
    }
    public void executePDF(String maDH) {
            try {
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = 
            (HttpServletResponse) faces.getExternalContext().getResponse();
            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            //response.setHeader("Content-disposition","inline; filename=kiran.pdf");
            response.setHeader("Pragma", "public"); 
            response.setContentType( "application/pdf" );
            //response.setHeader("Content-Disposition", "attachment;filename=\"ContactList.pdf\"");
            response.addHeader("Content-disposition", "attachment;filename=\"DataListBean.pdf\"");
            //step 1: creation of a document-object
            Document document = new Document(PageSize.A4, 10, 10, 10, 10);
            //step 2: we create a writer that listens to the document
            // and directs a PDF-stream to a temporary buffer
            ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
            PdfWriter writer = PdfWriter.getInstance( document, baos);
            BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(bf, 18, Font.BOLD);
			Font font2 = new Font(bf, 11, Font.BOLD);
			Font font10 = new Font(bf, 10,Font.BOLD);
			Font font9 = new Font(bf, 9,Font.NORMAL);
            //step 3: we open the document
            document.open();
            
                PdfPTable tab_Header1;
		tab_Header1 = new PdfPTable(1);
		tab_Header1.setWidthPercentage(100);
		
		tab_Header1.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1;
		cell1 = new PdfPCell(new Phrase("hóa đơn", font10));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                document.add(tab_Header1);
            
            document.close();
            //step 6: we output the writer as bytes to the response output
            // the contentlength is needed for MSIE!!!
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            ServletOutputStream out = response.getOutputStream();
            baos.writeTo(out);
            baos.flush();
            faces.responseComplete();
            
            } catch(Exception e) {
            e.printStackTrace();
            }
            }

}
