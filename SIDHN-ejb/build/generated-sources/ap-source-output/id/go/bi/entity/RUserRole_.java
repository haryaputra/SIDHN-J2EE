package id.go.bi.entity;

import id.go.bi.entity.TUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-10T10:05:30")
@StaticMetamodel(RUserRole.class)
public class RUserRole_ { 

    public static volatile SingularAttribute<RUserRole, Date> lastUpdated;
    public static volatile SingularAttribute<RUserRole, Date> createdDate;
    public static volatile SingularAttribute<RUserRole, String> updatedBy;
    public static volatile SingularAttribute<RUserRole, String> createdBy;
    public static volatile SingularAttribute<RUserRole, Character> roleId;
    public static volatile SingularAttribute<RUserRole, String> roleName;
    public static volatile CollectionAttribute<RUserRole, TUser> tUserCollection;

}