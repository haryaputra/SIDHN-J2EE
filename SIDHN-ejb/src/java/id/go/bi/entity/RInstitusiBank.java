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
@Table(name = "R_INSTITUSI_BANK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RInstitusiBank.findAll", query = "SELECT r FROM RInstitusiBank r"),
    @NamedQuery(name = "RInstitusiBank.findBySandiInstitusiBank", query = "SELECT r FROM RInstitusiBank r WHERE r.sandiInstitusiBank = :sandiInstitusiBank"),
    @NamedQuery(name = "RInstitusiBank.findBySandiBank", query = "SELECT r FROM RInstitusiBank r WHERE r.sandiBank = :sandiBank"),
    @NamedQuery(name = "RInstitusiBank.findBySandiJenisUsaha", query = "SELECT r FROM RInstitusiBank r WHERE r.sandiJenisUsaha = :sandiJenisUsaha"),
    @NamedQuery(name = "RInstitusiBank.findByRekening", query = "SELECT r FROM RInstitusiBank r WHERE r.rekening = :rekening"),
    @NamedQuery(name = "RInstitusiBank.findByNamaBank", query = "SELECT r FROM RInstitusiBank r WHERE r.namaBank = :namaBank"),
    @NamedQuery(name = "RInstitusiBank.findByNamaSingkat", query = "SELECT r FROM RInstitusiBank r WHERE r.namaSingkat = :namaSingkat")})
public class RInstitusiBank implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sandiInstitusiBank")
    private Collection<TUser> tUserCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SANDI_INSTITUSI_BANK")
    private String sandiInstitusiBank;
    @Size(max = 3)
    @Column(name = "SANDI_BANK")
    private String sandiBank;
    @Column(name = "SANDI_JENIS_USAHA")
    private Character sandiJenisUsaha;
    @Size(max = 16)
    @Column(name = "REKENING")
    private String rekening;
    @Size(max = 50)
    @Column(name = "NAMA_BANK")
    private String namaBank;
    @Size(max = 20)
    @Column(name = "NAMA_SINGKAT")
    private String namaSingkat;

    public RInstitusiBank() {
    }

    public RInstitusiBank(String sandiInstitusiBank) {
        this.sandiInstitusiBank = sandiInstitusiBank;
    }

    public String getSandiInstitusiBank() {
        return sandiInstitusiBank;
    }

    public void setSandiInstitusiBank(String sandiInstitusiBank) {
        this.sandiInstitusiBank = sandiInstitusiBank;
    }

    public String getSandiBank() {
        return sandiBank;
    }

    public void setSandiBank(String sandiBank) {
        this.sandiBank = sandiBank;
    }

    public Character getSandiJenisUsaha() {
        return sandiJenisUsaha;
    }

    public void setSandiJenisUsaha(Character sandiJenisUsaha) {
        this.sandiJenisUsaha = sandiJenisUsaha;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sandiInstitusiBank != null ? sandiInstitusiBank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RInstitusiBank)) {
            return false;
        }
        RInstitusiBank other = (RInstitusiBank) object;
        if ((this.sandiInstitusiBank == null && other.sandiInstitusiBank != null) || (this.sandiInstitusiBank != null && !this.sandiInstitusiBank.equals(other.sandiInstitusiBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.RInstitusiBank[ sandiInstitusiBank=" + sandiInstitusiBank + " ]";
    }

    @XmlTransient
    public Collection<TUser> getTUserCollection() {
        return tUserCollection;
    }

    public void setTUserCollection(Collection<TUser> tUserCollection) {
        this.tUserCollection = tUserCollection;
    }
    
}
