package Interfaces_1;

class Human implements Comparable<Human> {
	private int age;
	public Human (int age) {this.age = age;}
	public int getAge() {return age;}

@Override

public int compareTo(Human another){
	Human h =(Human)another;
	if(age>h.age)
		return-1;
	else if(age==h.age)
		return 0;
	else if(age<h.age)
		return 1;
	else
		return 0;// makecompilerhappy
	}
}
