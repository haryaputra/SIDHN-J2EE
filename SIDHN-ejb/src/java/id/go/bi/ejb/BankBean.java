/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.ejb;

import id.go.bi.entity.RInstitusiBank;
import id.go.bi.entity.RKantorBank;
import java.util.List;
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
public class BankBean {
    @PersistenceContext(unitName = "SIDHN-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List <RInstitusiBank> getInstitusiBankExcept(String sandiBank){
        Query query = em.createNativeQuery("Select * from r_institusi_bank where sandi_institusi_bank <> ? order by sandi_institusi_bank", RInstitusiBank.class);
        query.setParameter(1, sandiBank);
        List <RInstitusiBank> rib = query.getResultList();
        return rib;
    }
    
        public List <RInstitusiBank> getInstitusiBank(String sandiBank){
        Query query = em.createNativeQuery("Select * from r_institusi_bank where sandi_bank = ? order by sandi_institusi_bank", RInstitusiBank.class);
        query.setParameter(1, sandiBank);
        List <RInstitusiBank> rib = query.getResultList();
        return rib;
    }
        
      public List <RKantorBank> getKantorBank(String sib, String skb){
          String sql;
          Query query;
          if ("".equalsIgnoreCase(skb) || null == skb){
              sql = "Select sandi_kantor_bank, nama_kantor from r_kantor_bank where sandi_institusi_bank= ? order by sandi_kantor_bank";
              query = em.createNativeQuery(sql, RKantorBank.class);
              query.setParameter(1, sib);
          } else{
              sql = "Select sandi_kantor_bank,nama_kantor from r_kantor_bank where sandi_institusi_bank= ? and sandi_kantor_bank = ? order by sandi_kantor_bank";
              query = em.createNativeQuery(sql, RKantorBank.class);
              query.setParameter(1, sib);
              query.setParameter(2, skb);
          }
          
          return query.getResultList();
      }
}
