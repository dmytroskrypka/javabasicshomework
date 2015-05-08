package _13_1_convert_array_to_list;

import java.util.Iterator;
import java.util.LinkedList;


public class MyLinkedList<T> extends LinkedList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setListFromArray(T[] array) {
		for(T element: array){
			this.add(element);
		}
	}
	
	public void printFirstElements(int howmany){
		Iterator<T> iterator = this.iterator();
		int counter = 0;
		while (iterator.hasNext() && counter++ < howmany){
			System.out.println(iterator.next());
		}
	}
	
}
