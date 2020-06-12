package com.volt.awssystem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volt.awssystem.repository.AddressEntity;
import com.volt.awssystem.repository.IShopRepo;
import com.volt.awssystem.repository.ShopEntity;

@Service
public class ShopServices implements IShopService {

	@Autowired
	IShopRepo repo;

	@Override
	public List<ShopEntity> getAllShops() {
		// TODO Auto-generated method stub

		return repo.findAll();
	}

	@Override
	public UUID addShop(String shopName, String[] addressDetails, String mainCategories, LocalDateTime openingTime,
			LocalDateTime openHours, LocalDateTime deliveryTime) {

		AddressEntity shopAddress = new AddressEntity(addressDetails[0], addressDetails[1], addressDetails[2],
				addressDetails[3], addressDetails[4], addressDetails[5]);

		ShopEntity tempShop = new ShopEntity(shopName, shopAddress, mainCategories, openingTime, openHours,
				deliveryTime);

		ShopEntity updatedE = repo.saveAndFlush(tempShop);

		return updatedE.getShopId();
	}
	
	
	@Override
	public List<ShopEntity> getShopByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByShopName(name);
	}

	@Override
	public UUID addProduct(UUID shopId, String prodName,float price) {
		ShopEntity result = repo.findByShopName("Pinta").get(0);
		result.addProduct(prodName, price);
		ShopEntity updated = repo.save(result);
		return updated.getShopId();
	}
	

}
