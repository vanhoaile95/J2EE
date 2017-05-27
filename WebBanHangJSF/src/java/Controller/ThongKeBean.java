/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectSQL;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Model.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Binh Nguyen
 */
@ManagedBean(name = "thongkeBean")
@SessionScoped

public class ThongKeBean implements Serializable {

    private ThongKeDoanhSo Thang = new ThongKeDoanhSo();

    public ThongKeDoanhSo getModelThang() {
        return Thang;
    }

    public void setModelThang(ThongKeDoanhSo Thang) {
        this.Thang = Thang;
    }

    public String Forward() {
        return "ThongKeDoanhSo?faces-redirect=true";
    }

    public List<ThongKeDoanhSo> getThongKe() {
        List<ThongKeDoanhSo> list = new ArrayList<ThongKeDoanhSo>();

        ConnectSQL Db = new ConnectSQL();
        Connection conn = Db.getConnectDB();

        ResultSet rs;
        String a = this.Thang.thoigian;
        String query = "execute ThongKeDoanhSo '" + this.Thang.thoigian + "'";
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                ThongKeDoanhSo tk = new ThongKeDoanhSo();
                String MaSP=rs.getString("MaSP");
                String TenSP = rs.getString("TenSP");
                int SL = rs.getInt("SL");
                tk.setMaSP(MaSP);
                tk.setTenSP(TenSP);
                tk.setSL(SL);
                list.add(tk);
            }
        } catch (SQLException e) {
            
        }

        return list;

    }
}
