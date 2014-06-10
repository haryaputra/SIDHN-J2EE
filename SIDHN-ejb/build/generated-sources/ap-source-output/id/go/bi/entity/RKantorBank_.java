package id.go.bi.entity;

import id.go.bi.entity.TUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-10T10:05:30")
@StaticMetamodel(RKantorBank.class)
public class RKantorBank_ { 

    public static volatile SingularAttribute<RKantorBank, Character> sandiJenisUsaha;
    public static volatile SingularAttribute<RKantorBank, String> noTelp;
    public static volatile SingularAttribute<RKantorBank, String> sandiKantorBank;
    public static volatile SingularAttribute<RKantorBank, String> alamat;
    public static volatile SingularAttribute<RKantorBank, Character> sandiStatusKantor;
    public static volatile SingularAttribute<RKantorBank, Character> sandiStatusKoordinator;
    public static volatile SingularAttribute<RKantorBank, Date> tglAktif;
    public static volatile SingularAttribute<RKantorBank, Character> statusKliring;
    public static volatile SingularAttribute<RKantorBank, String> namaBank;
    public static volatile SingularAttribute<RKantorBank, String> namaKantor;
    public static volatile SingularAttribute<RKantorBank, String> sandiKota;
    public static volatile CollectionAttribute<RKantorBank, TUser> tUserCollection;
    public static volatile SingularAttribute<RKantorBank, String> sandiSatker;
    public static volatile SingularAttribute<RKantorBank, String> sandiWilayahKliring;
    public static volatile SingularAttribute<RKantorBank, String> sandiInstitusiBank;
    public static volatile SingularAttribute<RKantorBank, String> sandiPropinsi;

}