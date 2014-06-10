/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.ejb;

import id.go.bi.entity.TPengumuman;
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
public class PengumumanBean {

    @PersistenceContext(unitName = "SIDHN-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<TPengumuman> getAllPengumuman() {
        Query query = em.createNamedQuery("TPengumuman.findAll");
        return query.getResultList();
    }

    public void CreatePengumuman(TPengumuman peng) {
        em.persist(peng);
    }

    public void UpdatePengumuman(TPengumuman peng) {
        em.merge(peng);
    }

    public void DeletePengumuman(TPengumuman peng) {
        em.remove(em.merge(peng));
    }
}
