/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
@Local
public class CurrencyConverterBean implements CurrencyConverterBeanLocal {

     @PersistenceContext(unitName = "persistence")
    private EntityManager em;
     public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        TypedQuery<Double> query = em.createQuery(
            "SELECT c.conversionRate FROM CurrencyConversionRate c " +
            "WHERE c.fromCurrency = :fromCurrency AND c.toCurrency = :toCurrency", Double.class);
        query.setParameter("fromCurrency", fromCurrency);
        query.setParameter("toCurrency", toCurrency);

        Double conversionRate = query.getSingleResult();
        if (conversionRate != null) {
            return amount * conversionRate;
        } else {
            throw new IllegalArgumentException("Conversion rate not found");
        }
    }
}
