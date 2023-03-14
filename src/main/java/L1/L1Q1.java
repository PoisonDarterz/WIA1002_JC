package L1;

import java.util.Scanner;
import java.io.*;

public class L1Q1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //part 1
        try{
            Scanner in = new Scanner(new FileInputStream("src\\main\\java\\L1\\letter.txt"));
            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        //part 2
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream("src\\main\\java\\L1\\letter.txt"));
            pw.println("\n\nMonday, 31 August 2023\n");
            System.out.println("Enter letter: ");
            String letter = sc.nextLine();
            pw.println(letter);
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            System.out.println("\n\nContents of letter: \n\n");
            Scanner in = new Scanner(new FileInputStream("src\\main\\java\\L1\\letter.txt"));
            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}