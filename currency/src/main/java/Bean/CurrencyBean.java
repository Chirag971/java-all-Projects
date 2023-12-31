/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Bean;

import Entites.Currencyconversionrate;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Admin
 */
@Stateless
public class CurrencyBean implements CurrencyBeanLocal {

    @PersistenceContext(unitName = "currencypu")
    EntityManager em;

    @Override
    public Collection<Currencyconversionrate> getFromCurrency() {
        Collection<Currencyconversionrate> fcurrency = em.createNamedQuery("Currencyconversionrate.findAll").getResultList();
        return fcurrency;
    }

    @Override
    public BigDecimal convertCurrency(String fromCurrencyCode, String toCurrencyCode, BigDecimal amount) {
    TypedQuery<BigDecimal> query = em.createQuery(
        "SELECT c.conversionRate FROM Currencyconversionrate c " +
        "WHERE c.fromCurrency = :fromCurrency AND c.toCurrency = :toCurrency", BigDecimal.class);
    query.setParameter("fromCurrency", fromCurrencyCode);
    query.setParameter("toCurrency", toCurrencyCode);

    BigDecimal conversionRate = query.getSingleResult();
    if (conversionRate != null) {
        return amount.multiply(conversionRate);
    } else {
        throw new IllegalArgumentException("Conversion rate not found");
    }  
}

}
