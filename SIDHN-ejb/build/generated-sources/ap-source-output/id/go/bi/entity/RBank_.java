package id.go.bi.entity;

import id.go.bi.entity.TUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-10T10:05:30")
@StaticMetamodel(RBank.class)
public class RBank_ { 

    public static volatile SingularAttribute<RBank, Character> statusPeserta;
    public static volatile SingularAttribute<RBank, String> namaSingkat;
    public static volatile SingularAttribute<RBank, String> namaBank;
    public static volatile SingularAttribute<RBank, String> sandiBank;
    public static volatile SingularAttribute<RBank, String> sandiJenisBank;
    public static volatile CollectionAttribute<RBank, TUser> tUserCollection;

}