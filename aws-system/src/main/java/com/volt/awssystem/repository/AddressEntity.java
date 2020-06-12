package com.volt.awssystem.repository;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AddressEntity implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(updatable = false, insertable = false, nullable = false)
	private UUID id;

	private String hno = "default";

	private String addressLine1 = "default";

	private String addressLine2 = "default";

	private String pinCode = "default";

	private String state = "default";

	private String city = "default";

	@JsonBackReference
	@OneToOne
	private ShopEntity shop;

	// getters setters

	public ShopEntity getShop() {
		return shop;
	}

	public void setShop(ShopEntity shop) {
		this.shop = shop;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// Does not allow an empty address.

	public AddressEntity(String hno, String addressLine1, String addressLine2, String pinCode, String state,
			String city) {
		super();
		this.hno = hno;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.pinCode = pinCode;
		this.state = state;
		this.city = city;
	}

	@Override
	protected Object clone() {
		return new AddressEntity(hno, addressLine1, addressLine2, pinCode, state, city);
	}

	@Override
	public boolean equals(Object obj) {
		AddressEntity temp = (AddressEntity) obj;
		if (hno.equals(temp.hno) && addressLine1.equals(temp.addressLine1) && addressLine2.equals(temp.addressLine2)
				&& pinCode.equals(temp.pinCode) && state.equals(temp.state) && city.equals(temp.city)) {

			return true;

		}

		return false;

	}

	@Override
	public String toString() {
		return "Hno=" + hno + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", pinCode="
				+ pinCode + ", state=" + state + ", city=" + city;
	}

	protected AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}