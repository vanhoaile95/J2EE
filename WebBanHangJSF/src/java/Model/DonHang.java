/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.dbutils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author phanlam
 */
public class DonHang {
    
    String maDH;
    String maNV;
    String ngayDH;
    String tienTamTinh;
    String tienVanChuyen;
    String tongTien;
    String trangThai;
    String tenKH;
    String tinhKH;
    String huyenKH;
    String diaChiKH;
    String SoDTKH;
    String thoiGianGiaoHang;
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
        this.tienTamTinh="0";
        this.tienVanChuyen = "0";
        this.tongTien = "0";
        this.tenKH = "";
        this.tinhKH = "";
        this.huyenKH = "";
        this.diaChiKH = "";
        this.SoDTKH = "";
        Calendar now5 = Calendar.getInstance();
                Calendar now0 = Calendar.getInstance();
               
                    now5.set(now0.get(Calendar.YEAR), now0.get(Calendar.MONTH), now0.get(Calendar.DATE));
                    
                    now5.add(Calendar.DATE, 5);
                    
                    this.thoiGianGiaoHang="(Giao hàng kể từ ngày "+ now0.get(Calendar.DATE) +"/"+ (now0.get(Calendar.MONTH) + 1) +"/"+ now0.get(Calendar.YEAR)+ 
                        " Đến ngày " +now5.get(Calendar.DATE)+"/"+(now5.get(Calendar.MONTH) + 1)+"/"+now5.get(Calendar.YEAR)+")";
                
