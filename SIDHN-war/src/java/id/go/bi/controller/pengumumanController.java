/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.controller;

import id.go.bi.entity.TPengumuman;
import id.go.bi.ejb.PengumumanBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
public class pengumumanController implements Serializable {

    @EJB
    private PengumumanBean pengumumanBean;
    private List<TPengumuman> selectedPengumuman;
    private TPengumuman viewedPengumuman;
    private TPengumuman pengumuman;

    /**
     * Creates a new instance of pengumumanController
     */
    public pengumumanController() {
        pengumuman = new TPengumuman();
    }

    @PostConstruct
    public void init() {
        selectedPengumuman = new ArrayList<>();
    }

    public TPengumuman getPengumuman() {
        return pengumuman;
    }

    public void setPengumuman(TPengumuman pengumuman) {
        this.pengumuman = pengumuman;
    }

    public List<TPengumuman> getSelectedPengumuman() {
        return this.selectedPengumuman;
    }

    public void setSelectedPengumuman(List<TPengumuman> selectedPengumuman) {
        this.selectedPengumuman = selectedPengumuman;
    }

    public List<TPengumuman> getPengumumans() {
        return pengumumanBean.getAllPengumuman();
    }

    public TPengumuman getViewedPengumuman() {
        return viewedPengumuman;
    }

    public void setViewedPengumuman(TPengumuman viewedPengumuman) {
        this.viewedPengumuman = viewedPengumuman;
    }

    public boolean isExceedMaxItem() {
        return pengumumanBean.getAllPengumuman().size() > 15;
    }

    public void onRowSelect(SelectEvent event) {
        TPengumuman peng = (TPengumuman) event.getObject();
        setViewedPengumuman(peng);
    }

    public void onRowSelectCheckbox(SelectEvent event) {
        TPengumuman peng = (TPengumuman) event.getObject();
        selectedPengumuman.add(peng);
    }

    public void onRowUnselectCheckbox(UnselectEvent event) {
        TPengumuman peng = (TPengumuman) event.getObject();
        selectedPengumuman.remove(peng);
    }

    public void onToggleCheckbox(ToggleSelectEvent event) {
        if (event.isSelected()) {
            if (isExceedMaxItem()) {
                selectedPengumuman = getPengumumans().subList(0, 14);
            } else {
                selectedPengumuman = getPengumumans();
            }
        }
    }

    public void Delete(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            for (TPengumuman peng : selectedPengumuman) {
                pengumumanBean.DeletePengumuman(peng);
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Pengumuman berhasil di hapus", null));
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Something goes wrong.", null));
        }
    }

    public void Save(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Object currentUser = session.getAttribute("userid");

        try {
            Calendar c = Calendar.getInstance();
            pengumuman.setCreatedBy((String) currentUser);
            pengumuman.setCreatedDate(c.getTime());
            pengumumanBean.CreatePengumuman(pengumuman);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Pengumuman berhasil disimpan.", null));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Something goes wrong....", null));
        }
    }
}
