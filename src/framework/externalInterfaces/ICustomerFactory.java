/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.externalInterfaces;

/**
 *
 * @author SHAHDAT
 */
public interface ICustomerFactory {
 public ICustomer createCustomer(String name, String customerType,
			IAddress add, String email, String anyVal);
}
