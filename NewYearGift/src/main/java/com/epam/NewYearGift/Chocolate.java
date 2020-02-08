package com.epam.NewYearGift;
public class Chocolate {
	private int price, weight;
	String name;
	Chocolate(){
		price=0;
		weight=0;
		name="";
	}
	Chocolate(int weight, int price){
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
