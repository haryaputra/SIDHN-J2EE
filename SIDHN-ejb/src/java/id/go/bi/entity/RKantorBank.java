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
@Table(name = "R_KANTOR_BANK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RKantorBank.findAll", query = "SELECT r FROM RKantorBank r"),
    @NamedQuery(name = "RKantorBank.findBySandiKantorBank", query = "SELECT r FROM RKantorBank r WHERE r.sandiKantorBank = :sandiKantorBank"),
    @NamedQuery(name = "RKantorBank.findByNamaBank", query = "SELECT r FROM RKantorBank r WHERE r.namaBank = :namaBank"),
    @NamedQuery(name = "RKantorBank.findByNamaKantor", query = "SELECT r FROM RKantorBank r WHERE r.namaKantor = :namaKantor"),
    @NamedQuery(name = "RKantorBank.findByAlamat", query = "SELECT r FROM RKantorBank r WHERE r.alamat = :alamat"),
    @NamedQuery(name = "RKantorBank.findBySandiKota", query = "SELECT r FROM RKantorBank r WHERE r.sandiKota = :sandiKota"),
    @NamedQuery(name = "RKantorBank.findBySandiPropinsi", query = "SELECT r FROM RKantorBank r WHERE r.sandiPropinsi = :sandiPropinsi"),
    @NamedQuery(name = "RKantorBank.findBySandiSatker", query = "SELECT r FROM RKantorBank r WHERE r.sandiSatker = :sandiSatker"),
    @NamedQuery(name = "RKantorBank.findBySandiWilayahKliring", query = "SELECT r FROM RKantorBank r WHERE r.sandiWilayahKliring = :sandiWilayahKliring"),
    @NamedQuery(name = "RKantorBank.findBySandiStatusKantor", query = "SELECT r FROM RKantorBank r WHERE r.sandiStatusKantor = :sandiStatusKantor"),
    @NamedQuery(name = "RKantorBank.findBySandiJenisUsaha", query = "SELECT r FROM RKantorBank r WHERE r.sandiJenisUsaha = :sandiJenisUsaha"),
    @NamedQuery(name = "RKantorBank.findByTglAktif", query = "SELECT r FROM RKantorBank r WHERE r.tglAktif = :tglAktif"),
    @NamedQuery(name = "RKantorBank.findByNoTelp", query = "SELECT r FROM RKantorBank r WHERE r.noTelp = :noTelp"),
    @NamedQuery(name = "RKantorBank.findByStatusKliring", query = "SELECT r FROM RKantorBank r WHERE r.statusKliring = :statusKliring"),
    @NamedQuery(name = "RKantorBank.findBySandiStatusKoordinator", query = "SELECT r FROM RKantorBank r WHERE r.sandiStatusKoordinator = :sandiStatusKoordinator"),
    @NamedQuery(name = "RKantorBank.findBySandiInstitusiBank", query = "SELECT r FROM RKantorBank r WHERE r.sandiInstitusiBank = :sandiInstitusiBank")})
public class RKantorBank implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sandiKliring")
    private Collection<TUser> tUserCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "SANDI_KANTOR_BANK")
    private String sandiKantorBank;
    @Size(max = 50)
    @Column(name = "NAMA_BANK")
    private String namaBank;
    @Size(max = 50)
    @Column(name = "NAMA_KANTOR")
    private String namaKantor;
    @Size(max = 50)
    @Column(name = "ALAMAT")
    private String alamat;
    @Size(max = 4)
    @Column(name = "SANDI_KOTA")
    private String sandiKota;
    @Size(max = 4)
    @Column(name = "SANDI_PROPINSI")
    private String sandiPropinsi;
    @Size(max = 3)
    @Column(name = "SANDI_SATKER")
    private String sandiSatker;
    @Size(max = 4)
    @Column(name = "SANDI_WILAYAH_KLIRING")
    private String sandiWilayahKliring;
    @Column(name = "SANDI_STATUS_KANTOR")
    private Character sandiStatusKantor;
    @Column(name = "SANDI_JENIS_USAHA")
    private Character sandiJenisUsaha;
    @Column(name = "TGL_AKTIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglAktif;
    @Size(max = 20)
    @Column(name = "NO_TELP")
    private String noTelp;
    @Column(name = "STATUS_KLIRING")
    private Character statusKliring;
    @Column(name = "SANDI_STATUS_KOORDINATOR")
    private Character sandiStatusKoordinator;
    @Size(max = 4)
    @Column(name = "SANDI_INSTITUSI_BANK")
    private String sandiInstitusiBank;

    public RKantorBank() {
    }

    public RKantorBank(String sandiKantorBank) {
        this.sandiKantorBank = sandiKantorBank;
    }

    public String getSandiKantorBank() {
        return sandiKantorBank;
    }

    public void setSandiKantorBank(String sandiKantorBank) {
        this.sandiKantorBank = sandiKantorBank;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getNamaKantor() {
        return namaKantor;
    }

    public void setNamaKantor(String namaKantor) {
        this.namaKantor = namaKantor;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getSandiKota() {
        return sandiKota;
    }

    public void setSandiKota(String sandiKota) {
        this.sandiKota = sandiKota;
    }

    public String getSandiPropinsi() {
        return sandiPropinsi;
    }

    public void setSandiPropinsi(String sandiPropinsi) {
        this.sandiPropinsi = sandiPropinsi;
    }

    public String getSandiSatker() {
        return sandiSatker;
    }

    public void setSandiSatker(String sandiSatker) {
        this.sandiSatker = sandiSatker;
    }

    public String getSandiWilayahKliring() {
        return sandiWilayahKliring;
    }

    public void setSandiWilayahKliring(String sandiWilayahKliring) {
        this.sandiWilayahKliring = sandiWilayahKliring;
    }

    public Character getSandiStatusKantor() {
        return sandiStatusKantor;
    }

    public void setSandiStatusKantor(Character sandiStatusKantor) {
        this.sandiStatusKantor = sandiStatusKantor;
    }

    public Character getSandiJenisUsaha() {
        return sandiJenisUsaha;
    }

    public void setSandiJenisUsaha(Character sandiJenisUsaha) {
        this.sandiJenisUsaha = sandiJenisUsaha;
    }

    public Date getTglAktif() {
        return tglAktif;
    }

    public void setTglAktif(Date tglAktif) {
        this.tglAktif = tglAktif;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public Character getStatusKliring() {
        return statusKliring;
    }

    public void setStatusKliring(Character statusKliring) {
        this.statusKliring = statusKliring;
    }

    public Character getSandiStatusKoordinator() {
        return sandiStatusKoordinator;
    }

    public void setSandiStatusKoordinator(Character sandiStatusKoordinator) {
        this.sandiStatusKoordinator = sandiStatusKoordinator;
    }

    public String getSandiInstitusiBank() {
        return sandiInstitusiBank;
    }

    public void setSandiInstitusiBank(String sandiInstitusiBank) {
        this.sandiInstitusiBank = sandiInstitusiBank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sandiKantorBank != null ? sandiKantorBank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RKantorBank)) {
            return false;
        }
        RKantorBank other = (RKantorBank) object;
        if ((this.sandiKantorBank == null && other.sandiKantorBank != null) || (this.sandiKantorBank != null && !this.sandiKantorBank.equals(other.sandiKantorBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.RKantorBank[ sandiKantorBank=" + sandiKantorBank + " ]";
    }

    @XmlTransient
    public Collection<TUser> getTUserCollection() {
        return tUserCollection;
    }

    public void setTUserCollection(Collection<TUser> tUserCollection) {
        this.tUserCollection = tUserCollection;
    }
    
}
