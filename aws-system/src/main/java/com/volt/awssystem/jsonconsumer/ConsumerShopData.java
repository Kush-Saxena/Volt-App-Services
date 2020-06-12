package com.volt.awssystem.jsonconsumer;

import java.time.LocalTime;

public class ConsumerShopData {

	// shop name
	private String name;

	// address

	private String hno;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private String state;

	private String pincode;

	// main categories
	private String categories;

	// time data
	private LocalTime opentime;

	private int openhours;

	private int delivertime;

	// To String

	@Override
	public String toString() {
		return "ConsumerShopData [name=" + name + ", hno=" + hno + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", categories="
				+ categories + ", opentime=" + opentime + ", openhours=" + openhours + ", delivertime=" + delivertime
				+ "]";
	}

	// Getter setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHno() {
		return hno;
	}

	public void setHno(String hno) {
		this.hno = hno;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public LocalTime getOpentime() {
		return opentime;
	}

	public void setOpentime(LocalTime opentime) {
		this.opentime = opentime;
	}

	public int getOpenhours() {
		return openhours;
	}

	public void setOpenhours(int openhours) {
		this.openhours = openhours;
	}

	public int getDelivertime() {
		return delivertime;
	}

	public void setDelivertime(int delivertime) {
		this.delivertime = delivertime;
	}

}
