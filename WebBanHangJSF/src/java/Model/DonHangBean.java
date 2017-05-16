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
public class DonHangBean {
    String trangthai1="0";
    String trangthai2="1";
    String trangthai3="2";
    String STT;
    String maDH;
    String maNV;
    String ngayDH;
    String tienVanChuyen;
    String tongTien;
    String trangThai;

    public void setTrangthai1(String trangthai1) {
        this.trangthai1 = trangthai1;
    }

    public void setTrangthai2(String trangthai2) {
        this.trangthai2 = trangthai2;
    }

    public void setTrangthai3(String trangthai3) {
        this.trangthai3 = trangthai3;
    }

    public String getTrangthai1() {
        return trangthai1;
    }

    public String getTrangthai2() {
        return trangthai2;
    }

    public String getTrangthai3() {
        return trangthai3;
    }
    
    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }
    
    public String getMaDH() {
        return maDH;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getNgayDH() {
        return ngayDH;
    }

    public String getTienVanChuyen() {
        return tienVanChuyen;
    }

    public String getTongTien() {
        return tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setNgayDH(String ngayDH) {
        this.ngayDH = ngayDH;
    }

    public void setTienVanChuyen(String tienVanChuyen) {
        this.tienVanChuyen = tienVanChuyen;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public DonHangBean(String maDH, String maNV, String ngayDH, String tienVanChuyen, String tongTien, String trangThai) {
        this.maDH = maDH;
        this.maNV = maNV;
        this.ngayDH = ngayDH;
        this.tienVanChuyen = tienVanChuyen;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public DonHangBean() {
        this.maDH = "";
        this.maNV = "";
        this.ngayDH = "";
        this.tienVanChuyen = "";
        this.tongTien = "";
        this.trangThai = "0";
    }
            
}
