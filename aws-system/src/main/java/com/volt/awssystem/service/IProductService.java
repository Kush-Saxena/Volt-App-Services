package com.volt.awssystem.service;

import java.util.List;

import com.volt.awssystem.repository.ProductEntity;

public interface IProductService {

	public List<ProductEntity> getAllProducts();

	public List<ProductEntity> getProductByName(String name);

	public List<ProductEntity> getProductByName2(String name);
}
