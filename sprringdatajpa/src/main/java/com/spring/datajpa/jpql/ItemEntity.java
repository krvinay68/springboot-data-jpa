package com.spring.datajpa.jpql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Item")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String itemName;
	private String itemPrice;
	private String itemDescription;
	private String itemQuantity;

	public ItemEntity() {
	}

	public ItemEntity(String itemName, String itemPrice, String itemDescription, String itemQuantity) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.itemQuantity = itemQuantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "ItemEntity [id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemDescription="
				+ itemDescription + ", itemQuantity=" + itemQuantity + "]";
	}

}
