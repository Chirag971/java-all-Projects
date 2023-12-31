/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import Entity.Registermaster;
import Entity.Rolemaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dell
 */
@Stateless
public class register implements registerLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Override
    public boolean Register(String Name, String email, String password, String username) {
        try {
            if (Name == null || email == null || password == null || username == null) {
                throw new IllegalArgumentException("Please enter valid values for Name, email, password, and username.");
            } else {
                // Find or create Rolemaster
                Rolemaster ro = em.find(Rolemaster.class, username);
                if (ro == null) {
                    ro = new Rolemaster();
                    ro.setUserName(username);
                    ro.setRole("User");
                    em.persist(ro);
                }

                // Create Registermaster
                Registermaster user = new Registermaster();
                user.setName(Name);
                user.setEmail(email);
                user.setPassword(password);
                user.setUserName(ro);

                // Update relationships
                Collection<Registermaster> reg = ro.getRegistermasterCollection();
                reg.add(user);
                ro.setRegistermasterCollection(reg);

                // Persist entities
                em.persist(user);
                em.merge(ro);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or use a logger
            return false;
        }
    }

}
