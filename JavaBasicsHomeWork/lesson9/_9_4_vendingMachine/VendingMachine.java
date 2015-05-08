package _9_4_vendingMachine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	
	private Map<Product, Integer> menu; //Product, Quantity
	private String statusfile;
	private Product lastorder;
	private Scanner scanner = new Scanner(System.in);	

	public VendingMachine() {
		this.menu = new HashMap<Product, Integer>();	
		this.setupNewMachine();
		this.lastorder= null;
		this.statusfile = null;
	}

	public VendingMachine(String statusfile) {
		
		this.menu = new HashMap<Product, Integer>();	
		this.statusfile = statusfile;
		
		File f = new File(statusfile);
		if(f.exists() && !f.isDirectory() && f.length() != 0){
			this.setupFromFile(statusfile);
		} else {
			this.setupNewMachine();
		}
		
		lastorder= null;
	}

private void setupNewMachine() {
		System.out.println("Setting new machine...");
		int price;
		int quantity;
		for(Drink d: Drink.values()){
			System.out.println("Set price for "+ d.toString());
			price = this.scanner.nextInt();
			System.out.println("Set quantity for "+ d.toString());
			quantity = this.scanner.nextInt();
			menu.put(new Product(d, price), quantity);
		}
	}

@SuppressWarnings("unchecked")
private void setupFromFile(String statusfile) {
	ObjectInputStream ois = null;
	try {
		ois= new ObjectInputStream(new FileInputStream(statusfile));
		this.menu.putAll((HashMap<Product, Integer>) ois.readObject());
		
	}catch (ClassNotFoundException ex) {
		System.out.println("wrong class in the file");
	}catch (FileNotFoundException ex){
		System.out.println("file not found");
	}catch (Exception ex){	
	} finally {
	            if (ois != null) {
	                try {
	                	ois.close();
	                } catch (Exception e) {}
	            }
	        }
	}

public void saveToFile(String statusfile){
	ObjectOutputStream oos = null;
	try {
		oos= new ObjectOutputStream(new FileOutputStream(statusfile));
				oos.writeObject(menu);
	}catch (IOException ex) {
	} finally {
	            if (oos != null) {
	                try {
	                	//oos.flush();
	                	oos.close();
	                } catch (Exception e) {}
	            }
	        }
}

/**
	 * @return the scanner
	 */
	public Scanner getScanner() {
		return scanner;
	}
	
public String getStatusfile() {
	return statusfile;
}

public void setStatusfile(String statusfile) {
	this.statusfile = statusfile;
}

public Map<Product, Integer> getMenu() {
	return menu;
}

public Product getMenuItem(Drink drink) {
		for(Product p: menu.keySet()){
			if(p.getDrink()==drink) {
				return p;
			} 
		}
		//add throw exception here
		return null;
}

public int getProductQuantity(Drink drink) {
	return getMenu().get(getMenuItem(drink));
}

public void addProductQuantity(Drink drink, int quantity) {
	Integer newQuantity = getProductQuantity(drink)+quantity;
	getMenu().put(getMenuItem(drink), newQuantity);
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

public void sellProduct(Product product){
	product.sellDrink();
	Integer newQuantity = getMenu().get(product)-1;
	this.menu.put(product, newQuantity);
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

		order = new Order(this.getMenuItem(Drink.valueOf(drinkName.toUpperCase())).clone()); //testing clone
		order.getProduct();
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
			this.sellProduct(order.getProduct());
		} else {
			System.out.println("Not enough coins! Order cancelled");
			System.out.println("Your change is " + payment);
		}
	} 
}

public int getPrice(Drink drink, int price) { //add exception for non existing drink?
	return getMenuItem(drink).getPrice();
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Wending Machine Menu: ");
	sb.append(System.getProperty("line.separator"));
	
	for(Product p: this.menu.keySet()){
		sb.append(this.menu.get(p)>0?
				"We have "+this.menu.get(p)+" "+p.getDrink()+" drinks for a price of $"+p.getPrice():
				"We don't have any"+p.getDrink()+" left"
				);
		
		sb.append(System.getProperty("line.separator"));
	} 

	return sb.toString();
}	
	
}
