package Interfaces_1;

import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		Human[] list = {
				new Human(40), new Human(20), new Human(3),
				new Human(7)
		};
		Arrays.sort(list);
		for(Human h :list)
			System.out.println(h.getAge());
	}
}
