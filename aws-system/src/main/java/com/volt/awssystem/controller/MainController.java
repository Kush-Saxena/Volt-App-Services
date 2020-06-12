package com.volt.awssystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volt.awssystem.repository.ShopEntity;
import com.volt.awssystem.service.IShopService;


//Fix closing time issue.
//Fix addingProducts issue.


@RestController
public class MainController {

	@Autowired
	private IShopService service;

	@Autowired
	private ObjectMapper ObjectParser;

	@GetMapping("/shops")
	public String testFunction() {

//		String[] Address1 = { "10", "tajganj", "farzi mahulla", "1001001", "up", "agra" };
//		String[] Address2 = { "22", "shiv colony", "modern mahulla", "101201", "haryana", "gurugram" };
//		String[] Address3 = { "31", "calton", "linepaar mahulla", "244001", "up", "moradabad" };
//		LocalDateTime td = LocalDateTime.now();
//
//		service.addShop("PintaShop", Address1, "food,health", td, td, td);
//		Thread.sleep(1000);
//		service.addShop("GaurShop", Address2, "food,health", td, td, td);
//		Thread.sleep(1000);
//		service.addShop("AviralShop", Address3, "food,health", td, td, td);

		List<ShopEntity> allshops = service.getAllShops();
		String allShopsJson = "Nothing";
		try {
			allShopsJson = ObjectParser.writeValueAsString(allshops);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

//		System.out.println("Addming products: ");
//		service.addProduct(new UUID(4, 3), "farzi product", 100.0f);
//		service.addProduct(new UUID(4, 3), "random things", 55.23f);

		return allShopsJson;
		// return allShopsJson;

	}

	@GetMapping("/shops/{pattern}")
	public String getShopByName(@PathVariable(name = "pattern") String pattern) {

		List<ShopEntity> matchShop = service.getShopByName(pattern);
		String matchedShopJson = "Nothing";
		try {
			matchedShopJson = ObjectParser.writeValueAsString(matchShop);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}

		return matchedShopJson;
	}

}
