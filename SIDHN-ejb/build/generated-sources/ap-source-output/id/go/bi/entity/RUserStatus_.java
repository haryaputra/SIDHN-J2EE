package id.go.bi.entity;

import id.go.bi.entity.TUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-10T10:05:30")
@StaticMetamodel(RUserStatus.class)
public class RUserStatus_ { 

    public static volatile SingularAttribute<RUserStatus, Date> lastUpdated;
    public static volatile SingularAttribute<RUserStatus, Character> userStatus;
    public static volatile SingularAttribute<RUserStatus, String> statusDesc;
    public static volatile SingularAttribute<RUserStatus, Date> createdDate;
    public static volatile SingularAttribute<RUserStatus, String> updatedBy;
    public static volatile SingularAttribute<RUserStatus, String> createdBy;
    public static volatile CollectionAttribute<RUserStatus, TUser> tUserCollection;

}