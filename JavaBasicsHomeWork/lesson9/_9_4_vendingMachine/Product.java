package _9_4_vendingMachine;

import java.io.Serializable;

public class Product implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Drink drink;
	private int price;
		
	public Product(Drink drink, int price) {
		this.drink = drink;
		this.price = price;		
	}

	/**
	 * @return the drink
	 */
	public Drink getDrink() {
		return drink;
	}

	public void sellDrink() {
		System.out.println("Please take your " +this.drink+ "!");
	}

	/**
	 * @param drink the drink to set
	 */
	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (drink != other.drink)
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	@Override	
public Product clone(){
   try {
       return (Product)super.clone();
     } catch (CloneNotSupportedException e) {
       System.out.println("Cloning not allowed.");
       return this;
     }
}	
	
}
