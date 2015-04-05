package _HW_PersonClass;

public abstract class Developer extends Person{


	protected double basicSalary;
	protected int experience;
	
	public Developer(String name, double basicSalary, int experience) {
		this.name = name;
		this.job = "Developer";
		this.basicSalary = basicSalary;
		this.experience = experience;
	}
	

	
	public double getBasicSalary() {
		return basicSalary;
	}
	
	public abstract double getSalary();
}
