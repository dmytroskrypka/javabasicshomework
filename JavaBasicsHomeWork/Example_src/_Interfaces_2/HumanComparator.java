package _Interfaces_2;

import java.util.Comparator;

class HumanComparator implements Comparator<Human> {

	protected int order;
	
public HumanComparator(int order) {
	this.order = order;
}

@Override
public int compare(Human o1, Human o2) {
		Human h1 =(Human) o1;
		Human h2 =(Human) o2;
		if(h1.getAge()<h2.getAge())
			return -1*order;
		else if(h1.getAge()==h2.getAge())
			return 0;
		else if(h1.getAge()>h2.getAge())
			return 1*order;
		return 0;// makecompilerhappy
	}
}
