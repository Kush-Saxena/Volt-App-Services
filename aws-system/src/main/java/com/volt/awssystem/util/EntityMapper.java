package com.volt.awssystem.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.volt.awssystem.jsonproducer.ProducerProductData;
import com.volt.awssystem.jsonproducer.ProducerShopData;
import com.volt.awssystem.repository.ProductEntity;
import com.volt.awssystem.repository.ShopEntity;

@Component
public class EntityMapper {

	public List<ProducerProductData> mapProducts(List<ProductEntity> products) {

		List<ProducerProductData> p = new ArrayList<>();
		products.forEach(prod -> {
			ProducerProductData temp = new ProducerProductData();
			temp.setName(prod.getProductName());
			temp.setShopId(prod.getInShop().getShopId());
			temp.setShopName(prod.getProductName());
			temp.setPrice(prod.getPrice());
			temp.setOn(prod.isOn());
			temp.setShopName(prod.getInShop().getShopName());
			p.add(temp);
		});

		return p;
	}

	public List<ProducerShopData> mapShops(List<ShopEntity> shops) {

		List<ProducerShopData> s = new ArrayList<ProducerShopData>();
		shops.forEach(shop -> {
			ProducerShopData temp = new ProducerShopData();
			temp.setShopId(shop.getShopId());
			temp.setShopName(shop.getShopName());
			temp.setAddress(shop.getAddress().toString());
			temp.setCategories(shop.getMainCategories());
			temp.setOpentime(shop.getOpeningTime());
			temp.setOpenhours(shop.getOpenHours());
			temp.setClosingTime(shop.getOpeningTime().plusHours(shop.getOpenHours()));
			temp.setDelivertime(shop.getDeliveryTime());
			temp.setRating(shop.getRating());
			temp.setOn(true);

			s.add(temp);

		});

		return s;

	}
}
