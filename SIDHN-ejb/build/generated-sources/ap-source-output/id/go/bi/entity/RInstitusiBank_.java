package id.go.bi.entity;

import id.go.bi.entity.TUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-10T10:05:30")
@StaticMetamodel(RInstitusiBank.class)
public class RInstitusiBank_ { 

    public static volatile SingularAttribute<RInstitusiBank, String> rekening;
    public static volatile SingularAttribute<RInstitusiBank, String> namaSingkat;
    public static volatile SingularAttribute<RInstitusiBank, Character> sandiJenisUsaha;
    public static volatile SingularAttribute<RInstitusiBank, String> namaBank;
    public static volatile SingularAttribute<RInstitusiBank, String> sandiBank;
    public static volatile CollectionAttribute<RInstitusiBank, TUser> tUserCollection;
    public static volatile SingularAttribute<RInstitusiBank, String> sandiInstitusiBank;

}