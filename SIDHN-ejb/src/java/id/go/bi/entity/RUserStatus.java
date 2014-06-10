/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author idabagus
 */
@Entity
@Table(name = "R_USER_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RUserStatus.findAll", query = "SELECT r FROM RUserStatus r"),
    @NamedQuery(name = "RUserStatus.findByUserStatus", query = "SELECT r FROM RUserStatus r WHERE r.userStatus = :userStatus"),
    @NamedQuery(name = "RUserStatus.findByStatusDesc", query = "SELECT r FROM RUserStatus r WHERE r.statusDesc = :statusDesc"),
    @NamedQuery(name = "RUserStatus.findByCreatedDate", query = "SELECT r FROM RUserStatus r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "RUserStatus.findByCreatedBy", query = "SELECT r FROM RUserStatus r WHERE r.createdBy = :createdBy"),
    @NamedQuery(name = "RUserStatus.findByLastUpdated", query = "SELECT r FROM RUserStatus r WHERE r.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "RUserStatus.findByUpdatedBy", query = "SELECT r FROM RUserStatus r WHERE r.updatedBy = :updatedBy")})
public class RUserStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_STATUS")
    private Character userStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STATUS_DESC")
    private String statusDesc;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 20)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Size(max = 20)
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusAktif")
    private Collection<TUser> tUserCollection;

    public RUserStatus() {
    }

    public RUserStatus(Character userStatus) {
        this.userStatus = userStatus;
    }

    public RUserStatus(Character userStatus, String statusDesc) {
        this.userStatus = userStatus;
        this.statusDesc = statusDesc;
    }

    public Character getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Character userStatus) {
        this.userStatus = userStatus;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    @XmlTransient
    public Collection<TUser> getTUserCollection() {
        return tUserCollection;
    }

    public void setTUserCollection(Collection<TUser> tUserCollection) {
        this.tUserCollection = tUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userStatus != null ? userStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RUserStatus)) {
            return false;
        }
        RUserStatus other = (RUserStatus) object;
        if ((this.userStatus == null && other.userStatus != null) || (this.userStatus != null && !this.userStatus.equals(other.userStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.RUserStatus[ userStatus=" + userStatus + " ]";
    }
    
}
