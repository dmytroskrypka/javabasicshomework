package _Interfaces_2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		Human[] list = {
				new Human(null, 40, null), new Human(null, 20, null), new Human(null, 3, null),
				new Human(null, 7, null)
		};
		Arrays.sort(list, new HumanComparator(-1));
		for(Human h :list)
			System.out.println(h.getAge());
	}
}
