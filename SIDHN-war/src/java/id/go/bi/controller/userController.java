/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.controller;

import id.go.bi.ejb.BankBean;
import id.go.bi.ejb.SimpleEncryption;
import id.go.bi.entity.TUser;
import id.go.bi.ejb.UserBean;
import id.go.bi.entity.RBank;
import id.go.bi.entity.RInstitusiBank;
import id.go.bi.entity.RKantorBank;
import id.go.bi.entity.RUserRole;
import id.go.bi.entity.RUserStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleSelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author idabagus
 */
@ManagedBean
@ViewScoped
public class userController implements Serializable {

    @EJB
    private UserBean userBean;
    @EJB
    private BankBean bankBean;
    @EJB
    private SimpleEncryption simpleEncryption;
    private TUser user;
    private String Username;
    private String NamaLengkap;
    private String Deskripsi;
    private char UserRole;
    private String AksesList;
    private String NamaInstitusi;
    private String KantorBank;
    private String Password;
    private String PasswordBaru;
    private String PasswordBaruConf;
    private Boolean exist = true;
    private Boolean inputcek = false;
    private List<RInstitusiBank> relatedBanks;
    private List<RKantorBank> relatedKantorBanks;
    private List<TUser> selectedUser;
    private TUser viewedUser;

    /**
     * Creates a new instance of userController
     */
    public userController() {
        user = new TUser();
    }
    
    @PostConstruct
    public void init() {
        selectedUser = new ArrayList<>();
        viewedUser = new TUser();
    }    

    public List<TUser> getUsers() {
        return userBean.getAllUser();
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public String getUsername() {
        return Username;
    }

    public String getNamaLengkap() {
        return NamaLengkap;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public char getUserRole() {
        return UserRole;
    }

    public String getAksesList() {
        return AksesList;
    }

    public String getNamaInstitusi() {
        return NamaInstitusi;
    }

    public String getKantorBank() {
        return KantorBank;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setNamaLengkap(String NamaLengkap) {
        this.NamaLengkap = NamaLengkap;
    }

    public void setDeskripsi(String Deskripsi) {
        this.Deskripsi = Deskripsi;
    }

    public void setUserRole(char UserRole) {
        this.UserRole = UserRole;
    }

    public void setAksesList(String AksesList) {
        this.AksesList = AksesList;
    }

    public void setNamaInstitusi(String NamaInstitusi) {
        this.NamaInstitusi = NamaInstitusi;
    }

    public void setKantorBank(String KantorBank) {
        this.KantorBank = KantorBank;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    public Boolean getExist() {
        return exist;
    }

    public Boolean getInputcek() {
        return inputcek;
    }

    public void setInputcek(Boolean inputcek) {
        this.inputcek = inputcek;
    }

    public TUser getUser() {
        return user;
    }

    public void setUser(TUser user) {
        this.user = user;
    }

    public String getPasswordBaru() {
        return PasswordBaru;
    }

    public String getPasswordBaruConf() {
        return PasswordBaruConf;
    }

    public void setPasswordBaru(String PasswordBaru) {
        this.PasswordBaru = PasswordBaru;
    }

    public void setPasswordBaruConf(String PasswordBaruConf) {
        this.PasswordBaruConf = PasswordBaruConf;
    }

    public List<TUser> getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(List<TUser> selectedUser) {
        this.selectedUser = selectedUser;
    }

    public TUser getViewedUser() {
        return viewedUser;
    }

    public void setViewedUser(TUser viewedUser) {
        this.viewedUser = viewedUser;
    }

    public void Reset() {
        Username = null;
        NamaLengkap = null;
        Deskripsi = null;
        UserRole = ' ';
        AksesList = null;
        NamaInstitusi = null;
        KantorBank = null;
        Password = null;
        exist = true;
        inputcek = false;
    }
    
    public boolean isExceedMaxItem() {
        return userBean.getAllUser().size() > 15;
    }
    
    public void Save(ActionEvent event) {
        String pass_aktif, pass_aktif_enc;
        pass_aktif = simpleEncryption.generateRandomPassword();
        pass_aktif_enc = simpleEncryption.encrypt(pass_aktif);
        setPasswordBaru(pass_aktif);

        user.setUserId(Username);
        user.setAccessType(AksesList);
        user.setFullName(NamaLengkap);
        user.setDeskripsi(Deskripsi);
        user.setRoleId(new RUserRole(UserRole));
        user.setSandiInstitusiBank(new RInstitusiBank(NamaInstitusi));
        user.setSandiBank(new RBank(NamaInstitusi.substring(0, 3)));
        user.setSandiKliring(new RKantorBank(KantorBank));
        user.setLoginTrial('0');
        user.setStatusAktif(new RUserStatus('0'));
        user.setPasswordAktif(pass_aktif_enc);

        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Object currentUser = session.getAttribute("userid");

        user.setApprovedBy((String) currentUser);
        user.setCreatedBy((String) currentUser);
        user.setUpdatedBy((String) currentUser);

        Calendar c = Calendar.getInstance();
        user.setApprovedDate(c.getTime());
        user.setCreatedDate(c.getTime());
        user.setLastLogin(c.getTime());
        user.setLastUpdated(c.getTime());

        c.add(Calendar.MONTH, 3);
        user.setExpiredDate(c.getTime());
        try {
            userBean.CreateUser(user);
            StringBuilder sb = new StringBuilder();
            sb.append(Username).append(" saved successfully");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    sb.toString(), null));
            RequestContext rcontext = RequestContext.getCurrentInstance();
            rcontext.execute("userDialog.show();");
            Reset();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    Username.concat(" not saved. Something goes wrong?"), null));
        }
    }

