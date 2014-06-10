/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.bi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Harya Putra
 */
@Embeddable
public class TDhnPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "NOMOR_DH", nullable = false, length = 7)
    private String nomorDh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "NO_URUT", nullable = false, length = 5)
    private String noUrut;

    public TDhnPK() {
    }

    public TDhnPK(String nomorDh, String noUrut) {
        this.nomorDh = nomorDh;
        this.noUrut = noUrut;
    }

    public String getNomorDh() {
        return nomorDh;
    }

    public void setNomorDh(String nomorDh) {
        this.nomorDh = nomorDh;
    }

    public String getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(String noUrut) {
        this.noUrut = noUrut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomorDh != null ? nomorDh.hashCode() : 0);
        hash += (noUrut != null ? noUrut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TDhnPK)) {
            return false;
        }
        TDhnPK other = (TDhnPK) object;
        if ((this.nomorDh == null && other.nomorDh != null) || (this.nomorDh != null && !this.nomorDh.equals(other.nomorDh))) {
            return false;
        }
        if ((this.noUrut == null && other.noUrut != null) || (this.noUrut != null && !this.noUrut.equals(other.noUrut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id.go.bi.entity.TDhnPK[ nomorDh=" + nomorDh + ", noUrut=" + noUrut + " ]";
    }
    
}
