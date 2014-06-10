/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.bi.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author Harya Putra
 */
@Entity
@Table(name = "T_DHN", catalog = "", schema = "DHN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TDhn.findAll", query = "SELECT t FROM TDhn t"),
    @NamedQuery(name = "TDhn.findByNomorDh", query = "SELECT t FROM TDhn t WHERE t.tDhnPK.nomorDh = :nomorDh"),
    @NamedQuery(name = "TDhn.findByNoUrut", query = "SELECT t FROM TDhn t WHERE t.tDhnPK.noUrut = :noUrut"),
    @NamedQuery(name = "TDhn.findByNomorReferensi", query = "SELECT t FROM TDhn t WHERE t.nomorReferensi = :nomorReferensi"),
    @NamedQuery(name = "TDhn.findByRekening", query = "SELECT t FROM TDhn t WHERE t.rekening = :rekening"),
    @NamedQuery(name = "TDhn.findBySandiKantorBank", query = "SELECT t FROM TDhn t WHERE t.sandiKantorBank = :sandiKantorBank"),
    @NamedQuery(name = "TDhn.findBySandiInstitusiBank", query = "SELECT t FROM TDhn t WHERE t.sandiInstitusiBank = :sandiInstitusiBank"),
    @NamedQuery(name = "TDhn.findByNamaBank", query = "SELECT t FROM TDhn t WHERE t.namaBank = :namaBank"),
    @NamedQuery(name = "TDhn.findByNamaNasabah", query = "SELECT t FROM TDhn t WHERE t.namaNasabah = :namaNasabah"),
    @NamedQuery(name = "TDhn.findByGelarJenisusaha", query = "SELECT t FROM TDhn t WHERE t.gelarJenisusaha = :gelarJenisusaha"),
    @NamedQuery(name = "TDhn.findBySandiJenisNasabah", query = "SELECT t FROM TDhn t WHERE t.sandiJenisNasabah = :sandiJenisNasabah"),
    @NamedQuery(name = "TDhn.findByNoIdentitas", query = "SELECT t FROM TDhn t WHERE t.noIdentitas = :noIdentitas"),
    @NamedQuery(name = "TDhn.findByNpwp", query = "SELECT t FROM TDhn t WHERE t.npwp = :npwp"),
    @NamedQuery(name = "TDhn.findByTanggalLahir", query = "SELECT t FROM TDhn t WHERE t.tanggalLahir = :tanggalLahir"),
    @NamedQuery(name = "TDhn.findByAlamatJalan", query = "SELECT t FROM TDhn t WHERE t.alamatJalan = :alamatJalan"),
    @NamedQuery(name = "TDhn.findByAlamatRt", query = "SELECT t FROM TDhn t WHERE t.alamatRt = :alamatRt"),
    @NamedQuery(name = "TDhn.findByAlamatRw", query = "SELECT t FROM TDhn t WHERE t.alamatRw = :alamatRw"),
    @NamedQuery(name = "TDhn.findByAlamatKota", query = "SELECT t FROM TDhn t WHERE t.alamatKota = :alamatKota"),
    @NamedQuery(name = "TDhn.findByAlamatPropinsi", query = "SELECT t FROM TDhn t WHERE t.alamatPropinsi = :alamatPropinsi"),
    @NamedQuery(name = "TDhn.findByAlamatKodepos", query = "SELECT t FROM TDhn t WHERE t.alamatKodepos = :alamatKodepos"),
    @NamedQuery(name = "TDhn.findByKeterangan", query = "SELECT t FROM TDhn t WHERE t.keterangan = :keterangan"),
    @NamedQuery(name = "TDhn.findByExpiredDh", query = "SELECT t FROM TDhn t WHERE t.expiredDh = :expiredDh"),
    @NamedQuery(name = "TDhn.findByFlagStatus", query = "SELECT t FROM TDhn t WHERE t.flagStatus = :flagStatus"),
    @NamedQuery(name = "TDhn.findByCreatedDate", query = "SELECT t FROM TDhn t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TDhn.findByCreatedBy", query = "SELECT t FROM TDhn t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "TDhn.findByLastUpdated", query = "SELECT t FROM TDhn t WHERE t.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "TDhn.findByUpdatedBy", query = "SELECT t FROM TDhn t WHERE t.updatedBy = :updatedBy"),
    @NamedQuery(name = "TDhn.findByCancelDate", query = "SELECT t FROM TDhn t WHERE t.cancelDate = :cancelDate"),
    @NamedQuery(name = "TDhn.findByCancelBy", query = "SELECT t FROM TDhn t WHERE t.cancelBy = :cancelBy"),
    @NamedQuery(name = "TDhn.findByFlagAccess", query = "SELECT t FROM TDhn t WHERE t.flagAccess = :flagAccess"),
    @NamedQuery(name = "TDhn.findByDhibId", query = "SELECT t FROM TDhn t WHERE t.dhibId = :dhibId")})
