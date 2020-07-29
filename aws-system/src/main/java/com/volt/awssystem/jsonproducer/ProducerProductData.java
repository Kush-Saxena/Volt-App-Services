package com.volt.awssystem.jsonproducer;

import java.util.UUID;

public class ProducerProductData {

	private UUID shopId;

	private String name;

	private float price;

	private boolean isOn;
	
	private String shopName;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public UUID getShopId() {
		return shopId;
	}

	public void setShopId(UUID shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

}
