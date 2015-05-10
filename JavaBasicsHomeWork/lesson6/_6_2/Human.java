package _6_2;

import java.io.Serializable;

class Human implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	private Sex sex;
	private String name;
	
	private enum Sex {
		MALE, FEMALE;
	}
	
	public Human (String name, int age, Sex sex) {
		this.name = name;
		this.age = age;
		this.sex=sex;
	}
	public int getAge() {
		return age;
	}
	/**
	 * @return the sex
	 */
	public Sex getSex() {
		return sex;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name +", " + age +" y.o, " +sex;
	}
	
	

}
