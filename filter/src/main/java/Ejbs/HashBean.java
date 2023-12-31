/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Ejbs;

import Entity.Groupmaster;
import Entity.Usermaster;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dell
 */
@Stateless
public class HashBean implements HashBeanLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Override
    public void Register(String username, String Password, String gname) {
        Groupmaster g = (Groupmaster) em.createNamedQuery("Groupmaster.findByGname")
                .setParameter("gname", gname)
                .getSingleResult();

        Usermaster user = new Usermaster();
        user.setUsername(username);
        user.setPassword(Password);
        user.setGname(g);

        em.persist(user);

    }

}
