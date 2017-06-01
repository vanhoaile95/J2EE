/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DocTien;
import Model.DonHang;
import Model.SanPhamDH;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
            
             DonHang donhang=new DonHang();
             donhang.init(maDH);
             float CONVERT = 28.346457f;// 1 cm
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
            Document document = new Document(PageSize.A4, 0.5f*CONVERT, 0.5f*CONVERT, 1.0f*CONVERT, 1.0f*CONVERT);
            //step 2: we create a writer that listens to the document
            // and directs a PDF-stream to a temporary buffer
            ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
            PdfWriter writer = PdfWriter.getInstance( document, baos);
            BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(bf, 18, Font.BOLD);
			Font font11 = new Font(bf, 11, Font.NORMAL);
                        Font font11_bo = new Font(bf, 11, Font.BOLD);
                        Font font12 = new Font(bf, 12, Font.NORMAL);
			Font font10 = new Font(bf, 10,Font.NORMAL);
			Font font9 = new Font(bf, 9,Font.NORMAL);
            //step 3: we open the document
            document.open();
            
                PdfPTable tab_Header1;
		tab_Header1 = new PdfPTable(1);
		tab_Header1.setWidthPercentage(100);
		
		tab_Header1.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1;
		cell1 = new PdfPCell(new Phrase("CÔNG TY TNHH ABC FASHION", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                
		cell1 = new PdfPCell(new Phrase("Địa chỉ: 146 Linh Trung,P. Linh Trung, Q. Thủ Đức, TP HCM", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("SĐT: 0909465621", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("ĐƠN GIAO HÀNG", font12));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Bên Bán:", font11_bo));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Tên: CÔNG TY TNHH ABC FASHION", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Địa chỉ: 146 Linh Trung,P. Linh Trung, Q. Thủ Đức, TP HCM", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                
                
                
                cell1 = new PdfPCell(new Phrase("Số điện thoại: 0909465621", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                
                cell1 = new PdfPCell(new Phrase("Bên Mua:", font11_bo));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Tên: "+donhang.getTenKH(), font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Địa chỉ: "+donhang.getDiaChiKH(), font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                
                
                
                cell1 = new PdfPCell(new Phrase("Số điện thoại: "+donhang.getSoDTKH(), font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                
                cell1 = new PdfPCell(new Phrase("Bên Vận chuyển:", font11_bo));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Tên:....................................", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Địa chỉ:...............................", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                
                
                
                cell1 = new PdfPCell(new Phrase("Số điện thoại:...............................", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                
                cell1 = new PdfPCell(new Phrase("Danh sách hàng hóa:", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                ///////////////////////////////bản sản phẩm
                float[] crDonHang = { 1.0f*CONVERT,4.0f*CONVERT,1.0f*CONVERT,2.0f*CONVERT,2.0f*CONVERT};
		
		PdfPTable tab_Header2;
		tab_Header2 = new PdfPTable(crDonHang.length);
		tab_Header2.setWidthPercentage(100);
		tab_Header2.setWidths(crDonHang);
		tab_Header2.setHorizontalAlignment(Element.ALIGN_CENTER);
                NumberFormat formatter = new DecimalFormat("#,###,###"); 
                
                String[] crheader={"STT","Tên Hàng","Số Lượng","Giá Bán(VNĐ)","Thành Tiền(VNĐ)"};
                
                for(int i=0;i<crheader.length;i++)
                {
                    PdfPCell cell = new PdfPCell(new Phrase(crheader[i], font11));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
                    tab_Header2.addCell(cell);
                }
                int stt=1;
                for(SanPhamDH sp:donhang.getListSP())
                {
                    
                    
                        PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(stt), font11));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    
                        tab_Header2.addCell(cell);
                        
                        cell = new PdfPCell(new Phrase(sp.getTenSP(), font11));
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    
                        tab_Header2.addCell(cell);
                        
                        cell = new PdfPCell(new Phrase(sp.getSoluong(), font11));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    
                        tab_Header2.addCell(cell);
                        
                         cell = new PdfPCell(new Phrase(formatter.format(Double.parseDouble(sp.getGiaSP())), font11));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    
                        tab_Header2.addCell(cell);
                        
                        cell = new PdfPCell(new Phrase(formatter.format(Double.parseDouble(sp.getThanhTien())), font11));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    
                        tab_Header2.addCell(cell);
                    
                        stt++;
                }
                cell1 = new PdfPCell(tab_Header2);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Tổng tiền hàng:   "+formatter.format(Double.parseDouble(donhang.getTienTamTinh()==null?"0":donhang.getTienTamTinh()))+" VNĐ", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Tổng tiền vận chuyển:   "+formatter.format(Double.parseDouble(donhang.getTienVanChuyen()==null?"0":donhang.getTienVanChuyen()))+" VNĐ", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                
                cell1 = new PdfPCell(new Phrase("Tổng tiền thanh toán:   "+formatter.format(Double.parseDouble(donhang.getTongTien()))+" VNĐ", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Số tiền thanh toán bằng chữ: "+DocTien.doctien(donhang.getTongTien().replaceAll(" ", ""))+"đồng", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase(" ", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                
                cell1 = new PdfPCell(new Phrase("TP Hồ Chí Minh, ngày      tháng       năm       ", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell1.setPaddingRight(1.0f*CONVERT);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase(" ", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header1.addCell(cell1);
                
                PdfPTable tab_Header3;
		tab_Header3 = new PdfPTable(3);
		tab_Header3.setWidthPercentage(100);
		
		tab_Header3.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                cell1 = new PdfPCell(new Phrase("Người nhận hàng", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header3.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Người giao hàng", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header3.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("Người bán hàng", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header3.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("(kí và ghi rõ họ tên)", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header3.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("(kí và ghi rõ họ tên)", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header3.addCell(cell1);
                
                cell1 = new PdfPCell(new Phrase("(kí và ghi rõ họ tên)", font11));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setPaddingBottom(5.0f);
		cell1.setBorder(0);
		tab_Header3.addCell(cell1);
                
                cell1 = new PdfPCell(tab_Header3);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
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
