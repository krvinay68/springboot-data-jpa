package com.spring.datajpa.jpql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpqlRespositoryItementity extends JpaRepository<ItemEntity, Long> {

	@Query("from ItemEntity")
	List<ItemEntity> findAllItem();
	
	@Query("select it.itemName , it.itemPrice from ItemEntity it")
	List<Object[]> findAllItemPartialData();
	
	//name query parameters
	@Query("from ItemEntity where itemName=:itemName")
	List<ItemEntity> findAllItemByItemName(@Param("itemName") String itemName);
	
	//name query parameters
	@Query("from ItemEntity where itemPrice>:min and itemPrice<:max")
	List<ItemEntity> findAllItemByItemPrice(@Param("min") String min, @Param("max") String max );
	
	@Modifying
	@Query("delete from ItemEntity where itemPrice=:itemPrice")
    void deleteItemByItemPrice(@Param("itemPrice") String itemPrice);
	
	//SQL NATIVE QUERY EXAMPLE
	@Query(value="select * from Item", nativeQuery = true)
	List<ItemEntity> findAllItemNativequery();
	
	@Query(value="select * from Item where itemPrice=:itemPrice", nativeQuery = true)
	List<ItemEntity> findAllItemNativequery(@Param("itemPrice") String itemPrice);
}
