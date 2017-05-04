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



@ManagedBean
@SessionScoped
public class LoginManagedBean implements Serializable{

   
    private String user;
    private String pass;
    private String userloginsession;
    public boolean checkeddangky = false;
    public boolean loginfailed = false;
    public boolean checkedduytri = true;

    public boolean isCheckedduytri() {
        return checkedduytri;
    }

    public void setCheckedduytri(boolean checkedduytri) {
        this.checkedduytri = checkedduytri;
    }

    public boolean isLoginfailed() {
        return loginfailed;
    }

    public void setLoginfailed(boolean loginfailed) {
        this.loginfailed = loginfailed;
    }

    public boolean isCheckeddangky() {
        return checkeddangky;
    }

    public void setCheckeddangky(boolean checkeddangky) {
        this.checkeddangky = checkeddangky;
    }

   

    public String getUserloginsession() {
        return userloginsession;
    }

    public void setUserloginsession(String userloginsession) {
        this.userloginsession = userloginsession;
    }

    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    private void redirect(String page)
    {
        try{
             FacesContext fc = FacesContext.getCurrentInstance();
              fc.getExternalContext().redirect(page);
        }catch(IOException e){}
    }
 
    //Ham kiểm tra khi nhấn nút đăng ký thì page Login.xhtml sẽ tự click button Đăng ký
    public String checkdangky(boolean check)
    {
        this.checkeddangky = check;
        return "Login?faces-redirect=true";
    }
    
    
    public void checklogin()
    {
        //Check khi vào page thì có login chưa ,, nếu chưa thì redirect sang Login
         HttpSession hs = Util.getSession();
         userloginsession = (String) hs.getAttribute("username");
         if(userloginsession == null)
         {
             //redirect("Login.xhtml");
         } 
         
    }
    public String login()
    {
        ConnectSQL Db = new ConnectSQL();
        Connection conn =  Db.getConnectDB();
        
   
        String query = "Select Password from UserLogin where Username ='" + user + "'";
        String value = null;
        try{
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            value = rs.getString("Password");
           
        }catch(SQLException e){}
        
        
        if(pass.equals(value))
            {
              
                HttpSession hs = Util.getSession();
                hs.setAttribute("username",user);
                userloginsession = user;
               
                loginfailed = false;
                
                return "Home?faces-redirect=true";
            }
      loginfailed = true;
      return "Login";
        
      
    }
    public String logout()
    {
        userloginsession = null;
        HttpSession hs = Util.getSession();
        hs.setAttribute("username",null);
        return "Home?faces-redirect=true";
        
    }
}
    

