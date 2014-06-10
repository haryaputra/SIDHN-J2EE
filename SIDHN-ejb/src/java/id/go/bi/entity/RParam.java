/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idabagus
 */
@Entity
@Table(name = "R_PARAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RParam.findAll", query = "SELECT r FROM RParam r"),
    @NamedQuery(name = "RParam.findByParamName", query = "SELECT r FROM RParam r WHERE r.paramName = :paramName"),
    @NamedQuery(name = "RParam.findByParamValue", query = "SELECT r FROM RParam r WHERE r.paramValue = :paramValue"),
    @NamedQuery(name = "RParam.findByLastUpdated", query = "SELECT r FROM RParam r WHERE r.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "RParam.findByUpdatedBy", query = "SELECT r FROM RParam r WHERE r.updatedBy = :updatedBy")})
public class RParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "PARAM_NAME")
    private String paramName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PARAM_VALUE")
    private String paramValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    public RParam() {
    }

    public RParam(String paramName) {
        this.paramName = paramName;
    }

    public RParam(String paramName, String paramValue, Date lastUpdated, String updatedBy) {
        this.paramName = paramName;
        this.paramValue = paramValue;
        this.lastUpdated = lastUpdated;
        this.updatedBy = updatedBy;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paramName != null ? paramName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RParam)) {
            return false;
        }
        RParam other = (RParam) object;
        if ((this.paramName == null && other.paramName != null) || (this.paramName != null && !this.paramName.equals(other.paramName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.RParam[ paramName=" + paramName + " ]";
    }
    
}
