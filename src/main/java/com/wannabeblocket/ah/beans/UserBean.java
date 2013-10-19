package com.wannabeblocket.ah.beans;

import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.validation.constraints.NotNull;
import javax.servlet.http.HttpServletRequest;
import javax.enterprise.context.RequestScoped;

@Named("user")
@RequestScoped
public class UserBean {

    @NotNull(message = "Ange ett användarnamn.")
    private String _name;
    
    @NotNull(message = "Ange ett lösenord.")
    private String _password;
    
    public UserBean() {
    }
    
    public String login(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        
        if(this._name.equals("User") && this._password.equals("1234")){
            return "success";
        } else {
            context.addMessage(null, new FacesMessage("Login failed."));
            return "failure";
        }
    }
    
    public String getName() {
        return this._name;
    }      

    public void setName(String name) {
        this._name = name;
    }  
    
    public String getPassword() {
        return this._password;
    }   
    
    public void setPassword(String password) {
        this._password = password;
    }  
}
