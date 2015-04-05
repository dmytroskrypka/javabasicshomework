package wendingMachine;

public class Order {
	private Product product;
	private int payment;
	private boolean paid;
	
public Order(Product product, int payment) {
		this.product = product;
		this.payment = payment;
}


public Order(Product product) {
	super();
	this.product = product;
}


/**
 * @return the product
 */
public Product getProduct() {
	return product;
}

/**
 * @param product the product to set
 */
public void setProduct(Product product) {
	this.product = product;
}

/**
 * @return the payment
 */
public int getPayment() {
	return payment;
}

/**
 * @param payment the payment to set
 */
public void setPayment(int payment) {
	this.payment = payment;
}

/**
 * @return the paid
 */
public boolean isPaid() {
	return paid;
}

/**
 * @param paid the paid to set
 */
public void setPaid(boolean paid) {
	this.paid = paid;
}

/**
 * returns change to give if any
 * @param paid the paid to set
 */
public int collectPayment(int payment) {
	this.payment = payment;
	this.paid = (product.getPrice() <= this.payment );
	return this.payment - product.getPrice();
}
	


}
