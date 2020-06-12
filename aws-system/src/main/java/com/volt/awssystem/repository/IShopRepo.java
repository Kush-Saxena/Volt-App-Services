package com.volt.awssystem.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopRepo extends JpaRepository<ShopEntity, UUID> {

	@Query(value = "select * from shop_entity s where s.name LIKE %:keyword%", nativeQuery = true)
	List<ShopEntity> findByShopName(@Param("keyword") String name);

}