        this.listSP = new ArrayList<SanPhamDH>();
        this.listDH = new ArrayList<DonHangBean>();
    }

    public String getThoiGianGiaoHang() {
        return thoiGianGiaoHang;
    }

    public void setThoiGianGiaoHang(String thoiGianGiaoHang) {
        this.thoiGianGiaoHang = thoiGianGiaoHang;
    }

    
    
    
    public String getTienTamTinh() {
        return tienTamTinh;
    }

    public void setTienTamTinh(String tienTamTinh) {
        this.tienTamTinh = tienTamTinh;
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
        List<DonHangBean> donhanlist=new ArrayList<DonHangBean>();
        dbutils db=new dbutils();
        ResultSet dataRs;
        if(MaDH.equals(""))
        {
            String query="select dh.MaDonHang,us.HoTen,dh.NgayDonHang,dh.TienTamTinh,dh.TienVanChuyen,dh.TongTien,dh.TrangThai from DonHang dh\n" +
                            " inner join NhanVien us on us.MaNV=dh.MaNV";
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
                    DonHang.setTienTamTinh(dataRs.getString("TienTamTinh"));
                    DonHang.setTienVanChuyen(dataRs.getString("TienVanChuyen"));
                    DonHang.setTongTien(dataRs.getString("TongTien"));
                    DonHang.setTrangThai(dataRs.getString("TrangThai"));
                    donhanlist.add(DonHang);
                }
                this.listDH=donhanlist;
                dataRs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            String query="select dh.*, us.HoTen from DonHang dh\n" +
                            "inner join NhanVien us on us.MaNV=dh.MaNV\n" +
                            "where dh.MaDonHang='"+MaDH+"'";
            System.out.println("init query:   "+query);
            dataRs=db.get(query);
            
             try {
                while (dataRs.next())
                {
                    
                    this.maDH=dataRs.getString("MaDonHang");
                    this.maNV=dataRs.getString("HoTen");
                    this.ngayDH=dataRs.getString("NgayDonHang");
                    this.tienTamTinh=dataRs.getString("TienTamTinh");
                    this.tienVanChuyen=dataRs.getString("TienVanChuyen");
                    this.tongTien=dataRs.getString("TongTien");
                    this.trangThai=dataRs.getString("TrangThai");
                    this.tenKH=dataRs.getString("TenKH");
                    this.tinhKH=dataRs.getString("TinhKH");
                    this.huyenKH=dataRs.getString("HuyenKH");
                    this.diaChiKH=dataRs.getString("DiaChiKH");
                    this.SoDTKH=dataRs.getString("SoDTKH");
                }
                
                //thời gian giao hàng
                String thoiGian=this.ngayDH.substring(0,10);
                 System.err.println(thoiGian);
                Date date1=null;
                if(this.ngayDH.length()>0)
                {
                    try {
                        date1=new SimpleDateFormat("yyyy-MM-dd").parse(thoiGian);
                    } catch (ParseException ex) {
                        Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Calendar now6 = Calendar.getInstance();
                Calendar now1 = Calendar.getInstance();
                if(date1!=null)
                {
                    now6.set(date1.getYear()+1900, date1.getMonth(), date1.getDate());
                    now1.set(date1.getYear()+1900, date1.getMonth(), date1.getDate());
                    now6.add(Calendar.DATE, 6);
                    now1.add(Calendar.DATE, 1);
                    this.thoiGianGiaoHang="(Giao hàng kể từ ngày "+ now1.get(Calendar.DATE) +"/"+ (now1.get(Calendar.MONTH) + 1) +"/"+ now1.get(Calendar.YEAR)+ 
                        " Đến ngày " +now6.get(Calendar.DATE)+"/"+(now6.get(Calendar.MONTH) + 1)+"/"+now6.get(Calendar.YEAR)+")";
                }
                
                dataRs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             List<SanPhamDH> sanphamlist=new ArrayList<SanPhamDH>();
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
                    sp.setSoluong(dataRs.getString("SoLuongMua"));
                    sp.setGiaSP(dataRs.getString("DonGia"));
                    sp.setThanhTien(dataRs.getString("ThanhTien"));
                    
                    sanphamlist.add(sp);
                }
                this.listSP=sanphamlist;
                dataRs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        db.shutDown();
    }
    public void initDonHangDetail(String maDH)
    {
        
    }
    public Boolean insert()
    {
        ResultSet maDHRs=(new dbutils()).get("select count(*) as count from DonHang");
        try
        {
            while(maDHRs.next())
            {
                this.maDH="DH"+String.valueOf(maDHRs.getLong("count")+1);
            }
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                    return false;
                }
        
        
        dbutils db=new dbutils();
        
        String sql="insert into DonHang(MaDonHang,NgayDonHang,TienTamTinh,TienVanChuyen,TongTien,TrangThai,TenKH,TinhKH,HuyenKH,DiaChiKH,SoDTKH) \n" +
"			values ('"+this.maDH+"',GETDATE(),'"+this.tienTamTinh+"','"+this.tienVanChuyen+"','"+this.tongTien+"', \n"+
                                    "'0',N'"+this.tenKH+"',N'"+this.tinhKH+"',N'"+this.huyenKH+"',N'"+this.diaChiKH+"','"+this.SoDTKH+"')";
        System.out.println(sql);
                    try 
			{
				db.getConnection().setAutoCommit(false);
				if(!db.update(sql))
				{	
					db.update("rollback");
					
					return false;
				}
                                for(SanPhamDH sp:this.listSP)
                                {
                                    String sql2="insert into DonHangDetail(MaDonHang,MaSP,SoLuongMua,DonGia,ThanhTien) \n"+
                                            "values ('"+this.maDH+"','"+sp.getMaSP()+"','"+sp.getSoluong()+"','"+sp.getGiaSP()+"','"+sp.getThanhTien()+"')";
                                    System.out.println(sql2);
                                    if(!db.update(sql2))
                                    {	
                                            db.update("rollback");

                                            return false;
                                    } 
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
    public Boolean save(String trangthai, String usename, String maDonHang)
    {
        if(usename==null)
        {
            return false;
        }
        dbutils db=new dbutils();
        String sqlMNV="select nv.MaNV from NhanVien nv\n" +
                        " inner join UserLogin us on us.ID=nv.ID\n" +
                        " where us.Username='"+usename+"'";
        System.out.println(sqlMNV);
        ResultSet mavRs=db.get(sqlMNV);
        String maNV="";
        try {
            while(mavRs.next())
            {
                maNV=mavRs.getString("MaNV");
                
            }
            mavRs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
        String sql="update DonHang set TrangThai="+trangthai+" ,MaNV='"+maNV+"' where MaDonHang='"+maDonHang+"'";
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
    
    public void TimKiem(String trangthai)
    {
        List<DonHangBean> donhanlist=new ArrayList<DonHangBean>();
        dbutils db=new dbutils();
        ResultSet dataRs;
        
            String query="select dh.MaDonHang,us.HoTen,dh.NgayDonHang,dh.TienTamTinh,dh.TienVanChuyen,dh.TongTien,dh.TrangThai from DonHang dh\n" +
                            " inner join UserDetail us on us.ID=dh.IDUser \n"+
                               "where 1=1 ";
            if(!trangthai.equals("3"))
            {
                query+="and dh.TrangThai="+trangthai;
            }
            System.out.println("init query tim kiếm :   "+query);
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
                    DonHang.setTienTamTinh(dataRs.getString("TienTamTinh"));
                    DonHang.setTienVanChuyen(dataRs.getString("TienVanChuyen"));
                    DonHang.setTongTien(dataRs.getString("TongTien"));
                    DonHang.setTrangThai(dataRs.getString("TrangThai"));
                    donhanlist.add(DonHang);
                }
                this.listDH=donhanlist;
                dataRs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
