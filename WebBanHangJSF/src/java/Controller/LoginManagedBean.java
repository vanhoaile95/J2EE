/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectSQL;
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
        }catch(Exception e){}
    }
 
    public String checkdangky(boolean check)
    {
        this.checkeddangky = check;
        return "Login";
    }
    
    public void checklogin()
    {
         HttpSession hs = Util.getSession();
         userloginsession = (String) hs.getAttribute("username");
         if(userloginsession == null)
         {
             redirect("Login.xhtml");
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
           
        }catch(Exception e){}
        
        
        if(pass.equals(value))
            {
                HttpSession hs = Util.getSession();
                hs.setAttribute("username",user);
                
                return "Home?faces-redirect=true";
            }
        
      return "Login";
        
      
    }
    public String logout()
    {
        return "Login";
    }
}
    

