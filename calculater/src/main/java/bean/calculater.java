/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package bean;

import javax.ejb.Stateless;

/**
 *
 * @author Admin
 */
@Stateless
public class calculater {

    public int add(int a, int b) {
        return a + b;
    }
}
