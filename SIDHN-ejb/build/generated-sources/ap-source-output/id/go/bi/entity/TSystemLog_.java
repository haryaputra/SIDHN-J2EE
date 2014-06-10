package id.go.bi.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-10T10:05:30")
@StaticMetamodel(TSystemLog.class)
public class TSystemLog_ { 

    public static volatile SingularAttribute<TSystemLog, String> activity;
    public static volatile SingularAttribute<TSystemLog, String> remoteHost;
    public static volatile SingularAttribute<TSystemLog, Date> waktu;
    public static volatile SingularAttribute<TSystemLog, BigDecimal> logId;
    public static volatile SingularAttribute<TSystemLog, String> userId;

}