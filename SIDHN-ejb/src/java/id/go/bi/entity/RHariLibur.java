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
@Table(name = "R_HARI_LIBUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RHariLibur.findAll", query = "SELECT r FROM RHariLibur r"),
    @NamedQuery(name = "RHariLibur.findByTanggal", query = "SELECT r FROM RHariLibur r WHERE r.tanggal = :tanggal"),
    @NamedQuery(name = "RHariLibur.findByKeterangan", query = "SELECT r FROM RHariLibur r WHERE r.keterangan = :keterangan"),
    @NamedQuery(name = "RHariLibur.findByLastUpdated", query = "SELECT r FROM RHariLibur r WHERE r.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "RHariLibur.findByUpdatedBy", query = "SELECT r FROM RHariLibur r WHERE r.updatedBy = :updatedBy")})
public class RHariLibur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TANGGAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggal;
    @Size(max = 50)
    @Column(name = "KETERANGAN")
    private String keterangan;
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

    public RHariLibur() {
    }

    public RHariLibur(Date tanggal) {
        this.tanggal = tanggal;
    }

    public RHariLibur(Date tanggal, Date lastUpdated, String updatedBy) {
        this.tanggal = tanggal;
        this.lastUpdated = lastUpdated;
        this.updatedBy = updatedBy;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
        hash += (tanggal != null ? tanggal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RHariLibur)) {
            return false;
        }
        RHariLibur other = (RHariLibur) object;
        if ((this.tanggal == null && other.tanggal != null) || (this.tanggal != null && !this.tanggal.equals(other.tanggal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.RHariLibur[ tanggal=" + tanggal + " ]";
    }
    
}
