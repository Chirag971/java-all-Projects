package Entity;

import Entity.Groupmaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-11-09T14:22:30")
@StaticMetamodel(Usermaster.class)
public class Usermaster_ { 

    public static volatile SingularAttribute<Usermaster, Integer> uid;
    public static volatile SingularAttribute<Usermaster, String> password;
    public static volatile SingularAttribute<Usermaster, Groupmaster> gname;
    public static volatile SingularAttribute<Usermaster, String> username;

}