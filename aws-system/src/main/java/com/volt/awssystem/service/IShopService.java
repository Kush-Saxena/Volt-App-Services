package com.volt.awssystem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.volt.awssystem.repository.ShopEntity;

public interface IShopService {

	public List<ShopEntity> getAllShops();

	public UUID addShop(String shopName, String[] addressDetails, String mainCategories, LocalDateTime openingTime,
			LocalDateTime openHours, LocalDateTime deliveryTimea);

	public List<ShopEntity> getShopByName(String name);

	public UUID addProduct(UUID shopId, String prodName, float price);

}
