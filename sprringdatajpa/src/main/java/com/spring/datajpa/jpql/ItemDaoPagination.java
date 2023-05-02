/**
 * THIS IS EXMAPLE OF PAGING AND SORTING IN JPA
 * 
 */

package com.spring.datajpa.jpql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.spring.datajpa.basic.ItemPaginationRespository;

@Component
public class ItemDaoPagination {

	@Autowired
	ItemPaginationRespository itemPaginationRespository;

	public void insertIlist() {

		List<ItemEntity> item = new ArrayList<>();
		item.add(new ItemEntity("LAPTOP", "20000", "DUALCORE", "20"));
		item.add(new ItemEntity("LAPTOP_1", "30000", "CORE", "21"));
		item.add(new ItemEntity("LAPTOP_2", "40000", "CORE", "22"));
		item.add(new ItemEntity("LAPTOP_3", "10000", "I3", "23"));
		item.add(new ItemEntity("LAPTOP_4", "70000", "I4", "29"));
		item.add(new ItemEntity("LAPTO_5", "80000", "I5", "30"));
		item.add(new ItemEntity("DESKTOP_1", "30000", "DUALCORE", "33"));
		item.add(new ItemEntity("DESKTOP_2", "10000", "CORE", "34"));
		item.add(new ItemEntity("DESKTOP_3", "90000", "DUALCORE", "66"));
		item.add(new ItemEntity("TABLET_1", "40000", "I2", "70"));
		item.add(new ItemEntity("TABLET_2", "30000", "DUALCORE", "80"));
		item.add(new ItemEntity("TABLET_3", "1000", "CORE", "70"));
		item.add(new ItemEntity("TABLET_4", "60000", "DUALCORE", "90"));
		item.add(new ItemEntity("IPOD", "110000", "CORE", "21"));

		itemPaginationRespository.saveAll(item);

	}

	public void findAllbyPaging() {
		PageRequest pageble = PageRequest.of(0, 2);
		Page<ItemEntity> itemEntity = itemPaginationRespository.findAll(pageble);
		itemEntity.forEach(li -> System.out.println(li.getItemName()));

	}

	public void findAllbyPagingSorting() {
		// Sort sort=Sort.by("itemName");
		// by default it ascending order
		// we can pass multiple parameter or column
		List<ItemEntity> itemEntity = itemPaginationRespository
				.findAll(Sort.by(Direction.DESC, "itemName", "itemPrice"));
		itemEntity.forEach(li -> System.out.println(li.getItemName()));

	}

	public void getByAgeInPagingAndSorting() {
		PageRequest pageble = PageRequest.of(0, 4);
		List<ItemEntity> list = itemPaginationRespository.findByItemQuantityIn(Arrays.asList("20", "70"), pageble);
		list.stream().forEach(li -> {
			System.out.println("+++++++--> " + li.getItemName());
		});
	}
}
