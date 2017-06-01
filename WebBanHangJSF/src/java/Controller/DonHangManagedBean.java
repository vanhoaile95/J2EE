/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DonHang;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phanlam
 */
@Named(value = "donHangManagedBean")
@SessionScoped
public class DonHangManagedBean implements Serializable {

    private DonHang donHang;
    private String TrangThai;

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }
    
    /**
     * Creates a new instance of DonHangManagedBean
     */
    public DonHangManagedBean() {
         HttpSession sesion=Util.getSession();
         sesion.setAttribute("abc", "fdgnfjdngj");
        donHang=new DonHang();
        this.donHang.init("");
    }
    
    public String DonHangList()
    {
        this.donHang.init("");
        return "QLDonHang";
    }
    
    public String DonHangChiTiet(String maDH)
    {
         //this.donHang.init(maDH);
        System.out.println("mã đơn hàng detail:    "+maDH);
        this.donHang.init(maDH);
        
        
        return "OrderDetail";
    }
    
    public String DonHangNew()
    {
        //nhập danh sách sảnh phẩm vào đơn hàng (listSP)
        return "Order";
    }
    
    
    
    public String DonHangSave()//insert
    {
        //nhập danh sách sản phẩm vào đơn hàng (listSP)
        HttpSession sesion=Util.getSession();
            HttpServletRequest request = 
            Util.getRequest();
            
        if(this.donHang.insert())
        {
            return "Order";
        }
        
        System.err.println("ten: "+donHang.getTenKH());
        System.err.println("so dt: "+donHang.getSoDTKH());
        System.err.println("dia chi: "+donHang.getDiaChiKH());
        System.err.println("Tinh:  "+donHang.getTinhKH());
        System.err.println("huyen: "+donHang.getHuyenKH());
        return "Home";
    }
    
    public String action()
    {
        
        return "Order";
    }
    
    public String DonHangDelete(String maDH)
    {
        //xử lý trạng thái
        HttpSession sesion=Util.getSession();
            HttpServletRequest request = Util.getRequest();
            String usename=(String)sesion.getAttribute("username");
            System.out.println("ten dang nhap:   "+ usename);
            if(this.donHang.save("1", usename, maDH))
            {
                this.donHang.init("");
            }
            
        return "QLDonHang";
    }
    
     public String DonHangDuyet(String maDH)
    {
        //xử lý trạng thái
       HttpSession sesion=Util.getSession();
            HttpServletRequest request = Util.getRequest();
            String usename=(String)sesion.getAttribute("username");
            System.out.println("ten dang nhap:   "+ usename);
            if(this.donHang.save("2", usename, maDH))
            {
                this.donHang.init("");
            }
            
        return "QLDonHang";
    }
    
    public String DonHangListUpdate(int maUpdate)
    {
        //this.donHang.init("");
        return "QLDonHang";
    }
    
    public String TimKiem(ValueChangeEvent event)
    {
        System.out.println("trạng thiais tìm kiếm: "+event.getNewValue());
        this.donHang.TimKiem(event.getNewValue().toString());
        return "QLDonHang";
    }
    
}
