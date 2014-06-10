/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idabagus
 */
@Entity
@Table(name = "R_KBI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RKbi.findAll", query = "SELECT r FROM RKbi r"),
    @NamedQuery(name = "RKbi.findBySandiSatker", query = "SELECT r FROM RKbi r WHERE r.sandiSatker = :sandiSatker"),
    @NamedQuery(name = "RKbi.findByNamaSatker", query = "SELECT r FROM RKbi r WHERE r.namaSatker = :namaSatker"),
    @NamedQuery(name = "RKbi.findByAlamat", query = "SELECT r FROM RKbi r WHERE r.alamat = :alamat"),
    @NamedQuery(name = "RKbi.findBySandiKota", query = "SELECT r FROM RKbi r WHERE r.sandiKota = :sandiKota"),
    @NamedQuery(name = "RKbi.findByRubrik", query = "SELECT r FROM RKbi r WHERE r.rubrik = :rubrik")})
public class RKbi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SANDI_SATKER")
    private String sandiSatker;
    @Size(max = 50)
    @Column(name = "NAMA_SATKER")
    private String namaSatker;
    @Size(max = 50)
    @Column(name = "ALAMAT")
    private String alamat;
    @Size(max = 4)
    @Column(name = "SANDI_KOTA")
    private String sandiKota;
    @Size(max = 10)
    @Column(name = "RUBRIK")
    private String rubrik;

    public RKbi() {
    }

    public RKbi(String sandiSatker) {
        this.sandiSatker = sandiSatker;
    }

    public String getSandiSatker() {
        return sandiSatker;
    }

    public void setSandiSatker(String sandiSatker) {
        this.sandiSatker = sandiSatker;
    }

    public String getNamaSatker() {
        return namaSatker;
    }

    public void setNamaSatker(String namaSatker) {
        this.namaSatker = namaSatker;
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

    public String getRubrik() {
        return rubrik;
    }

    public void setRubrik(String rubrik) {
        this.rubrik = rubrik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sandiSatker != null ? sandiSatker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RKbi)) {
            return false;
        }
        RKbi other = (RKbi) object;
        if ((this.sandiSatker == null && other.sandiSatker != null) || (this.sandiSatker != null && !this.sandiSatker.equals(other.sandiSatker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.RKbi[ sandiSatker=" + sandiSatker + " ]";
    }
    
}
