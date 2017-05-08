/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author HOAI
 */
public class Login {
    public String Username;
    public String Password;
    public String ErrorMessage;
    public String Session;
    public boolean DuytriLogin = true;
    public boolean FirstAccessAdminPage = false;

    public boolean isFirstAccessAdminPage() {
        return FirstAccessAdminPage;
    }

    public void setFirstAccessAdminPage(boolean FirstAccessAdminPage) {
        this.FirstAccessAdminPage = FirstAccessAdminPage;
    }
    

    public boolean isDuytriLogin() {
        return DuytriLogin;
    }

    public void setDuytriLogin(boolean DuytriLogin) {
        this.DuytriLogin = DuytriLogin;
    }

  
    

    public String getSession() {
        return Session;
    }

    public void setSession(String Session) {
        this.Session = Session;
    }
    

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }
    
}
