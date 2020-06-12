package com.volt.awssystem.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<ProductEntity, UUID> {

	List<ProductEntity> findByProductNameContaining(String productname);

	// List<ProductEntity> findByProductNameContainingGroupByInShop(String
	// productname);
}
