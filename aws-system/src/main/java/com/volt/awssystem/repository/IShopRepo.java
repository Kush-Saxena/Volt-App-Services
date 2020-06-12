package com.volt.awssystem.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopRepo extends JpaRepository<ShopEntity, UUID> {

	// Do not use native queries. Change to jpql.
	
	//Using default query builder.

	@Query(value = "select s.name FROM shop_entity s WHERE s.name = :name limit 1", nativeQuery = true)
	ShopEntity existsByName(String name);
	
	List<ShopEntity> findByShopNameContaining(String shopname);
	

}
