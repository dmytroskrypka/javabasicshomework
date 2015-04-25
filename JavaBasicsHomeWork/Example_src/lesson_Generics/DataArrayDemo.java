package lesson_Generics;

public class DataArrayDemo {

	public static void main(String[] args) {
		/*Integer[] ia = new Integer[3]; 
		ia[0]=1;
		ia[1]=2;
		ia[2]=3;*/
		
		DataArray<Integer> ida = new DataArray<Integer>(new Integer[3]);
		ida.getArray()[0] = 3;
		ida.getArray()[1] = 4;
		ida.getArray()[2] = 5;
		
		System.out.println(ida.getElement(2));
		
/*		String[] sa = new String[3]; 
		sa[0]="one";
		sa[1]="two";
		sa[2]="three";*/
		
		DataArray<String> sda = new DataArray<String>(new String[3]);
		sda.getArray()[0] = "three";
		sda.getArray()[1] = "four";
		sda.getArray()[2] = "five";
		System.out.println(sda.getElement(2));
		
	}

}
