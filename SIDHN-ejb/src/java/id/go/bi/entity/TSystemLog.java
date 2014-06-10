/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "T_SYSTEM_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TSystemLog.findAll", query = "SELECT t FROM TSystemLog t"),
    @NamedQuery(name = "TSystemLog.findByLogId", query = "SELECT t FROM TSystemLog t WHERE t.logId = :logId"),
    @NamedQuery(name = "TSystemLog.findByUserId", query = "SELECT t FROM TSystemLog t WHERE t.userId = :userId"),
    @NamedQuery(name = "TSystemLog.findByWaktu", query = "SELECT t FROM TSystemLog t WHERE t.waktu = :waktu"),
    @NamedQuery(name = "TSystemLog.findByActivity", query = "SELECT t FROM TSystemLog t WHERE t.activity = :activity"),
    @NamedQuery(name = "TSystemLog.findByRemoteHost", query = "SELECT t FROM TSystemLog t WHERE t.remoteHost = :remoteHost")})
public class TSystemLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "LOG_ID")
    private BigDecimal logId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WAKTU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ACTIVITY")
    private String activity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "REMOTE_HOST")
    private String remoteHost;

    public TSystemLog() {
    }

    public TSystemLog(BigDecimal logId) {
        this.logId = logId;
    }

    public TSystemLog(BigDecimal logId, String userId, Date waktu, String activity, String remoteHost) {
        this.logId = logId;
        this.userId = userId;
        this.waktu = waktu;
        this.activity = activity;
        this.remoteHost = remoteHost;
    }

    public BigDecimal getLogId() {
        return logId;
    }

    public void setLogId(BigDecimal logId) {
        this.logId = logId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public String getActivity() {
        return activity;
    }

    public String getShortActivity() {
        if (activity.length() > 60) {
            return activity.substring(0, 60).concat("...");
        } else {
            return activity;
        }
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSystemLog)) {
            return false;
        }
        TSystemLog other = (TSystemLog) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.TSystemLog[ logId=" + logId + " ]";
    }
}
