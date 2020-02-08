package com.epam.NewYearGift;
import java.util.*;

public class App {
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Chocolate> chocolates=new ArrayList<Chocolate>();
	static ArrayList<Chocolate> candies=new ArrayList<Chocolate>();
	static ArrayList<Sweet> sweets=new ArrayList<Sweet>();
	static HashMap<String,Integer> nameToWeight = new HashMap<String,Integer>();
	static HashMap<String,Integer> nameToPrice = new HashMap<String,Integer>();
	public static void main(String[] args) {
		inputChocolates();
		inputSweets();
		System.out.println("Total weight: "+calcTotalWeight());
		System.out.println("Choose sort way: 1.By Price  2.By weight");
		int sortType = sc.nextInt();
		if(sortType==1) {
			Comparator<Chocolate> compareByPrice = (Chocolate c1, Chocolate c2)->((Integer) c1.getPrice()).compareTo(c2.getPrice());
			Collections.sort(chocolates,compareByPrice);
		} else if(sortType==2) {
			Comparator<Chocolate> compareByWeight = (Chocolate c1, Chocolate c2)->((Integer) c1.getWeight()).compareTo(c2.getWeight());
			Collections.sort(chocolates,compareByWeight);
		}
		System.out.println("Sorted Result:");
		for(Chocolate c:chocolates) {
			System.out.println(c.getPrice());
		}
		calcRange(sortType);
	}
	public static void inputChocolates() {
		System.out.println("Enter no of choclates");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Enter Choc type 1.Candy 2.Wafer");
			int type=sc.nextInt();
			System.out.println("Enter weight of choc");
			int weight=sc.nextInt();
			System.out.println("Enter price of choc");
			int price=sc.nextInt();
			if(type==1) {
				System.out.println("Enter name of candy");
				String candyName=sc.next();
				if(nameToWeight.containsKey(candyName)) {
					nameToWeight.put(candyName, (int)nameToWeight.get(candyName)+weight);
				} else {
					nameToWeight.put(candyName, weight);
				}
				
				if(nameToPrice.containsKey(candyName)) {
					nameToPrice.put(candyName, (int)nameToPrice.get(candyName)+price);
				} else {
					nameToPrice.put(candyName, price);
				}
			}
			Chocolate choco = new Chocolate(price,weight);
			chocolates.add(choco);
			if(type==1) {
				candies.add(choco);
			}			
		}
	}
	
	public static void inputSweets() {
		System.out.println("Enter no of sweets in gifts");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Enter weight of sweet");
			int weight=sc.nextInt();
			System.out.println("Enter price of sweet");
			int price=sc.nextInt();
			Sweet sweet=new Sweet(weight,price);
			sweets.add(sweet);
		}
	}
	
	public static int calcTotalWeight() {
		int totalweight = 0;
		for(Chocolate c: chocolates) {
			totalweight+=c.getWeight();
		}
		
		for(Sweet s: sweets) {
			totalweight+=s.getWeight();
		}
		return totalweight;
	}
	
	public static void calcRange(int sortType) {
		System.out.println("Lets find range");
		int lowerLimit,higherLimit;
		if(sortType==1) {
			System.out.println("Enter lowerLImit of price");
			lowerLimit = sc.nextInt();
			
			System.out.println("Enter higherLimit of price");
			higherLimit = sc.nextInt();
			Set<Map.Entry<String, Integer>> candySet = nameToPrice.entrySet();
			Iterator<Map.Entry<String, Integer>> candyIterator = candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry<String, Integer> candyElement = (Map.Entry<String, Integer>) candyIterator.next();
				int curPrice = (int) candyElement.getValue();
				if(curPrice>=lowerLimit && curPrice<=higherLimit) {
					System.out.println(candyElement.getKey());
				}
			}
		} 
		else {
			System.out.println("Enter lowerLimit of weight");
			lowerLimit = sc.nextInt();
			
			System.out.println("Enter higherLimit of weight");
			higherLimit = sc.nextInt();
			Set<Map.Entry<String, Integer>> candySet = nameToWeight.entrySet();
			Iterator<Map.Entry<String, Integer>> candyIterator = candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry<String, Integer> candyElement = (Map.Entry<String, Integer>) candyIterator.next();
				int curWeight = (int) candyElement.getValue();
				if(curWeight>=lowerLimit && curWeight<=higherLimit) {
					System.out.println(candyElement.getKey());
				}
			}
		}
	}
}