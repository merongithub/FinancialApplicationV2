/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.model;

import framework.externalInterfaces.IAddress;
import framework.externalInterfaces.ICustomer;
import framework.externalInterfaces.ICustomerFactory;

/**
 *
 * @author SHAHDAT
 */
public class CustomerFactory implements ICustomerFactory {

       @Override
	public ICustomer createCustomer(String name, String customerType,
			IAddress add, String email, String anyVal) {
		// TODO Auto-generated method stub
		if (customerType.equals("P")) {
			return new Person(name, email, add, anyVal);
		}
		return new Company(name, email, add, anyVal);
	}
    
    
    
}
