/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.ejb;

import id.go.bi.entity.RUserRole;
import id.go.bi.entity.TUser;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author idabagus
 */
@Stateless
@LocalBean
public class UserBean {
    @EJB
    private SimpleEncryption simpleEncryption;
    
    @PersistenceContext(unitName = "SIDHN-ejbPU")
    private EntityManager em;      
    private String password;
    private String userid;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of userid
     *
     * @return the value of userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Set the value of userid
     *
     * @param userid new value of userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public Boolean isExist(){
        Boolean valid = false;
        Query query = em.createNamedQuery("TUser.findByUserId");
        query.setParameter("userId", this.userid);
        try{
            TUser user = (TUser) query.getSingleResult();
            valid = true;
            System.out.println("User "+user.toString()+" ketemu...");
        }
        catch (javax.persistence.NoResultException e){
            System.out.println("User:"+this.userid+" gak ada cuy");
        }   
        return valid;
    }
    
    public TUser getUser(String id){
        TUser user = new TUser();
        Query query = em.createNamedQuery("TUser.findByUserId");
        query.setParameter("userId", id);
        try{
            user = (TUser) query.getSingleResult();
            System.out.println("User "+user.toString()+" ketemu...");
        }
        catch (javax.persistence.NoResultException e){
            System.out.println("User:"+id+" gak ada cuy");
        }   
        return user;    
    }
    
    public Boolean isExist(String id){
        Boolean valid = false;
        Query query = em.createNamedQuery("TUser.findByUserId");
        query.setParameter("userId", id);
        try{
            TUser user = (TUser) query.getSingleResult();
            valid = true;
            System.out.println("User "+user.toString()+" ketemu...");
        }
        catch (javax.persistence.NoResultException e){
            System.out.println("User:"+id+" gak ada cuy");
        }   
        return valid;
    }    
    
    public Boolean isPasswordValid() {
        Boolean valid = false;
        //Boolean valid = true;
        Query query = em.createNamedQuery("TUser.findByUserId");
        query.setParameter("userId", this.userid);
        TUser user = (TUser) query.getSingleResult();
        
        String pass_enc = simpleEncryption.encrypt(password);
        if (pass_enc.equals(user.getPasswordAktif())) {
            valid = true;
        }
        return valid;
    }
    
    public Boolean isPasswordExpired() throws Exception {
        Boolean valid = false;
        Query query = em.createNamedQuery("TUser.findByUserId");
        query.setParameter("userId", this.userid);
        TUser user = (TUser) query.getSingleResult();
        
        Calendar cal = Calendar.getInstance();
        
        if (cal.getTime().before(user.getExpiredDate())){
            valid = true;
        }
        return valid;
    }  
    
    public List <TUser> getAllUser(){
        Query query = em.createNativeQuery("SELECT * FROM T_USER ORDER BY SANDI_KLIRING, USER_ID", TUser.class);
        return query.getResultList();
    }
    
    public void CreateUser(TUser user) {
        em.persist(user);
   }
    
    public void UpdateUser(TUser user) {
        em.merge(user);
   }    
    
    public void DeleteUser(TUser user) {
        em.detach(user);
        em.remove(user);
   }     
    
    public List <RUserRole> getAllUserRoles() {
        Query query = em.createNamedQuery("RUserRole.findAll");
        return query.getResultList();
    }    
}
