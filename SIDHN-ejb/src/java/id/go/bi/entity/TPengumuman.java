/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "T_PENGUMUMAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPengumuman.findAll", query = "SELECT t FROM TPengumuman t"),
    @NamedQuery(name = "TPengumuman.findByPengumumanId", query = "SELECT t FROM TPengumuman t WHERE t.pengumumanId = :pengumumanId"),
    @NamedQuery(name = "TPengumuman.findByJudul", query = "SELECT t FROM TPengumuman t WHERE t.judul = :judul"),
    @NamedQuery(name = "TPengumuman.findByCreatedBy", query = "SELECT t FROM TPengumuman t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TPengumuman.findByCreatedDate", query = "SELECT t FROM TPengumuman t WHERE t.createdDate = :createdDate")})
public class TPengumuman implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Column(name = "PENGUMUMAN_ID")
    private BigDecimal pengumumanId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "JUDUL")
    private String judul;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "ISI")
    private String isi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public TPengumuman() {
    }

    public TPengumuman(BigDecimal pengumumanId) {
        this.pengumumanId = pengumumanId;
    }

    public TPengumuman(BigDecimal pengumumanId, String judul, String isi, String createdBy, Date createdDate) {
        this.pengumumanId = pengumumanId;
        this.judul = judul;
        this.isi = isi;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public BigDecimal getPengumumanId() {
        return pengumumanId;
    }

    public void setPengumumanId(BigDecimal pengumumanId) {
        this.pengumumanId = pengumumanId;
    }

    public String getJudul() {
        return judul;
    }
    
    public String getShortJudul() {
        if (judul.length() > 15) {
            return judul.substring(0,15).concat("...");
        } else {
            return judul;
        }        
    }     

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }
    
    public String getShortIsi() {
        if (isi.length() > 30) {
            return isi.substring(0,30).concat("...");
        } else {
            return isi;
        }        
    }    

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        return sdf.format(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pengumumanId != null ? pengumumanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPengumuman)) {
            return false;
        }
        TPengumuman other = (TPengumuman) object;
        if ((this.pengumumanId == null && other.pengumumanId != null) || (this.pengumumanId != null && !this.pengumumanId.equals(other.pengumumanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.TPengumuman[ pengumumanId=" + pengumumanId + " ]";
    }
    
}
