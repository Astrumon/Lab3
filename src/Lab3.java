import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a);
        Scanner scanner1 = new Scanner(System.in);
        String text = scanner1.nextLine();
        System.out.println(text);
        scanner1.close();
        scanner.close();*/


        File file = new File("C:\\QuickAccess\\Test\\test.txt");

      /*  try {
            file.createNewFile();
        } catch (IOException exc) {
            System.out.println(exc);
        } */

        Date date = new Date(file.lastModified());
        System.out.println("Последняя модификация: " + date);
        System.out.println("Hi");




    }
}
