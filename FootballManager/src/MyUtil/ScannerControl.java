package MyUtil;

import java.util.Scanner;
/**  Class ScannerControl checks the correctness of information input:
 *  String, Integer numbers and Double numbers*/

public class ScannerControl {
    Scanner scanner=new Scanner(System.in);

    public String enterString(){
        String line;
        line=scanner.nextLine();
        return line;
    }

    public Double enterDouble(){
        Double price;
        while (!scanner.hasNextDouble()){
            System.out.println("Напишите число правильно (целая часть.дробная часть). ");
            scanner.next();
        }
        price=scanner.nextDouble();
        return price;
    }

    public Integer enterInteger(){
        Integer number;
        while (!scanner.hasNextInt()){
            System.out.println("Напишите число правильно. ");
            scanner.next();
        }
        number=scanner.nextInt();
        return number;
    }
}
