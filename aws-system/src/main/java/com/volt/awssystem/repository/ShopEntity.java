package com.volt.awssystem.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ShopEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private UUID shopId;

	@Column(name = "Name", length = 20, unique = true)
	private String shopName;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private AddressEntity address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProductEntity> products = new ArrayList<ProductEntity>();;

	private String mainCategories;

	@Column(name = "rating", precision = 2, scale = 1)
	private float rating;

	private LocalDateTime openingTime;

	private LocalDateTime openHours;

	@Transient
	private LocalDateTime closingTime;

	private LocalDateTime deliveryTime;

	// constructors

	public ShopEntity(String shopName, AddressEntity address, String mainCategories, LocalDateTime openingTime,
			LocalDateTime openHours, LocalDateTime deliveryTime) {
		super();
		this.shopName = shopName;
		this.address = address;
		address.setShop(this);
		this.mainCategories = mainCategories;
		this.openingTime = openingTime;
		this.openHours = openHours;
		this.deliveryTime = deliveryTime;

	}

	@PostLoad
	private void populateClosingTime() {
		this.closingTime = openingTime.plusHours(openHours.getHour());
	}

	protected ShopEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public String getMainCategories() {
		return mainCategories;
	}

	public void setMainCategories(String mainCategories) {
		this.mainCategories = mainCategories;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public LocalDateTime getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(LocalDateTime openingTime) {
		this.openingTime = openingTime;
	}

	public LocalDateTime getOpenHours() {
		return openHours;
	}

	public void setOpenHours(LocalDateTime openHours) {
		this.openHours = openHours;
	}

	public LocalDateTime getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(LocalDateTime closingTime) {
		this.closingTime = closingTime;
	}

	public LocalDateTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public UUID getShopId() {
		return shopId;
	}

	public void addProduct(String productName, float price) {
		ProductEntity product = new ProductEntity(productName, price, this);
		products.add(product);

	}

	@Override
	public String toString() {
		return "ShopEntity [shopId=" + shopId + ", shopName=" + shopName + ", address=" + address + "]";
	}

}
