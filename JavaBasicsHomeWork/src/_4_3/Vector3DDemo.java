package _4_3;

public class Vector3DDemo {
	
		static Vector3D a = new Vector3D(2,4,5);
		static Vector3D b = new Vector3D(3,1,2);
		
	public static void main(String[] args) {


		System.out.println(a.toString());
		System.out.println(b.toString());
		
		System.out.print("Sumproduct. Testing dynamic method: ");
		System.out.println(a.SumProduct(b));
		
		System.out.print("Sumproduct. Testing static method: ");
		System.out.println(Vector3D.SumProduct(a, b));
		
		System.out.print("Crossproduct. Testing dynamic method: ");
		System.out.println(a.CrossProduct(b).toString());
		
		System.out.print("Crossproduct. Testing static method: ");
		System.out.println(Vector3D.CrossProduct(a, b).toString());
		
	}

}
