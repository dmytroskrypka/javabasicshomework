package _Object_override;

class Human implements Cloneable {
	private int age;
	private String name;
	
public Human (int age) {
	this.age = age;
}

public int getAge() {
	return age;
}

public String getName() {
	return name;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	//return "Human [age=" + age + ", name=" + name + "]";
	return name + ", " + age + " years old";
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
	return true;
}


public Human clone(){
    try {
        return (Human)super.clone();
      } catch (CloneNotSupportedException e) {
        System.out.println("Cloning not allowed.");
        return this;
      }
    }
	

}


