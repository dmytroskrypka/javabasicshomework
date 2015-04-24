package _HW_5_1_3;

public class MainClass {

	public static void main(String[] args) {

		SamsungS4 samsungs4_1 = new SamsungS4("067-111-123-45");
		SamsungS4 samsungs4_2 = new SamsungS4("067-222-123-45");
		SamsungS4 samsungs4_3 = new SamsungS4("067-333-123-45");		

	
		samsungs4_1.call("067-222-123-45");
		samsungs4_2.call("067-333-123-45");
		samsungs4_3.call("067-111-123-45");
		
	}
}
