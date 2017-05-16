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

/**
 *
 * @author phanlam
 */
@Named(value = "donHangManagedBean")
@SessionScoped
public class DonHangManagedBean implements Serializable {

    private DonHang donHang;

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
        donHang=new DonHang();
        this.donHang.init("");
    }
    
    public String DonHangList()
    {
        return "QLDonHang";
    }
    
    public String DonHangChiTiet(String maDH)
    {
         //this.donHang.init(maDH);
        return "OrderDetail";
    }
    
    public String DonHangNew()
    {
        //nhập danh sách sảnh phẩm vào đơn hàng (listSP)
        return "Order";
    }
    
    public String DonHangSave()
    {
        //nhập danh sách sảnh phẩm vào đơn hàng (listSP)
        return "Home";
    }
    
    public String DonHangDelete(String maDH)
    {
        //xử lý trạng thái
        return "QLDonHang";
    }
    
     public String DonHangDuyet(String maDH)
    {
        //xử lý trạng thái
        return "QLDonHang";
    }
    
    public String DonHangListUpdate(int maUpdate)
    {
        //this.donHang.init("");
        return "QLDonHang";
    }
    
    public String TimKiem(String TrangThai)
    {
        System.out.println("trạng thiais tìm kiếm: "+TrangThai);
        //this.donHang.init("");
        return "QLDonHang";
    }
    
}
