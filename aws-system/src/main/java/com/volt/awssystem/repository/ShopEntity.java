package com.volt.awssystem.repository;

import java.time.LocalTime;
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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.volt.awssystem.jsonconsumer.ConsumerShopData;

@Entity
public class ShopEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private UUID shopId;

	@Column(name = "name", length = 20, unique = true, nullable = false)
	private String shopName;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	private AddressEntity address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProductEntity> products = new ArrayList<ProductEntity>();;

	private String mainCategories;

	@Column(name = "rating", precision = 2, scale = 1, nullable = false)
	private float rating;

	@Column(nullable = false)
	private LocalTime openingTime;

	@Column(nullable = false)
	private int openHours;

	@Column(nullable = false)
	private int deliveryTime;

	@Column(nullable = false)
	private boolean isOn = true;

	// constructors

	public ShopEntity(ConsumerShopData shopData) {
		super();
		this.shopName = shopData.getName();
		AddressEntity shopAddress = new AddressEntity(shopData.getHno(), shopData.getAddressLine1(),
				shopData.getAddressLine2(), shopData.getPincode(), shopData.getState(), shopData.getCity(), this);
		this.address = shopAddress;
		this.mainCategories = shopData.getCategories();
		this.openingTime = shopData.getOpentime();
		this.openHours = shopData.getOpenhours();
		this.deliveryTime = shopData.getDelivertime();

	}

//	@PostLoad
//	private void afterLoad() {
//		this.closingTime = openingTime.plusHours(openHours);
//	}

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

	public LocalTime getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(LocalTime openingTime) {
		this.openingTime = openingTime;
	}

	public int getOpenHours() {
		return openHours;
	}

	public void setOpenHours(int openHours) {
		this.openHours = openHours;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
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
