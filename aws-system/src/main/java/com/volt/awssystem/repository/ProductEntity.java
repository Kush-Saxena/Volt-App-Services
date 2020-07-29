package com.volt.awssystem.repository;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "id", insertable = false, updatable = false, nullable = false)
	private UUID productId;

	@Column(name = "name", nullable = false)
	private String productName;

	@Column(nullable = false)
	private float price;

	@Column(nullable = false)
	private boolean isOn;

	@JsonBackReference
	@ManyToOne(optional = false)
	private ShopEntity inShop;

	// Getter Setters
	public UUID getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public ShopEntity getInShop() {
		return inShop;
	}

	public void setInShop(ShopEntity inShop) {
		this.inShop = inShop;
	}

	// Constructors
	public ProductEntity(String productName, float price, ShopEntity inShop) {
		super();
		this.productName = productName;
		this.price = price;
		this.inShop = inShop;
		this.isOn = true;
	}

	protected ProductEntity() {
		super();
	}

}
