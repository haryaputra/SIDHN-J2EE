/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.controller;

import id.go.bi.ejb.ParameterBean;
import id.go.bi.entity.RParam;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author idabagus
 */
@ManagedBean
@RequestScoped
@Singleton
public class parameterController implements Serializable {

    @EJB
    private ParameterBean parameterBean;
    private RParam StartCollectP1, EndCollectP1, StartReportP1, EndReportP1;
    private RParam StartCollectP2, EndCollectP2, StartReportP2, EndReportP2;
    private RParam IPAddressRTGS, UsernameRTGS, PasswordRTGS, UnitBuku, RekeningTerima;
    private RParam IPAddressSKN, UsernameSKN, PasswordSKN, SSKConnAS, SSKDB, SSKH0, SSKH1, LastSync, AlasanTolak;
    private Map params;

    /**
     * Creates a new instance of parameterController
     */
    public parameterController() {
        StartCollectP1 = new RParam();
        EndCollectP1 = new RParam();
        StartReportP1 = new RParam();
        EndReportP1 = new RParam();
        StartCollectP2 = new RParam();
        EndCollectP2 = new RParam();
        StartReportP2 = new RParam();
        EndReportP2 = new RParam();

        IPAddressSKN = new RParam();
        UsernameSKN = new RParam();
        PasswordSKN = new RParam();
        SSKConnAS = new RParam();
        SSKDB = new RParam();
        SSKH0 = new RParam();
        SSKH1 = new RParam();
        LastSync = new RParam();
        AlasanTolak = new RParam();

        IPAddressRTGS = new RParam();
        UsernameRTGS = new RParam();
        PasswordRTGS = new RParam();
        UnitBuku = new RParam();
        RekeningTerima = new RParam();
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    @PostConstruct
    public void init() {
        params = parameterBean.getAllParam();

        StartCollectP1.setParamName("bd_p1");
        EndCollectP1.setParamName("ed_p1");
        StartReportP1.setParamName("br_p1");
        EndReportP1.setParamName("er_p1");
        StartCollectP2.setParamName("bd_p2");
        EndCollectP2.setParamName("ed_p2");
        StartReportP2.setParamName("br_p2");
        EndReportP2.setParamName("er_p2");

        StartCollectP1.setParamValue((String) params.get("bd_p1"));
        EndCollectP1.setParamValue((String) params.get("ed_p1"));
        StartReportP1.setParamValue((String) params.get("br_p1"));
        EndReportP1.setParamValue((String) params.get("er_p1"));
        StartCollectP2.setParamValue((String) params.get("bd_p2"));
        EndCollectP2.setParamValue((String) params.get("ed_p2"));
        StartReportP2.setParamValue((String) params.get("br_p2"));
        EndReportP2.setParamValue((String) params.get("er_p2"));

        IPAddressRTGS.setParamName("ip_rtgs");
        UsernameRTGS.setParamName("user_rtgs");
        PasswordRTGS.setParamName("pwd_rtgs");
        UnitBuku.setParamName("ub_rtgs");
        RekeningTerima.setParamName("ma_rtgs");

        IPAddressRTGS.setParamValue((String) params.get("ip_rtgs"));
        UsernameRTGS.setParamValue((String) params.get("user_rtgs"));
        PasswordRTGS.setParamValue((String) params.get("pwd_rtgs"));
        UnitBuku.setParamValue((String) params.get("ub_rtgs"));
        RekeningTerima.setParamValue((String) params.get("ma_rtgs"));

        IPAddressSKN.setParamName("ip_skn");
        UsernameSKN.setParamName("user_skn");
        PasswordSKN.setParamName("pass_skn");
        SSKConnAS.setParamName("ssk_connect_as");
        SSKDB.setParamName("ssk_db_name");
        SSKH0.setParamName("ssk_h0");
        SSKH1.setParamName("ssk_h1");
        LastSync.setParamName("last_imported");
        AlasanTolak.setParamName("reason_no");

        IPAddressSKN.setParamValue((String) params.get("ip_skn"));
        UsernameSKN.setParamValue((String) params.get("user_skn"));
        PasswordSKN.setParamValue((String) params.get("pass_skn"));
        SSKConnAS.setParamValue((String) params.get("ssk_connect_as"));
        SSKDB.setParamValue((String) params.get("ssk_db_name"));
        SSKH0.setParamValue((String) params.get("ssk_h0"));
        SSKH1.setParamValue((String) params.get("ssk_h1"));
        LastSync.setParamValue((String) params.get("last_imported"));
        AlasanTolak.setParamValue((String) params.get("reason_no"));
    }

    public RParam getStartCollectP1() {
        return StartCollectP1;
    }

    public void setStartCollectP1(RParam StartCollectP1) {
        this.StartCollectP1 = StartCollectP1;
    }

    public RParam getEndCollectP1() {
        return EndCollectP1;
    }

    public void setEndCollectP1(RParam EndCollectP1) {
        this.EndCollectP1 = EndCollectP1;
    }

    public RParam getStartReportP1() {
        return StartReportP1;
    }

    public void setStartReportP1(RParam StartReportP1) {
        this.StartReportP1 = StartReportP1;
    }

    public RParam getEndReportP1() {
        return EndReportP1;
    }

    public void setEndReportP1(RParam EndReportP1) {
        this.EndReportP1 = EndReportP1;
    }

    public RParam getStartCollectP2() {
        return StartCollectP2;
    }

    public void setStartCollectP2(RParam StartCollectP2) {
        this.StartCollectP2 = StartCollectP2;
    }

    public RParam getEndCollectP2() {
        return EndCollectP2;
    }

    public void setEndCollectP2(RParam EndCollectP2) {
        this.EndCollectP2 = EndCollectP2;
    }

    public RParam getStartReportP2() {
        return StartReportP2;
    }

    public void setStartReportP2(RParam StartReportP2) {
        this.StartReportP2 = StartReportP2;
    }

    public RParam getEndReportP2() {
        return EndReportP2;
    }

    public void setEndReportP2(RParam EndReportP2) {
        this.EndReportP2 = EndReportP2;
    }

    public RParam getIPAddressRTGS() {
        return IPAddressRTGS;
    }

    public void setIPAddressRTGS(RParam IPAddressRTGS) {
        this.IPAddressRTGS = IPAddressRTGS;
    }

    public RParam getUsernameRTGS() {
        return UsernameRTGS;
    }

    public void setUsernameRTGS(RParam UsernameRTGS) {
        this.UsernameRTGS = UsernameRTGS;
    }

    public RParam getPasswordRTGS() {
        return PasswordRTGS;
    }

    public void setPasswordRTGS(RParam PasswordRTGS) {
        this.PasswordRTGS = PasswordRTGS;
    }

    public RParam getUnitBuku() {
        return UnitBuku;
    }

    public void setUnitBuku(RParam UnitBuku) {
        this.UnitBuku = UnitBuku;
    }

    public RParam getRekeningTerima() {
        return RekeningTerima;
    }

    public void setRekeningTerima(RParam RekeningTerima) {
        this.RekeningTerima = RekeningTerima;
    }

    public RParam getIPAddressSKN() {
        return IPAddressSKN;
    }

    public void setIPAddressSKN(RParam IPAddressSKN) {
        this.IPAddressSKN = IPAddressSKN;
    }

    public RParam getUsernameSKN() {
        return UsernameSKN;
    }

    public void setUsernameSKN(RParam UsernameSKN) {
        this.UsernameSKN = UsernameSKN;
    }

    public RParam getPasswordSKN() {
        return PasswordSKN;
    }

    public void setPasswordSKN(RParam PasswordSKN) {
        this.PasswordSKN = PasswordSKN;
    }

    public RParam getSSKConnAS() {
        return SSKConnAS;
    }

    public void setSSKConnAS(RParam SSKConnAS) {
        this.SSKConnAS = SSKConnAS;
    }

    public RParam getSSKDB() {
        return SSKDB;
    }

    public void setSSKDB(RParam SSKDB) {
        this.SSKDB = SSKDB;
    }

    public RParam getSSKH0() {
        return SSKH0;
    }

    public void setSSKH0(RParam SSKH0) {
        this.SSKH0 = SSKH0;
    }

    public RParam getSSKH1() {
        return SSKH1;
    }

    public void setSSKH1(RParam SSKH1) {
        this.SSKH1 = SSKH1;
    }

    public RParam getLastSync() {
        return LastSync;
    }

    public void setLastSync(RParam LastSync) {
        this.LastSync = LastSync;
    }

    public RParam getAlasanTolak() {
        return AlasanTolak;
    }

    public void setAlasanTolak(RParam AlasanTolak) {
        this.AlasanTolak = AlasanTolak;
    }

    public void UpdateParameterDHB(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Object currentUser = session.getAttribute("userid");

        try {
            Calendar c = Calendar.getInstance();
            IPAddressSKN.setLastUpdated(c.getTime());
            UsernameSKN.setLastUpdated(c.getTime());
            PasswordSKN.setLastUpdated(c.getTime());
            SSKConnAS.setLastUpdated(c.getTime());
            SSKDB.setLastUpdated(c.getTime());
            SSKH0.setLastUpdated(c.getTime());
            SSKH1.setLastUpdated(c.getTime());
            LastSync.setLastUpdated(c.getTime());
            AlasanTolak.setLastUpdated(c.getTime());

            IPAddressSKN.setUpdatedBy((String) currentUser);
            UsernameSKN.setUpdatedBy((String) currentUser);
            PasswordSKN.setUpdatedBy((String) currentUser);
            SSKConnAS.setUpdatedBy((String) currentUser);
            SSKDB.setUpdatedBy((String) currentUser);
            SSKH0.setUpdatedBy((String) currentUser);
            SSKH1.setUpdatedBy((String) currentUser);
            LastSync.setUpdatedBy((String) currentUser);
            AlasanTolak.setUpdatedBy((String) currentUser);

            parameterBean.UpdateParam(IPAddressSKN);
            parameterBean.UpdateParam(UsernameSKN);
            parameterBean.UpdateParam(PasswordSKN);
            parameterBean.UpdateParam(SSKConnAS);
            parameterBean.UpdateParam(SSKDB);
            parameterBean.UpdateParam(SSKH0);
            parameterBean.UpdateParam(SSKH1);
            parameterBean.UpdateParam(LastSync);
            parameterBean.UpdateParam(AlasanTolak);

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Parameter DHB berhasil di update", null));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Something goes wrong.", null));
        }
    }

    public void UpdateInterfaceSistem(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Object currentUser = session.getAttribute("userid");

        try {
            Calendar c = Calendar.getInstance();
            IPAddressRTGS.setLastUpdated(c.getTime());
            UsernameRTGS.setLastUpdated(c.getTime());
            PasswordRTGS.setLastUpdated(c.getTime());
            UnitBuku.setLastUpdated(c.getTime());
            RekeningTerima.setLastUpdated(c.getTime());

            IPAddressRTGS.setUpdatedBy((String) currentUser);
            UsernameRTGS.setUpdatedBy((String) currentUser);
            PasswordRTGS.setUpdatedBy((String) currentUser);
            UnitBuku.setUpdatedBy((String) currentUser);
            RekeningTerima.setUpdatedBy((String) currentUser);

            parameterBean.UpdateParam(IPAddressRTGS);
            parameterBean.UpdateParam(UsernameRTGS);
            parameterBean.UpdateParam(PasswordRTGS);
            parameterBean.UpdateParam(UnitBuku);
            parameterBean.UpdateParam(RekeningTerima);

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Parameter Interface Sistem berhasil di update", null));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Something goes wrong.", null));
        }
    }

    public void UpdatePeriodeDHIB(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Object currentUser = session.getAttribute("userid");

        try {
            Calendar c = Calendar.getInstance();
            StartCollectP1.setLastUpdated(c.getTime());
            EndCollectP1.setLastUpdated(c.getTime());
            StartReportP1.setLastUpdated(c.getTime());
            EndReportP1.setLastUpdated(c.getTime());
            StartCollectP2.setLastUpdated(c.getTime());
            EndCollectP2.setLastUpdated(c.getTime());
            StartReportP2.setLastUpdated(c.getTime());
            EndReportP2.setLastUpdated(c.getTime());

            StartCollectP1.setUpdatedBy((String) currentUser);
            EndCollectP1.setUpdatedBy((String) currentUser);
            StartReportP1.setUpdatedBy((String) currentUser);
            EndReportP1.setUpdatedBy((String) currentUser);
            StartCollectP2.setUpdatedBy((String) currentUser);
            EndCollectP2.setUpdatedBy((String) currentUser);
            StartReportP2.setUpdatedBy((String) currentUser);
            EndReportP2.setUpdatedBy((String) currentUser);

            parameterBean.UpdateParam(StartCollectP1);
            parameterBean.UpdateParam(EndCollectP1);
            parameterBean.UpdateParam(StartReportP1);
            parameterBean.UpdateParam(EndReportP1);
            parameterBean.UpdateParam(StartCollectP2);
            parameterBean.UpdateParam(EndCollectP2);
            parameterBean.UpdateParam(StartReportP2);
            parameterBean.UpdateParam(EndReportP2);

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Periode DHIB berhasil di update", null));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Something goes wrong.", null));
        }
    }
}
