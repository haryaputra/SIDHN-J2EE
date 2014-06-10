/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.ejb;

import id.go.bi.entity.TSystemLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class LoggerBean {

    @PersistenceContext(unitName = "SIDHN-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<TSystemLog> getAllSystemLog() {
        Query query = em.createNamedQuery("TSystemLog.findAll");
        return query.getResultList();
    }

    public List<TSystemLog> getSysLog(Date day) {
        Query query = em.createNativeQuery("Select * from t_system_log where waktu > trunc(?) and waktu < trunc (?) order by waktu desc", TSystemLog.class);
        query.setParameter(1, day);
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.add(Calendar.DAY_OF_MONTH, 1);
        query.setParameter(2, c.getTime());
        return query.getResultList();
    }

    public void Create(TSystemLog syslog) {
        em.persist(syslog);
    }
}
