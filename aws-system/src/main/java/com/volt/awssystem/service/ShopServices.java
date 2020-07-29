package com.volt.awssystem.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volt.awssystem.jsonconsumer.ConsumerProductData;
import com.volt.awssystem.jsonconsumer.ConsumerShopData;
import com.volt.awssystem.repository.IShopRepo;
import com.volt.awssystem.repository.ProductEntity;
import com.volt.awssystem.repository.ShopEntity;

@Service
public class ShopServices implements IShopService {

	@Autowired
	IShopRepo shoprepo;

	@Override
	public List<ShopEntity> getAllShops() {
		// TODO Auto-generated method stub

		return shoprepo.findAll();
	}

	@Override
	public UUID addShop(ConsumerShopData shopData) {

		// ADD A DATA VALIDATOR HERE
		// System.out.println(shopData);

		// Add a checker which handles unique constrain exception that same shop name
		// does not exist:
		// same name+area+city

		ShopEntity tempShop = new ShopEntity(shopData);

		ShopEntity updatedE = shoprepo.saveAndFlush(tempShop);

		return updatedE.getShopId();
	}

	@Override
	public List<ShopEntity> getShopByName(String name) {

		return shoprepo.findByShopNameContaining(name);
	}

	@Override
	public boolean addProduct(ConsumerProductData productData) {

		UUID shopid = productData.getShopid();

		if (shoprepo.existsById(shopid)) {
			ShopEntity fetchedShop = shoprepo.getOne(shopid);
			fetchedShop.addProduct(productData.getName(), productData.getPrice());
			shoprepo.saveAndFlush(fetchedShop);
			return true;
		}
		return false;
	}

	@Override
	public List<ProductEntity> getShopProducts(UUID shopId) {

		ShopEntity shop = shoprepo.findById(shopId).get();
		return shop.getProducts();

	}

}
