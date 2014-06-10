/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.controller;

import id.go.bi.ejb.LoggerBean;
import id.go.bi.entity.TSystemLog;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author idabagus
 */
@ManagedBean
@ViewScoped
public class SystemLogController implements Serializable {

    @EJB
    private LoggerBean loggerBean;
    private TSystemLog syslog;
    private TSystemLog selectedSysLog;
    private List<TSystemLog> syslogs;
    private List<TSystemLog> filteredsyslogs;

    /**
     * Creates a new instance of SystemLogController
     */
    public SystemLogController() {
        syslog = new TSystemLog();
        Calendar c = Calendar.getInstance();
        syslog.setWaktu(c.getTime());
    }

    public List<TSystemLog> getAllSysLog() {
        syslogs = loggerBean.getAllSystemLog();
        return syslogs;
    }

    public List<TSystemLog> getSyslogs() {
        return syslogs;
    }

    public List<TSystemLog> getFilteredsyslogs() {
        return filteredsyslogs;
    }

    public void setFilteredsyslogs(List<TSystemLog> filteredsyslogs) {
        this.filteredsyslogs = filteredsyslogs;
    }

    public void setSyslogs(List<TSystemLog> syslogs) {
        this.syslogs = syslogs;
    }

    public TSystemLog getSelectedSysLog() {
        return selectedSysLog;
    }

    public void setSelectedSysLog(TSystemLog selectedSysLog) {
        this.selectedSysLog = selectedSysLog;
    }

    public List<TSystemLog> getAllSysLogByDay(SelectEvent event) {
        if (syslog.getWaktu() == null) {
            Calendar c = Calendar.getInstance();
            syslogs = loggerBean.getSysLog(c.getTime());
        } else {
            syslogs = loggerBean.getSysLog(syslog.getWaktu());
        }        
        return syslogs;
    }
    
    public void onRowSelect(SelectEvent event) {
        TSystemLog tsys = (TSystemLog) event.getObject();
        setSelectedSysLog(tsys);
    }
    
    public TSystemLog getSyslog() {
        return syslog;
    }

    public void setSyslog(TSystemLog syslog) {
        this.syslog = syslog;
    }

    public boolean isExceedMaxItem() {
        return syslogs.size() > 15;
    }
}
