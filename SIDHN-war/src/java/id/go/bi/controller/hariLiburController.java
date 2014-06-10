/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.controller;

import id.go.bi.ejb.ParameterBean;
import id.go.bi.entity.RHariLibur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author idabagus
 */
@ManagedBean
@ViewScoped
@Singleton
public class hariLiburController implements Serializable {

    /**
     * Creates a new instance of hariLiburController
     */
    @EJB
    private ParameterBean parameterBean;
    private RHariLibur hariLibur;
    private List<RHariLibur> selectedHariLibur;

    public hariLiburController() {
        hariLibur = new RHariLibur();
    }

    @PostConstruct
    public void init() {
        selectedHariLibur = new ArrayList<>();
    }

    public List<RHariLibur> getSelectedHariLibur() {
        return selectedHariLibur;
    }

    public void setSelectedHariLibur(List<RHariLibur> selectedHariLibur) {
        this.selectedHariLibur = selectedHariLibur;
    }

    public RHariLibur getHariLibur() {
        return hariLibur;
    }

    public void setHariLibur(RHariLibur hariLibur) {
        this.hariLibur = hariLibur;
    }

    public void onRowSelect(SelectEvent event) {
        RHariLibur libur = (RHariLibur) event.getObject();
        selectedHariLibur.add(libur);
    }
    
    public void onRowUnselect(UnselectEvent event) {
        RHariLibur libur = (RHariLibur) event.getObject();
        selectedHariLibur.remove(libur);
    }    
    
    public void onToggleCheckbox(ToggleSelectEvent event) {
        if(event.isSelected()) {
            selectedHariLibur = getHariLiburByYear();
        }
    }

    public void DeleteSelectedHariLibur(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            for (RHariLibur libur : selectedHariLibur) {
                parameterBean.DeleteHariLibur(libur);
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Hari Libur berhasil di hapus", null));
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Something goes wrong.", null));
        }
    }

    public void CreateHariLibur(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Object currentUser = session.getAttribute("userid");

        try {
            Calendar c = Calendar.getInstance();
            hariLibur.setUpdatedBy((String) currentUser);
            hariLibur.setLastUpdated(c.getTime());
            parameterBean.createHariLibur(hariLibur);
            hariLibur = new RHariLibur();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Hari Libur berhasil disimpan.", null));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Something goes wrong.", null));
        }
    }

    public List<RHariLibur> getHariLiburByYear() {
        Calendar c = Calendar.getInstance();
        String year = String.valueOf(c.get(Calendar.YEAR));
        return parameterBean.getHariLiburByYear(year);
    }
}
