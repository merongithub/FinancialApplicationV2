package framework.model;

import framework.externalInterfaces.IAddress;

public class Address implements IAddress {

	private String street;
	private String city;
	private String state;
	private String zip;

	public Address(String street, String city, String state, String zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	@Override
	public String getStreet() {
		// TODO Auto-generated method stub
		return street;
	}

	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return city;
	}

	@Override
	public String getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String getZip() {
		// TODO Auto-generated method stub
		return zip;
	}

	@Override
	public String getAddressDetails() {
		return street + " " + city + " " + state + " " + zip + " ";
	}

}
