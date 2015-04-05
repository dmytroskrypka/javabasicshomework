package wendingMachine;

import java.util.Scanner;

public class WendingMachine {
	
	private static final Product[] MENU = new Product[4];
	private Product lastorder;
	private Scanner scanner = new Scanner(System.in);	

	public WendingMachine() {
		
		MENU[0] = new Product(Drink.COLA, 1, 0);
		MENU[1] = new Product(Drink.FANTA, 1, 0);
		MENU[2] = new Product(Drink.SPRITE, 1, 0);
		MENU[3] = new Product(Drink.WATER, 1, 0);
		
		lastorder= null;
	}

/**
	 * @return the scanner
	 */
	public Scanner getScanner() {
		return scanner;
	}

public Product getMENUItem(Drink drink) {
		for(Product d: MENU){
			if(d.getDrink()==drink) {
				return d;
			} 
		}
		return null; 
}

public void setPrice(Drink drink, int price) {
	getMENUItem(drink).setPrice(price);
}

public int getProductQuantity(Drink drink) {
	return getMENUItem(drink).getQuantity();
}

public void addProductQuantity(Drink drink, int quantity) {
	getMENUItem(drink).addQuantity(quantity);
}

public void addUserProductQuantity() {
	System.out.println("Chose drink to add cans to machine");
	this.scanner = new Scanner(System.in);
	String drinkName = this.scanner.nextLine();
	Drink d = Drink.valueOf(drinkName.toUpperCase());
	
	System.out.println("Enter quantity of " + d + " to add to machine");
	int quantity = this.scanner.nextInt();
	
	addProductQuantity(d, quantity);
}

public void setMENUQuantities() {
	for(Drink d: Drink.values()){
		System.out.println("Set quantity for " + d);
		int quantity = this.scanner.nextInt();
		addProductQuantity(d,quantity);
 	}
}

public void setMENUPrices() {
	for(Drink d: Drink.values()){
		System.out.println("Set price for " + d);
		int price = this.scanner.nextInt();
		getMENUItem(d).setPrice(price);
 	}
}

public Order selectOrder(){
	Order order;
	
	if(this.lastorder!=null){
		this.scanner = new Scanner(System.in);
		System.out.println("Repeat last order(y/n)?");
		if(this.scanner.nextLine().equalsIgnoreCase("Y")){
			if(this.getProductQuantity(this.lastorder.getDrink()) == 0){
				System.out.println("Sorry, we run out of "+ this.lastorder.getDrink());
				return null;
			}
			order = new Order(this.lastorder.clone());
			return order;
		} 
	}
		System.out.println("Select Drink");
		this.scanner = new Scanner(System.in);
		String drinkName = this.scanner.nextLine();
		if(this.getProductQuantity(Drink.valueOf(drinkName.toUpperCase())) == 0){
			System.out.println("Sorry, we run out of " + drinkName.toUpperCase());
			return null;
		}

		order = new Order(this.getMENUItem(Drink.valueOf(drinkName.toUpperCase())).clone()); //testing clone
		order.getProduct().setQuantity(1);
		return order;
}

public void payForOrder(Order order){
	if(order!=null){
		System.out.println("Insert coins (input amount)");
		this.scanner = new Scanner(System.in);
		int payment = this.scanner.nextInt();
		
		int change = order.collectPayment(payment);
		
		if(order.isPaid()){
			System.out.println("Your change is " + change);
			this.lastorder = order.getProduct();
			this.getMENUItem(order.getProduct().getDrink()).sellDrink();
		} else {
			System.out.println("Not enough coins! Order cancelled");
			System.out.println("Your change is " + payment);
		}
	} 
}

public int getPrice(Drink drink, int price) { //add exception for non existing drink?
	return getMENUItem(drink).getPrice();
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Wending Machine Menu: ");
	sb.append(System.getProperty("line.separator"));
	
	for(Product p: MENU){
		sb.append(p.toString());
		sb.append(System.getProperty("line.separator"));
	} 

	return sb.toString();
}	
	
}
