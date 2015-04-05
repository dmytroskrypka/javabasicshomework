package generics.convert.array.to.list;

import java.util.LinkedList;
import java.util.List;

public class ConverterDemo {

	public static void main(String[] args) {
		Integer[] ia = new Integer[3]; 
		ia[0]=1;
		ia[1]=2;
		ia[2]=3;
		
		String[] sa = new String[3]; 
		sa[0]="one";
		sa[1]="two";
		sa[2]="three";
		
		List<Integer> il = convertToList(ia);
		List<String> sl = convertToList(sa);
		
		System.out.println(il.toString());
		System.out.println(sl.toString());
	}
	
	public static <T> List<T> convertToList(T[] array) {
		 List<T> list = new LinkedList<T>();
		for(T element: array){
			list.add(element);
		}
		return list;
	}

}
