package id.go.bi.controller;

import id.go.bi.entity.TDhn;
import id.go.bi.controller.util.JsfUtil;
import id.go.bi.controller.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("tDhnController")
@SessionScoped
public class TDhnController implements Serializable {

    @EJB
    private id.go.bi.controller.TDhnFacade ejbFacade;
    private List<TDhn> items = null;
    private TDhn selected;

    public TDhnController() {
    }

    public TDhn getSelected() {
        return selected;
    }

    public void setSelected(TDhn selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setTDhnPK(new id.go.bi.entity.TDhnPK());
    }

    private TDhnFacade getFacade() {
        return ejbFacade;
    }

    public TDhn prepareCreate() {
        selected = new TDhn();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TDhnCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TDhnUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TDhnDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TDhn> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public TDhn getTDhn(id.go.bi.entity.TDhnPK id) {
        return getFacade().find(id);
    }

    public List<TDhn> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TDhn> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TDhn.class)
    public static class TDhnControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TDhnController controller = (TDhnController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tDhnController");
            return controller.getTDhn(getKey(value));
        }

        id.go.bi.entity.TDhnPK getKey(String value) {
            id.go.bi.entity.TDhnPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new id.go.bi.entity.TDhnPK();
            key.setNomorDh(values[0]);
            key.setNoUrut(values[1]);
            return key;
        }

        String getStringKey(id.go.bi.entity.TDhnPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNomorDh());
            sb.append(SEPARATOR);
            sb.append(value.getNoUrut());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TDhn) {
                TDhn o = (TDhn) object;
                return getStringKey(o.getTDhnPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TDhn.class.getName()});
                return null;
            }
        }

    }

}
