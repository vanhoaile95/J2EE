/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Binh Nguyen
 */
@ManagedBean(name = "thongke")
@RequestScoped
public class ThongKeDoanhSo {

    private String TenSanPham;
    private int SL;
    public String thoigian;
    private String MaSP;
    private Float TongTien;
    private int SLTonKho;

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSLTonKho() {
        return SLTonKho;
    }

    public void setSLTOnKho(int SLTonKho) {
        this.SLTonKho = SLTonKho;
    }

    public Float getTongTien() {
        return TongTien;
    }

    public void setTongTien(Float TongTien) {
        this.TongTien = TongTien;
    }

    public String getTenSP() {
        return TenSanPham;
    }

    public void setTenSP(String tenSP) {
        this.TenSanPham = tenSP;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

}
