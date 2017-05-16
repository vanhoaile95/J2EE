/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.dbutils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    String trangThai;
    String tenKH;
    String tinhKH;
    String huyenKH;
    String diaChiKH;
    String SoDTKH;
    List<SanPhamDH> listSP;
    List<DonHangBean> listDH;
    

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
        this.listSP = new ArrayList<SanPhamDH>();
        this.listDH = new ArrayList<DonHangBean>();
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
        this.listDH = new ArrayList<DonHangBean>();
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

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public void setTinhKH(String tinhKH) {
        this.tinhKH = tinhKH;
    }

    public void setHuyenKH(String huyenKH) {
        this.huyenKH = huyenKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public void setSoDTKH(String SoDTKH) {
        this.SoDTKH = SoDTKH;
    }

    public void setListSP(List<SanPhamDH> listSP) {
        this.listSP = listSP;
    }

    public void setListDH(List<DonHangBean> listDH) {
        this.listDH = listDH;
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

    public String getTenKH() {
        return tenKH;
    }

    public String getTinhKH() {
        return tinhKH;
    }

    

    public String getHuyenKH() {
        return huyenKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public String getSoDTKH() {
        return SoDTKH;
    }

    public List<SanPhamDH> getListSP() {
        return listSP;
    }

    public List<DonHangBean> getListDH() {
        return listDH;
    }
    
    public void init(String MaDH) 
    {
        dbutils db=new dbutils();
        ResultSet dataRs;
        if(MaDH.equals(""))
        {
            String query="select dh.MaDonHang,us.HoTen,dh.NgayDonHang,dh.TienVanChuyen,dh.TongTien,dh.TrangThai from DonHang dh\n" +
                            " inner join UserDetail us on us.ID=dh.IDUser";
            System.out.println("init query:   "+query);
            dataRs=db.get(query);
            int i=1;
            try {
                while (dataRs.next())
                {
                    DonHangBean DonHang=new DonHangBean();
                    DonHang.setSTT(String.valueOf(i++));
                    DonHang.setMaDH(dataRs.getString("MaDonHang"));
                    DonHang.setMaNV(dataRs.getString("HoTen"));
                    DonHang.setNgayDH(dataRs.getString("NgayDonHang"));
                    DonHang.setTienVanChuyen(dataRs.getString("TienVanChuyen"));
                    DonHang.setTongTien(dataRs.getString("TongTien"));
                    DonHang.setTrangThai(dataRs.getString("TrangThai"));
                    this.listDH.add(DonHang);
                }
                dataRs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            String query="select dh.*, us.HoTen from DonHang dh\n" +
                            "inner join UserDetail us on us.ID=dh.IDUser\n" +
                            "where dh.MaDonHang='"+MaDH+"'";
            System.out.println("init query:   "+query);
            dataRs=db.get(query);
            
             try {
                while (dataRs.next())
                {
                    
                    this.maDH=dataRs.getString("MaDonHang");
                    this.maNV=dataRs.getString("HoTen");
                    this.ngayDH=dataRs.getString("NgayDonHang");
                    this.tienVanChuyen=dataRs.getString("TienVanChuyen");
                    this.tongTien=dataRs.getString("TongTien");
                    this.trangThai=dataRs.getString("TrangThai");
                    this.tenKH=dataRs.getString("TenKH");
                    this.tinhKH=dataRs.getString("TinhKH");
                    this.huyenKH=dataRs.getString("HuyenKH");
                    this.diaChiKH=dataRs.getString("DiaChiKH");
                    this.SoDTKH=dataRs.getString("SoDTKH");
                }
                dataRs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String query1 ="select dhdt.*,sp.TenSP from DonHang dh\n" +
                            "inner join DonHangDetail dhdt on dhdt.MaDonHang=dh.MaDonHang\n" +
                            "inner join SanPham sp on sp.MaSP=dhdt.MaSP\n" +
                            "where dh.MaDonHang='"+MaDH+"'";
            System.out.println("init query:   "+query1);
            dataRs=db.get(query1);
            int i=1;
             try {
                while (dataRs.next())
                {
                    
                    SanPhamDH sp=new SanPhamDH();
                    sp.setSTT(String.valueOf(i++));
                    sp.setMaSP(dataRs.getString("MaSP"));
                    sp.setTenSP(dataRs.getString("TenSP"));
                    sp.setSoluong( Integer.parseInt(dataRs.getString("SoLuongMua")) );
                    sp.setGiaSP(dataRs.getString("DonGia"));
                    sp.setThanhTien(dataRs.getString("ThanhTien"));
                    
                    this.listSP.add(sp);
                }
                dataRs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        db.shutDown();
    }
    
    public Boolean insert()
    {
        dbutils db=new dbutils();
        String sql="";
        System.out.println(sql);
                    try 
			{
				db.getConnection().setAutoCommit(false);
				if(!db.update(sql))
				{	
					db.update("rollback");
					
					return false;
				}

				db.getConnection().commit();
				db.getConnection().setAutoCommit(true);
                                db.shutDown();
                                return true;
			} 
			catch(Exception e) 
			{
				db.update("rollback");
				e.printStackTrace();
                                db.shutDown();
                                return false;
			}
                    
                            
    }
    public Boolean save()
    {
        dbutils db=new dbutils();
        String sql="";
        System.out.println(sql);
                    try 
			{
				db.getConnection().setAutoCommit(false);
				if(!db.update(sql))
				{	
					db.update("rollback");
					
					return false;
				}

				db.getConnection().commit();
				db.getConnection().setAutoCommit(true);
                                db.shutDown();
                                return true;
			} 
			catch(Exception e) 
			{
				db.update("rollback");
				e.printStackTrace();
                                db.shutDown();
                                return false;
			}
                    
    }
}
