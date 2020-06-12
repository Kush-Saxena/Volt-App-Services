package com.volt.awssystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volt.awssystem.repository.IProductRepo;
import com.volt.awssystem.repository.ProductEntity;

@Service
public class ProductService implements IProductService {

	@Autowired
	IProductRepo prodrepo;

	@Override
	public List<ProductEntity> getAllProducts() {

		return prodrepo.findAll();
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {

		return prodrepo.findByProductNameContaining(name);
	}

	@Override
	public List<ProductEntity> getProductByName2(String name) {
		
		//List<ProductEntity> lists= prodrepo.findByProductNameContainingGroupByInShop(name);
//		for(ProductEntity p : lists) {
//			System.out.println(p);
//		}
		return null;
	}

}
