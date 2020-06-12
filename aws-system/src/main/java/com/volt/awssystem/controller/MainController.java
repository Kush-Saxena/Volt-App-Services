package com.volt.awssystem.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volt.awssystem.jsonconsumer.ConsumerProductData;
import com.volt.awssystem.jsonconsumer.ConsumerShopData;
import com.volt.awssystem.repository.ProductEntity;
import com.volt.awssystem.repository.ShopEntity;
import com.volt.awssystem.service.IProductService;
import com.volt.awssystem.service.IShopService;

//Fix closing time issue.
//Fix addingProducts issue.

@RestController
public class MainController {

	@Autowired
	private IProductService prodservice;

	@Autowired
	private IShopService shopservice;

	@Autowired
	private ObjectMapper ObjectParser;

	public String testFunction() {

		return null;
	}

	@GetMapping("/shops")
	public String getAllShops() {

		List<ShopEntity> allshops = shopservice.getAllShops();
		String allShopsJson = "Nothing";
		try {
			allShopsJson = ObjectParser.writeValueAsString(allshops);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

		return allShopsJson;

	}

	@GetMapping("/shops/{pattern}")
	public String getShopByName(@PathVariable(name = "pattern") String pattern) {

		List<ShopEntity> matchShop = shopservice.getShopByName(pattern);
		String matchedShopJson = "Nothing";
		try {
			matchedShopJson = ObjectParser.writeValueAsString(matchShop);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}

		return matchedShopJson;
	}

	@PostMapping(value = "/shops", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addShop(@RequestBody ConsumerShopData shopData) {

		UUID result = shopservice.addShop(shopData);

		return ("Added shop with id: " + result);
	}

	@PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addProduct(@RequestBody ConsumerProductData productData) {

		shopservice.addProduct(productData);

		return "this done";
	}

	@GetMapping(value = "/products")
	public String getAllProducts() {
		String productsJson = "Nothing";
		List<ProductEntity> allProducts = prodservice.getAllProducts();
		for (ProductEntity p : allProducts) {
			System.out.println(p.getInShop().getShopName());
		}
		try {
			productsJson = ObjectParser.writeValueAsString(allProducts);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}

		return productsJson;
	}

	@GetMapping(value = "/products/{value}")
	public String getMatchedProducts(@PathVariable(value = "value") String productName) {
		List<ProductEntity> matchedProducts = prodservice.getProductByName(productName);

		String jsonProducts = "Nothing";
		for (ProductEntity p : matchedProducts) {
			System.out.println(p.getInShop().getShopName());
		}
		try {
			jsonProducts = ObjectParser.writeValueAsString(matchedProducts);
			// prodservice.getProductByName2(productName);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return jsonProducts;

	}

}
