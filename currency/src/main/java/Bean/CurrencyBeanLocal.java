/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Bean;

import Entites.Currencyconversionrate;
import java.math.BigDecimal;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface CurrencyBeanLocal {

    Collection<Currencyconversionrate> getFromCurrency();

    BigDecimal convertCurrency(String fromCurrencyCode, String toCurrencyCode, BigDecimal amount);

}
