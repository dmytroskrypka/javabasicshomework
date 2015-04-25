package dynamicArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Available commands:
 * /no command/
 * exit
 * del <index>   e.g. del 0
 * add <value>   e.g. add 35
 * insert <index> <value>  e.g. insert 0 25
 * print
 * sort
 */
public class Demo {
    //....
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array size = ");
        int size = scanner.nextInt();
        scanner.nextLine();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            //                  format
            System.out.printf("A[%d] = ", i);
            array[i] = scanner.nextLine();
        }
        //scanner.nextLine();

        UserCommand cmd;
        while (!"".equals((cmd = obtainCommand(scanner)).getName())) {
            switch (cmd.getName()) {
                case "exit":
                    return;
                case "add":
                    String[] newArray = new String[array.length + 1];
                    System.arraycopy(array, 0, newArray, 0, array.length);
                    newArray[array.length] = cmd.getParam(0);
                    array = newArray;
                    break;
                case "del":
                    // 0 1 2
                    // 1 2 3 | array
                    //   ^   | delete this elem, e.g. 1
                    // 1 3   | newArray
                    newArray = new String[array.length - 1];
                    int idxToDel = Integer.valueOf(cmd.getParam(0));
                    System.arraycopy(array, 0, newArray, 0, idxToDel);
                    System.arraycopy(array, idxToDel + 1, newArray, idxToDel, array.length - idxToDel - 1);
                    array = newArray;
                    break;
                case "print":
                    System.out.println(Arrays.toString(array));
                    break;
                case "sort":
                    sort(array);
                    break;
                default:
                    System.out.println("Input mismatch, please try again");
            }
            //cmd, processing
        }
    }

    private static void sort(String[] array) {
        //...sorting...
    }

    private static UserCommand obtainCommand(Scanner sc) {
        System.out.println("Please enter the command you would like to execute");
        return new UserCommand(sc.nextLine().trim());
    }
}
