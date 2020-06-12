package com.volt.awssystem.jsonconsumer;

import java.util.UUID;

public class ConsumerProductData {

	private UUID shopid; // replace later by api key or add some other type of
							// authentication/authorization

	private String name;

	private float price;

	public UUID getShopid() {
		return shopid;
	}

	public void setShopid(UUID shopid) {
		this.shopid = shopid;
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


}
