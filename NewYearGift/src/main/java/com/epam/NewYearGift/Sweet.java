package com.epam.NewYearGift;

public class Sweet {
	private int weight,price;
	String name;
	Sweet(){
		weight=0;
		price=0;
		name="";
	}
	Sweet(int weight,int price){
		this.weight=weight;
		this.price=price;
	}
	int getPrice() {
		return price;
	}
	int getWeight() {
		return weight;
	}
}