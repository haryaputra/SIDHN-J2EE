/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.ejb;

import id.go.bi.entity.RHariLibur;
import id.go.bi.entity.RParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ParameterBean {
    @PersistenceContext(unitName = "SIDHN-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Map getAllParam(){
        Query query = em.createNamedQuery("RParam.findAll");
        List <RParam> params = query.getResultList();
        Map param = new HashMap();
        for (RParam rParam : params) {
            param.put(rParam.getParamName(), rParam.getParamValue());
        }
        
        return param;
    }
    
    public void UpdateParam(RParam param) {
        em.merge(param);
    }
    
    public void DeleteHariLibur(RHariLibur libur) {
        em.remove(em.merge(libur));
    }
    
    public List<RHariLibur> getHariLiburByYear(String year) {
        Query query = em.createNativeQuery("select * from r_hari_libur where to_char(tanggal, 'yyyy') = ? "
                + "order by 1 desc", RHariLibur.class);
        query.setParameter(1, year);
        
        return query.getResultList();
    }
    
    public void createHariLibur(RHariLibur libur) {
        em.persist(libur);
    }
    
}
