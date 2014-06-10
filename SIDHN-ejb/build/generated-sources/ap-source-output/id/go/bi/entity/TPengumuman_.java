package id.go.bi.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-10T10:05:30")
@StaticMetamodel(TPengumuman.class)
public class TPengumuman_ { 

    public static volatile SingularAttribute<TPengumuman, Date> createdDate;
    public static volatile SingularAttribute<TPengumuman, String> createdBy;
    public static volatile SingularAttribute<TPengumuman, BigDecimal> pengumumanId;
    public static volatile SingularAttribute<TPengumuman, String> judul;
    public static volatile SingularAttribute<TPengumuman, String> isi;

}