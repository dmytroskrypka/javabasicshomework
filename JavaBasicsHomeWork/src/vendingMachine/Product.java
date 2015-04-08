package vendingMachine;

public class Product implements Cloneable {
	private Drink drink;
	private int price;
	private int quantity; //move this out from this class and use HashMap in WendingMachine class
		
	public Product(Drink drink, int price, int quantity) {
		this.drink = drink;
		this.price = price;		
		this.quantity = quantity;
	}

	/**
	 * @return the drink
	 */
	public Drink getDrink() {
		return drink;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public void sellDrink() {
		System.out.println("Please take your " +this.drink+ "!");
		this.quantity--;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return quantity>0?"We have "+quantity+" "+drink + " drinks for a price of $" + price: "We don't have any "+drink+" left";
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
