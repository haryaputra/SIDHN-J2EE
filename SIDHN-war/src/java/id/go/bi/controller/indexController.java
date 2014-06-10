/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.controller;

import id.go.bi.ejb.LoggerBean;
import id.go.bi.ejb.UserBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author idabagus
 */
@ManagedBean
@ViewScoped
public class indexController implements Serializable {

    @EJB
    private UserBean userBean;
    @EJB
    private LoggerBean loggerBean;    
    private String UserId;
    private String Password;

    /**
     * Creates a new instance of indexController
     */
    public indexController() {
    }

    /**
     * Get the value of UserId
     *
     * @return the value of UserId
     */
    public String getUserId() {
        return UserId;
    }

    /**
     * Set the value of UserId
     *
     * @param UserId new value of UserId
     */
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    /**
     * Get the value of Password
     *
     * @return the value of Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Set the value of Password
     *
     * @param Password new value of Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String Login(ActionEvent event) {
        //logic nya belom lengkap, masih contoh
        userBean.setUserid(UserId);
        userBean.setPassword(Password);
        if (userBean.isExist()) {
            if (userBean.isPasswordValid()) {
                System.out.println("password ok");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userid", UserId);
                return "pengumuman";
            } else {
                System.out.println("password nok");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Invalid Password", null));

                return "index";
            }
        } else {
            System.out.println("userid salah ato tidak terdaptar");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Invalid UserName", null));

            return "index";
        }
    }
    
    public String Logout(ActionEvent event){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }
}
