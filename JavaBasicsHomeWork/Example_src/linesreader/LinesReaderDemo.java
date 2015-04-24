package linesreader;

public class LinesReaderDemo {

    public static void main(String[] args) {
        reader.setEvents(new Events1());  //Events1
        callReadNTimes(3);

        System.out.println("--------------");
        reader.setEvents(new Events2());  //Events2
        callReadNTimes(2);
    }

    private static void callReadNTimes(int n) {
        System.out.printf("Enter %d lines:%n", n);
        while (n-- > 0) {
            reader.read();
        }

    }

    private static LinesReader reader = new LinesReader();
}