public class TDhn implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TDhnPK tDhnPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMOR_REFERENSI", nullable = false, length = 20)
    private String nomorReferensi;
    @Size(max = 16)
    @Column(name = "REKENING", length = 16)
    private String rekening;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "SANDI_KANTOR_BANK", nullable = false, length = 7)
    private String sandiKantorBank;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SANDI_INSTITUSI_BANK", nullable = false, length = 4)
    private String sandiInstitusiBank;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NAMA_BANK", nullable = false, length = 40)
    private String namaBank;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NAMA_NASABAH", nullable = false, length = 40)
    private String namaNasabah;
    @Size(max = 20)
    @Column(name = "GELAR_JENISUSAHA", length = 20)
    private String gelarJenisusaha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SANDI_JENIS_NASABAH", nullable = false)
    private Character sandiJenisNasabah;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NO_IDENTITAS", nullable = false, length = 30)
    private String noIdentitas;
    @Size(max = 15)
    @Column(name = "NPWP", length = 15)
    private String npwp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TANGGAL_LAHIR", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalLahir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ALAMAT_JALAN", nullable = false, length = 40)
    private String alamatJalan;
    @Size(max = 3)
    @Column(name = "ALAMAT_RT", length = 3)
    private String alamatRt;
    @Size(max = 3)
    @Column(name = "ALAMAT_RW", length = 3)
    private String alamatRw;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ALAMAT_KOTA", nullable = false, length = 20)
    private String alamatKota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ALAMAT_PROPINSI", nullable = false, length = 20)
    private String alamatPropinsi;
    @Size(max = 5)
    @Column(name = "ALAMAT_KODEPOS", length = 5)
    private String alamatKodepos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "KETERANGAN", nullable = false, length = 13)
    private String keterangan;
    @Column(name = "EXPIRED_DH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FLAG_STATUS", nullable = false, length = 1)
    private String flagStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CREATED_BY", nullable = false, length = 12)
    private String createdBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_UPDATED", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "UPDATED_BY", nullable = false, length = 12)
    private String updatedBy;
    @Column(name = "CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;
    @Size(max = 12)
    @Column(name = "CANCEL_BY", length = 12)
    private String cancelBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLAG_ACCESS", nullable = false)
    private Character flagAccess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DHIB_ID", nullable = false)
    private BigInteger dhibId;

    public TDhn() {
    }

    public TDhn(TDhnPK tDhnPK) {
        this.tDhnPK = tDhnPK;
    }

    public TDhn(TDhnPK tDhnPK, String nomorReferensi, String sandiKantorBank, String sandiInstitusiBank, String namaBank, String namaNasabah, Character sandiJenisNasabah, String noIdentitas, Date tanggalLahir, String alamatJalan, String alamatKota, String alamatPropinsi, String keterangan, String flagStatus, Date createdDate, String createdBy, Date lastUpdated, String updatedBy, Character flagAccess, BigInteger dhibId) {
        this.tDhnPK = tDhnPK;
        this.nomorReferensi = nomorReferensi;
        this.sandiKantorBank = sandiKantorBank;
        this.sandiInstitusiBank = sandiInstitusiBank;
        this.namaBank = namaBank;
        this.namaNasabah = namaNasabah;
        this.sandiJenisNasabah = sandiJenisNasabah;
        this.noIdentitas = noIdentitas;
        this.tanggalLahir = tanggalLahir;
        this.alamatJalan = alamatJalan;
        this.alamatKota = alamatKota;
        this.alamatPropinsi = alamatPropinsi;
        this.keterangan = keterangan;
        this.flagStatus = flagStatus;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.lastUpdated = lastUpdated;
        this.updatedBy = updatedBy;
        this.flagAccess = flagAccess;
        this.dhibId = dhibId;
    }

    public TDhn(String nomorDh, String noUrut) {
        this.tDhnPK = new TDhnPK(nomorDh, noUrut);
    }

    public TDhnPK getTDhnPK() {
        return tDhnPK;
    }

    public void setTDhnPK(TDhnPK tDhnPK) {
        this.tDhnPK = tDhnPK;
    }

    public String getNomorReferensi() {
        return nomorReferensi;
    }

    public void setNomorReferensi(String nomorReferensi) {
        this.nomorReferensi = nomorReferensi;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public String getSandiKantorBank() {
        return sandiKantorBank;
    }

    public void setSandiKantorBank(String sandiKantorBank) {
        this.sandiKantorBank = sandiKantorBank;
    }

    public String getSandiInstitusiBank() {
        return sandiInstitusiBank;
    }

    public void setSandiInstitusiBank(String sandiInstitusiBank) {
        this.sandiInstitusiBank = sandiInstitusiBank;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public String getGelarJenisusaha() {
        return gelarJenisusaha;
    }

    public void setGelarJenisusaha(String gelarJenisusaha) {
        this.gelarJenisusaha = gelarJenisusaha;
    }

    public Character getSandiJenisNasabah() {
        return sandiJenisNasabah;
    }

    public void setSandiJenisNasabah(Character sandiJenisNasabah) {
        this.sandiJenisNasabah = sandiJenisNasabah;
    }

    public String getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamatJalan() {
        return alamatJalan;
    }

    public void setAlamatJalan(String alamatJalan) {
        this.alamatJalan = alamatJalan;
    }

    public String getAlamatRt() {
        return alamatRt;
    }

    public void setAlamatRt(String alamatRt) {
        this.alamatRt = alamatRt;
    }

    public String getAlamatRw() {
        return alamatRw;
    }

    public void setAlamatRw(String alamatRw) {
        this.alamatRw = alamatRw;
    }

    public String getAlamatKota() {
        return alamatKota;
    }

    public void setAlamatKota(String alamatKota) {
        this.alamatKota = alamatKota;
    }

    public String getAlamatPropinsi() {
        return alamatPropinsi;
    }

    public void setAlamatPropinsi(String alamatPropinsi) {
        this.alamatPropinsi = alamatPropinsi;
    }

    public String getAlamatKodepos() {
        return alamatKodepos;
    }

    public void setAlamatKodepos(String alamatKodepos) {
        this.alamatKodepos = alamatKodepos;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getExpiredDh() {
        return expiredDh;
    }

    public void setExpiredDh(Date expiredDh) {
        this.expiredDh = expiredDh;
    }

    public String getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(String flagStatus) {
        this.flagStatus = flagStatus;
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

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getCancelBy() {
        return cancelBy;
    }

    public void setCancelBy(String cancelBy) {
        this.cancelBy = cancelBy;
    }

    public Character getFlagAccess() {
        return flagAccess;
    }

    public void setFlagAccess(Character flagAccess) {
        this.flagAccess = flagAccess;
    }

    public BigInteger getDhibId() {
        return dhibId;
    }

    public void setDhibId(BigInteger dhibId) {
        this.dhibId = dhibId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tDhnPK != null ? tDhnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDhn)) {
            return false;
        }
        TDhn other = (TDhn) object;
        if ((this.tDhnPK == null && other.tDhnPK != null) || (this.tDhnPK != null && !this.tDhnPK.equals(other.tDhnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.TDhn[ tDhnPK=" + tDhnPK + " ]";
    }
    
}
