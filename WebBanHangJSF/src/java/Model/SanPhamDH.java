/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author phanlam
 */
public class SanPhamDH {
    
    String STT;
    String tenSP;
    String soluong;
    String giaSP;
    String imgSP;
    String ghiChu;
    String maSP;
    String thanhTien;

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }
    
    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getThanhTien() {
        return thanhTien;
    }
    

    public SanPhamDH() {
        this.tenSP = "";
        this.giaSP = "";
        this.imgSP = "";
        this.ghiChu = "";
        this.maSP = "";
        this.soluong="0";
        this.thanhTien="";
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public void setImgSP(String imgSP) {
        this.imgSP = imgSP;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public String getImgSP() {
        return imgSP;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public SanPhamDH(String tenSP, String giaSP, String imgSP, String ghiChu, String maSP, String soLuong , String thanhTien) {
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.imgSP = imgSP;
        this.ghiChu = ghiChu;
        this.maSP = maSP;
        this.soluong=soLuong;
        this.thanhTien=thanhTien;        
    }
    
    
}
