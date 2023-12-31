/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Bean;

import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface NewSessionBeanLocal {
    public int recordVisit(String clientIp, String pageUrl);
}
