/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.test;

import id.go.bi.ejb.ParameterBean;
import id.go.bi.ejb.SimpleEncryption;
import id.go.bi.ejb.UserBean;
import id.go.bi.entity.TUser;
import java.util.Calendar;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author idabagus
 */
@ManagedBean
@RequestScoped
public class tester {
    @EJB
    private ParameterBean parameterBean;
    @EJB
    private SimpleEncryption simpleEncryption;
    @EJB
    private UserBean userBean;
    

    /**
     * Creates a new instance of tester
     */
    public tester() {
    }

    public String test() throws Exception {
        //userBean.setUserid("admindh1");
        //userBean.setPassword("oracle");
        String status = "nok";
        Calendar c = Calendar.getInstance();
        //TUser user = new TUser("Bagus3", "Password1", 'A', "Bagus", "001", "011", "011", '1', '0', c.getTime(), c.getTime(), c.getTime(), "admin", c.getTime(), "admin", c.getTime(), "admin", "sv");
        try {
           // userBean.DeleteUser(user);
            status = "ok";
        } catch (Exception e) {
            throw e;
        }
        return status;
    }

    public String test1() throws Exception {
        String passchip;

        //pass = simpleEncryption.generateRandomPassword();
        passchip = simpleEncryption.encrypt("oracle");

        return passchip;
    }

    public String test2() throws Exception {
        Map par = parameterBean.getAllParam();
        
        return (String) par.get("bd_p1");
    }
}
