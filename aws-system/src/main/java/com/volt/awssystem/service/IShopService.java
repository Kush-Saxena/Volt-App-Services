package com.volt.awssystem.service;

import java.util.List;
import java.util.UUID;

import com.volt.awssystem.jsonconsumer.ConsumerProductData;
import com.volt.awssystem.jsonconsumer.ConsumerShopData;
import com.volt.awssystem.repository.ShopEntity;

public interface IShopService {

	public List<ShopEntity> getAllShops();

	public List<ShopEntity> getShopByName(String name);

	public UUID addShop(ConsumerShopData shopData);

	public boolean addProduct(ConsumerProductData productData);

}
