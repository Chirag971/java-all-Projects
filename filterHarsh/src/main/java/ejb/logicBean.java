/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

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
public class logicBean implements logicBeanLocal {

    @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    @Override
    public void addUsers(String username, String password, String gname) {
        Groupmaster gn = em.find(Groupmaster.class, gname);
        Usermaster u = new Usermaster();
        u.setUsername(username);
        u.setPassword(password);
        u.setGname(gn);
        em.persist(u);
    }

    
}
