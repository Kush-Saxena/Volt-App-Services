package com.volt.awssystem.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.volt.awssystem.jsonproducer.ProducerProductData;
import com.volt.awssystem.jsonproducer.ProducerShopData;
import com.volt.awssystem.repository.ProductEntity;
import com.volt.awssystem.repository.ShopEntity;
import com.volt.awssystem.service.ProductService;
import com.volt.awssystem.service.ShopServices;
import com.volt.awssystem.util.EntityMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SecondController {

	@Autowired
	ProductService productService;

	@Autowired
	ShopServices shopService;

	@Autowired
	EntityMapper em;

	@GetMapping("/products")
	public List<ProducerProductData> allProducts() {

		List<ProductEntity> productsList = productService.getAllProducts();
		return em.mapProducts(productsList);

	}

	@GetMapping("/shops")
	public List<ProducerShopData> allShops() {

		List<ShopEntity> shopList = shopService.getAllShops();
		return em.mapShops(shopList);
	}

	@GetMapping("/shops/{Id}")
	public List<ProducerProductData> fetchProducts(@PathVariable String Id) {
		UUID shopId = UUID.fromString(Id);
		return em.mapProducts(shopService.getShopProducts(shopId));

	}
}
