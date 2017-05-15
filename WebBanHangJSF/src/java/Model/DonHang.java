/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phanlam
 */
public class DonHang {
    
    String maDH;
    String maNV;
    String ngayDH;
    String tienVanChuyen;
    String tongTien;
    String tenKH;
    String tinhKH;
    String huyenKH;
    String diaChiKH;
    String SoDTKH;
    List<SanPhamDH> listSP;

    public DonHang(String maDH, String maNV, String ngayDH, String tienVanChuyen, String tongTien, String tenKH, String tinhKH, String huyenKH, String diaChiKH, String SoDTKH, List<SanPhamDH> listSP) {
        this.maDH = maDH;
        this.maNV = maNV;
        this.ngayDH = ngayDH;
        this.tienVanChuyen = tienVanChuyen;
        this.tongTien = tongTien;
        this.tenKH = tenKH;
        this.tinhKH = tinhKH;
        this.huyenKH = huyenKH;
        this.diaChiKH = diaChiKH;
        this.SoDTKH = SoDTKH;
        this.listSP = listSP;
    }

    public DonHang() {
        this.maDH = "";
        this.maNV = "";
        this.ngayDH = "";
        this.tienVanChuyen = "";
        this.tongTien = "";
        this.tenKH = "";
        this.tinhKH = "";
        this.huyenKH = "";
        this.diaChiKH = "";
        this.SoDTKH = "";
        this.listSP = new ArrayList<SanPhamDH>();
    }
    
    public void init()
    {
        
    }
    
    public int insert()
    {
        return 0;
    }
    
}
