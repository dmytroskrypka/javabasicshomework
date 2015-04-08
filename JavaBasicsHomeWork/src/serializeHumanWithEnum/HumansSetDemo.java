package serializeHumanWithEnum;

public class HumansSetDemo {

	public static void main(String[] args) {
		SetOfHumans soh1 = new SetOfHumans("Set 1");
		soh1.addHuman(new Human("Dima", 34, Sex.MALE));
		soh1.addHuman(new Human("Dima", 34, Sex.MALE));
		soh1.addHuman(new Human("Dima", 33, Sex.MALE));
		soh1.addHuman(new Human("Nastia", 31, Sex.FEMALE));
		soh1.addHuman(new Human("Nastia", 30, Sex.FEMALE));
		soh1.addHuman(new Human("Andrey", 29, Sex.MALE));
		
		soh1.SaveToFile("humans.bin");
		soh1.WriteToTxtFile("humans.txt");
		//soh1.Show();
		
		SetOfHumans soh2 = new SetOfHumans("Set 2");
		soh2.GetFromFile("humans.bin");
		soh2.Show();
	}

}
