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
@Table(name = "R_USER_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RUserRole.findAll", query = "SELECT r FROM RUserRole r"),
    @NamedQuery(name = "RUserRole.findByRoleId", query = "SELECT r FROM RUserRole r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "RUserRole.findByRoleName", query = "SELECT r FROM RUserRole r WHERE r.roleName = :roleName"),
    @NamedQuery(name = "RUserRole.findByCreatedDate", query = "SELECT r FROM RUserRole r WHERE r.createdDate = :createdDate"),
    @NamedQuery(name = "RUserRole.findByCreatedBy", query = "SELECT r FROM RUserRole r WHERE r.createdBy = :createdBy"),
    @NamedQuery(name = "RUserRole.findByLastUpdated", query = "SELECT r FROM RUserRole r WHERE r.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "RUserRole.findByUpdatedBy", query = "SELECT r FROM RUserRole r WHERE r.updatedBy = :updatedBy")})
public class RUserRole implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private Collection<TUser> tUserCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_ID")
    private Character roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CREATED_BY")
    private String createdBy;
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

    public RUserRole() {
    }

    public RUserRole(Character roleId) {
        this.roleId = roleId;
    }

    public RUserRole(Character roleId, String roleName, Date createdDate, String createdBy, Date lastUpdated, String updatedBy) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdated = lastUpdated;
        this.updatedBy = updatedBy;
    }

    public Character getRoleId() {
        return roleId;
    }

    public void setRoleId(Character roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RUserRole)) {
            return false;
        }
        RUserRole other = (RUserRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.RUserRole[ roleId=" + roleId + " ]";
    }

    @XmlTransient
    public Collection<TUser> getTUserCollection() {
        return tUserCollection;
    }

    public void setTUserCollection(Collection<TUser> tUserCollection) {
        this.tUserCollection = tUserCollection;
    }
    
}
