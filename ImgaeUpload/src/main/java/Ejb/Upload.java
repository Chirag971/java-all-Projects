package Ejb;

import Entity.Person;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Upload implements UploadLocal {

    @PersistenceContext(unitName = "imagepu")
    EntityManager em;

    @Override
    public boolean addPhoto(String pname, String pimage) {
        try {
            Person p = new Person();
            p.setPname(pname);
            p.setPimage(pimage);
            em.persist(p);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    public Collection<Person> getall() {
            Collection<Person> p = em.createNamedQuery("Person.findAll").getResultList();
            return p;
    }

}