    public List<RUserRole> getAllUserRoles() {
        return userBean.getAllUserRoles();
    }

    public void getRelatedKantorBank(AjaxBehaviorEvent event) {
        if (this.UserRole == 'B') {
            relatedKantorBanks = bankBean.getKantorBank(this.NamaInstitusi, null);
        } else if (this.UserRole == 'A' || this.UserRole == 'S' || this.UserRole == 'O' || this.UserRole == 'W') {
            relatedKantorBanks = bankBean.getKantorBank(this.NamaInstitusi, "0010016");
        } else {
            relatedKantorBanks = null;
        }
    }

    public void getRelatedInstitusiBank(AjaxBehaviorEvent event) {
        if (this.UserRole == 'B') {
            relatedBanks = bankBean.getInstitusiBankExcept("0011");
        } else if (this.UserRole == 'A' || this.UserRole == 'S' || this.UserRole == 'O' || this.UserRole == 'W') {
            relatedBanks = bankBean.getInstitusiBank("001");
        } else {
            relatedBanks = null;
        }
    }

    public void changePassword(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Object currentUser = session.getAttribute("userid");
        setUser(userBean.getUser((String) currentUser));
        String msg;
        
        if (PasswordBaru.equals(PasswordBaruConf)) {
            String passLamaEnc = simpleEncryption.encrypt(Password);
            if (user.getPasswordAktif().equals(passLamaEnc)) {
                String passBarunEnc = simpleEncryption.encrypt(PasswordBaru);
                if (passBarunEnc.equals(user.getPasswordAktif())
                        || passBarunEnc.equals(user.getPassword1())
                        || passBarunEnc.equals(user.getPassword2())) {
                    msg = "Password baru tidak boleh sama dengan 3 password terakhir.";
                } else {

                    user.setPassword3(user.getPassword2());
                    user.setPassword2(user.getPassword1());
                    user.setPassword1(user.getPasswordAktif());
                    user.setPasswordAktif(simpleEncryption.encrypt(PasswordBaru));

                    Calendar c = Calendar.getInstance();
                    user.setLastUpdated(c.getTime());
                    userBean.UpdateUser(user);    
                    context.getExternalContext().invalidateSession();
                    msg = "Password berhasil diganti."
                            + "Silahkan login kembali dengan password baru.";
                }
            } else {
                msg = "Password lama anda salah.";
            }
        } else {
            msg = "Password baru tidak match.";
        }

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                msg, null));
    }

    public void checkUsername(ActionEvent event) {
        String msg;
        if (userBean.isExist(Username)) {
            exist = true;
            inputcek = false;
            msg = "".concat(Username).concat(" is occupied");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    msg, null));
        } else {
            exist = false;
            inputcek = true;
            msg = "".concat(Username).concat(" is available");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    msg, null));
        }
    }

    public List<RInstitusiBank> getRelatedBanks() {
        return relatedBanks;
    }

    public void setRelatedBanks(List<RInstitusiBank> relatedBanks) {
        this.relatedBanks = relatedBanks;
    }

    public void setRelatedKantorBanks(List<RKantorBank> relatedKantorBanks) {
        this.relatedKantorBanks = relatedKantorBanks;
    }

    public List<RKantorBank> getRelatedKantorBanks() {
        return relatedKantorBanks;
    }
    
    public void onRowSelect(SelectEvent event) {
        TUser u = (TUser) event.getObject();
        setViewedUser(u);
        setUserRole(u.getRoleId().getRoleId());
        setNamaInstitusi(u.getSandiInstitusiBank().getSandiInstitusiBank());
        setKantorBank(u.getSandiKliring().getSandiKantorBank());
        System.out.println(UserRole +"-"+NamaInstitusi+"-"+KantorBank);
    }

    public void onRowSelectCheckbox(SelectEvent event) {
        TUser u = (TUser) event.getObject();
        selectedUser.add(u);
    }

    public void onRowUnselectCheckbox(UnselectEvent event) {
        TUser u = (TUser) event.getObject();
        selectedUser.remove(u);
    }

    public void onToggleCheckbox(ToggleSelectEvent event) {
        if (event.isSelected()) {
            if (isExceedMaxItem()) {
                selectedUser = getUsers().subList(0, 14);
            } else {
                selectedUser = getUsers();
            }
        }
    }    
}
