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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "T_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t"),
    @NamedQuery(name = "TUser.findByUserId", query = "SELECT t FROM TUser t WHERE t.userId = :userId"),
    @NamedQuery(name = "TUser.findByPasswordAktif", query = "SELECT t FROM TUser t WHERE t.passwordAktif = :passwordAktif"),
    @NamedQuery(name = "TUser.findByPassword1", query = "SELECT t FROM TUser t WHERE t.password1 = :password1"),
    @NamedQuery(name = "TUser.findByPassword2", query = "SELECT t FROM TUser t WHERE t.password2 = :password2"),
    @NamedQuery(name = "TUser.findByPassword3", query = "SELECT t FROM TUser t WHERE t.password3 = :password3"),
    @NamedQuery(name = "TUser.findByFullName", query = "SELECT t FROM TUser t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "TUser.findByDeskripsi", query = "SELECT t FROM TUser t WHERE t.deskripsi = :deskripsi"),
    @NamedQuery(name = "TUser.findByStatusAktif", query = "SELECT t FROM TUser t WHERE t.statusAktif = :statusAktif"),
    @NamedQuery(name = "TUser.findByLoginTrial", query = "SELECT t FROM TUser t WHERE t.loginTrial = :loginTrial"),
    @NamedQuery(name = "TUser.findByExpiredDate", query = "SELECT t FROM TUser t WHERE t.expiredDate = :expiredDate"),
    @NamedQuery(name = "TUser.findByLastLogin", query = "SELECT t FROM TUser t WHERE t.lastLogin = :lastLogin"),
    @NamedQuery(name = "TUser.findByCreatedDate", query = "SELECT t FROM TUser t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TUser.findByCreatedBy", query = "SELECT t FROM TUser t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TUser.findByLastUpdated", query = "SELECT t FROM TUser t WHERE t.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "TUser.findByUpdatedBy", query = "SELECT t FROM TUser t WHERE t.updatedBy = :updatedBy"),
    @NamedQuery(name = "TUser.findByApprovedDate", query = "SELECT t FROM TUser t WHERE t.approvedDate = :approvedDate"),
    @NamedQuery(name = "TUser.findByApprovedBy", query = "SELECT t FROM TUser t WHERE t.approvedBy = :approvedBy"),
    @NamedQuery(name = "TUser.findByAccessType", query = "SELECT t FROM TUser t WHERE t.accessType = :accessType")})
public class TUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "PASSWORD_AKTIF")
    private String passwordAktif;
    @Size(max = 24)
    @Column(name = "PASSWORD_1")
    private String password1;
    @Size(max = 24)
    @Column(name = "PASSWORD_2")
    private String password2;
    @Size(max = 24)
    @Column(name = "PASSWORD_3")
    private String password3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FULL_NAME")
    private String fullName;
    @Size(max = 30)
    @Column(name = "DESKRIPSI")
    private String deskripsi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOGIN_TRIAL")
    private char loginTrial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXPIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "APPROVED_BY")
    private String approvedBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ACCESS_TYPE")
    private String accessType;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RUserRole roleId;
    @JoinColumn(name = "SANDI_KLIRING", referencedColumnName = "SANDI_KANTOR_BANK")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RKantorBank sandiKliring;
    @JoinColumn(name = "SANDI_INSTITUSI_BANK", referencedColumnName = "SANDI_INSTITUSI_BANK")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RInstitusiBank sandiInstitusiBank;
    @JoinColumn(name = "SANDI_BANK", referencedColumnName = "SANDI_BANK")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RBank sandiBank;
    @JoinColumn(name = "STATUS_AKTIF", referencedColumnName = "USER_STATUS")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RUserStatus statusAktif;

    public TUser() {
    }

    public TUser(String userId) {
        this.userId = userId;
    }

    public TUser(String userId, String passwordAktif, String fullName, char loginTrial, Date expiredDate, Date lastLogin, Date createdDate, String createdBy, Date lastUpdated, String updatedBy, Date approvedDate, String approvedBy, String accessType) {
        this.userId = userId;
        this.passwordAktif = passwordAktif;
        this.fullName = fullName;
        this.loginTrial = loginTrial;
        this.expiredDate = expiredDate;
        this.lastLogin = lastLogin;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdated = lastUpdated;
        this.updatedBy = updatedBy;
        this.approvedDate = approvedDate;
        this.approvedBy = approvedBy;
        this.accessType = accessType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswordAktif() {
        return passwordAktif;
    }

    public void setPasswordAktif(String passwordAktif) {
        this.passwordAktif = passwordAktif;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPassword3() {
        return password3;
    }

    public void setPassword3(String password3) {
        this.password3 = password3;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public char getLoginTrial() {
        return loginTrial;
    }

    public void setLoginTrial(char loginTrial) {
        this.loginTrial = loginTrial;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
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

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public RUserRole getRoleId() {
        return roleId;
    }

    public void setRoleId(RUserRole roleId) {
        this.roleId = roleId;
    }

    public RKantorBank getSandiKliring() {
        return sandiKliring;
    }

    public void setSandiKliring(RKantorBank sandiKliring) {
        this.sandiKliring = sandiKliring;
    }

    public RInstitusiBank getSandiInstitusiBank() {
        return sandiInstitusiBank;
    }

    public void setSandiInstitusiBank(RInstitusiBank sandiInstitusiBank) {
        this.sandiInstitusiBank = sandiInstitusiBank;
    }

    public RBank getSandiBank() {
        return sandiBank;
    }

    public void setSandiBank(RBank sandiBank) {
        this.sandiBank = sandiBank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUser)) {
            return false;
        }
        TUser other = (TUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.TUser[ userId=" + userId + " ]";
    }

    public RUserStatus getStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(RUserStatus statusAktif) {
        this.statusAktif = statusAktif;
    }
    
}
