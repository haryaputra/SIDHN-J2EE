/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author idabagus
 */
@Entity
@Table(name = "R_BANK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RBank.findAll", query = "SELECT r FROM RBank r"),
    @NamedQuery(name = "RBank.findBySandiBank", query = "SELECT r FROM RBank r WHERE r.sandiBank = :sandiBank"),
    @NamedQuery(name = "RBank.findByNamaBank", query = "SELECT r FROM RBank r WHERE r.namaBank = :namaBank"),
    @NamedQuery(name = "RBank.findByNamaSingkat", query = "SELECT r FROM RBank r WHERE r.namaSingkat = :namaSingkat"),
    @NamedQuery(name = "RBank.findBySandiJenisBank", query = "SELECT r FROM RBank r WHERE r.sandiJenisBank = :sandiJenisBank"),
    @NamedQuery(name = "RBank.findByStatusPeserta", query = "SELECT r FROM RBank r WHERE r.statusPeserta = :statusPeserta")})
public class RBank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SANDI_BANK")
    private String sandiBank;
    @Size(max = 50)
    @Column(name = "NAMA_BANK")
    private String namaBank;
    @Size(max = 20)
    @Column(name = "NAMA_SINGKAT")
    private String namaSingkat;
    @Size(max = 3)
    @Column(name = "SANDI_JENIS_BANK")
    private String sandiJenisBank;
    @Column(name = "STATUS_PESERTA")
    private Character statusPeserta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sandiBank")
    private Collection<TUser> tUserCollection;

    public RBank() {
    }

    public RBank(String sandiBank) {
        this.sandiBank = sandiBank;
    }

    public String getSandiBank() {
        return sandiBank;
    }

    public void setSandiBank(String sandiBank) {
        this.sandiBank = sandiBank;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getNamaSingkat() {
        return namaSingkat;
    }

    public void setNamaSingkat(String namaSingkat) {
        this.namaSingkat = namaSingkat;
    }

    public String getSandiJenisBank() {
        return sandiJenisBank;
    }

    public void setSandiJenisBank(String sandiJenisBank) {
        this.sandiJenisBank = sandiJenisBank;
    }

    public Character getStatusPeserta() {
        return statusPeserta;
    }

    public void setStatusPeserta(Character statusPeserta) {
        this.statusPeserta = statusPeserta;
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
        hash += (sandiBank != null ? sandiBank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RBank)) {
            return false;
        }
        RBank other = (RBank) object;
        if ((this.sandiBank == null && other.sandiBank != null) || (this.sandiBank != null && !this.sandiBank.equals(other.sandiBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.RBank[ sandiBank=" + sandiBank + " ]";
    }
    
}
