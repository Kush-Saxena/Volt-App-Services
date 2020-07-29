package com.volt.awssystem.jsonproducer;

import java.time.LocalTime;
import java.util.UUID;

public class ProducerShopData {

	private UUID shopId;

	private String shopName;

	private String address;

	private String categories;

	private LocalTime opentime;

	private LocalTime closingTime;

	private int openhours;

	private int delivertime;

	private float rating;

	private boolean isOn;

	public UUID getShopId() {
		return shopId;
	}

	public void setShopId(UUID shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public LocalTime getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

}
