/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package Bean;

import entities.PageVisits;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful

public class NewSessionBean implements NewSessionBeanLocal {

    @PersistenceContext(unitName = "visitpu")
    EntityManager entityManager;

    @Override
    public int recordVisit(String clientIp, String pageUrl) {
        try {
            Query query = entityManager.createQuery("SELECT p FROM PageVisits p WHERE p.clientIp = :clientIp AND p.pageUrl = :pageUrl");
            query.setParameter("clientIp", clientIp);
            query.setParameter("pageUrl", pageUrl);

            PageVisits pageVisit = (PageVisits) query.getSingleResult();

            // If the query returns a result, update the existing entity.
            pageVisit.setVisitCount(pageVisit.getVisitCount() + 1);
            entityManager.merge(pageVisit);

            return pageVisit.getVisitCount();
        } catch (NoResultException e) {
            // If no result is found, create a new entity.
            PageVisits pageVisit = new PageVisits();
            pageVisit.setClientIp(clientIp);
            pageVisit.setPageUrl(pageUrl);
            pageVisit.setVisitCount(1);
            entityManager.persist(pageVisit);

            return 1; // Since it's a new visit, return 1.
        }

    }
}
