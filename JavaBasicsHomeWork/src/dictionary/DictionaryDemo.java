package dictionary;

public class DictionaryDemo {

	public static void main(String[] args) {
		System.out.println(
				(new Dictionary("D:\\Java\\git\\javabasicshomework\\JavaBasicsHomeWork\\src\\dictionary\\dictionary.txt"))
				.translate("fish cat human test dog bird")
		);
	}

}
