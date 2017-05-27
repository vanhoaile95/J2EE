/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectSQL;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import Model.*;


@ManagedBean
@SessionScoped
public class LoginManagedBean implements Serializable{

   
    
    public boolean PageDangKy = false;
    public Register ModelDangKy = new Register();
    public Login ModelLogin = new Login();

    public boolean isPageDangKy() {
        return PageDangKy;
    }

    public void setPageDangKy(boolean PageDangKy) {
        this.PageDangKy = PageDangKy;
    }

    
    public Register getModelDangKy() {
        return ModelDangKy;
    }

    public void setModelDangKy(Register ModelDangKy) {
        this.ModelDangKy = ModelDangKy;
    }

    public Login getModelLogin() {
        return ModelLogin;
    }

    public void setModelLogin(Login ModelLogin) {
        this.ModelLogin = ModelLogin;
    }
    
    private void redirect(String page)
    {
        try{
             FacesContext fc = FacesContext.getCurrentInstance();
              fc.getExternalContext().redirect(page);
        }catch(IOException e){}
    }
 
    //Ham kiểm tra khi nhấn nút đăng ký thì page Login.xhtml sẽ tự click button Đăng ký
    public String directpagedangky(boolean check)
    {
        this.PageDangKy = check;
        return "Login?faces-redirect=true";
    }
    
    
    public void checklogin()
    {
        //Check khi vào page thì có login chưa ,, nếu chưa thì redirect sang Login
         HttpSession hs = Util.getSession();
         this.ModelLogin.Session = (String) hs.getAttribute("username");
         if(this.ModelLogin.Session == null)
         {
             //redirect("Login.xhtml");
         } 
         
    }
    public String login()
    {
        ConnectSQL Db = new ConnectSQL();
        Connection conn =  Db.getConnectDB();
       
   
        String query = "Select Password from UserLogin where Username ='" + this.ModelLogin.Username + "'";
        String value = null;
        try{
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            value = rs.getString("Password");
           
        }catch(SQLException e){}
        
        
        if(this.ModelLogin.Password.equals(value))
            {
              
                HttpSession hs = Util.getSession();
                hs.setAttribute("username",this.ModelLogin.Username);
                this.ModelLogin.Session = this.ModelLogin.Username;
               
              
                this.ModelLogin.ErrorMessage = "Tài khoản hoặc password sai, vui lòng nhập lại !";
                
                return "Home?faces-redirect=true";
            }
        
      
      return "Login";
        
      
    }
    public String logout()
    {
       this.ModelLogin.Session = null;
        HttpSession hs = Util.getSession();
        hs.setAttribute("username",null);
        return "Home?faces-redirect=true";
        
    }
    
    public String register()
    {
        
        //Kiểm tra độ dài user
         if(this.ModelDangKy.Username.length()  < 4)
        {
             this.ModelDangKy.ErrorMessage = "Tài khoản tối thiểu 4 ký tự !";
                       return "Login";
        }
        //Kiểm tra nhập 2 lần mật khẩu trùng nhau ko
        if(!this.ModelDangKy.Password.equals(this.ModelDangKy.RePassword))
        {
            this.ModelDangKy.ErrorMessage = "'Mật khẩu' và 'Nhập lại mật khẩu' không chính xác !";
                       return "Login";
        }
        //Kiểm tra độ dài mật khẩu
        if(this.ModelDangKy.Password.length()  < 6)
        {
             this.ModelDangKy.ErrorMessage = "Mật khẩu tối thiểu 6 ký tự !";
                       return "Login";
        }
        
      
         ConnectSQL Db = new ConnectSQL();
        Connection conn =  Db.getConnectDB();
       
   
        String query = "Select Username from UserLogin";
        String value = null;
        try{
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next())
            {
                value = rs.getString("Username");
                if (this.ModelDangKy.Username.equals(value))
                {
                       this.ModelDangKy.ErrorMessage = "Tài khoản này đã được đăng ký ,vui lòng nhập tài khoản khác !";
                       return "Login";
                }
            
            }
           
        }catch(SQLException e){}
     
        //Nếu đăng ký thành công
        query = "INSERT INTO UserLogin (Username,Password,PermissionID) VALUES (?,?,?)";
        
        try{
           
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, this.ModelDangKy.Username);
            p.setString(2, this.ModelDangKy.Password);
            p.setString(3, "2");
            p.executeQuery();
            
             
             
        }catch(SQLException e){}
        
        
        
      
                HttpSession hs = Util.getSession();
                hs.setAttribute("username",this.ModelDangKy.Username);
                this.ModelLogin.Session = this.ModelDangKy.Username;
               
           
                return "Home?faces-redirect=true";
        
        
    }
}
    

