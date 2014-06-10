package id.go.bi.entity;

import id.go.bi.entity.RBank;
import id.go.bi.entity.RInstitusiBank;
import id.go.bi.entity.RKantorBank;
import id.go.bi.entity.RUserRole;
import id.go.bi.entity.RUserStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-10T10:05:30")
@StaticMetamodel(TUser.class)
public class TUser_ { 

    public static volatile SingularAttribute<TUser, Date> lastLogin;
    public static volatile SingularAttribute<TUser, String> updatedBy;
    public static volatile SingularAttribute<TUser, RUserStatus> statusAktif;
    public static volatile SingularAttribute<TUser, RKantorBank> sandiKliring;
    public static volatile SingularAttribute<TUser, RUserRole> roleId;
    public static volatile SingularAttribute<TUser, Date> expiredDate;
    public static volatile SingularAttribute<TUser, String> approvedBy;
    public static volatile SingularAttribute<TUser, RBank> sandiBank;
    public static volatile SingularAttribute<TUser, String> fullName;
    public static volatile SingularAttribute<TUser, String> passwordAktif;
    public static volatile SingularAttribute<TUser, String> userId;
    public static volatile SingularAttribute<TUser, Date> approvedDate;
    public static volatile SingularAttribute<TUser, String> accessType;
    public static volatile SingularAttribute<TUser, Date> lastUpdated;
    public static volatile SingularAttribute<TUser, Date> createdDate;
    public static volatile SingularAttribute<TUser, Character> loginTrial;
    public static volatile SingularAttribute<TUser, String> password3;
    public static volatile SingularAttribute<TUser, String> createdBy;
    public static volatile SingularAttribute<TUser, String> password2;
    public static volatile SingularAttribute<TUser, String> password1;
    public static volatile SingularAttribute<TUser, String> deskripsi;
    public static volatile SingularAttribute<TUser, RInstitusiBank> sandiInstitusiBank;

}