package Entity;

import Entity.Usermaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-09T14:22:30")
@StaticMetamodel(Groupmaster.class)
public class Groupmaster_ { 

    public static volatile SingularAttribute<Groupmaster, Integer> gid;
    public static volatile CollectionAttribute<Groupmaster, Usermaster> usermasterCollection;
    public static volatile SingularAttribute<Groupmaster, String> gname;

}