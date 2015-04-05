package generics.convert.array.to.list;


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
		
		MyLinkedList<Integer> il = new MyLinkedList<Integer>();
		MyLinkedList<String> sl = new MyLinkedList<String>();
		
		il.setListFromArray(ia);
		sl.setListFromArray(sa);
		
		System.out.println(il.toString());
		System.out.println(sl.toString());
	}
}
