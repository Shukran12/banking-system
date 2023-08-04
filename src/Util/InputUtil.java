package Util;

import java.util.Scanner;

public class InputUtil {
    public static String inputString(String title){
        System.out.print(title);
        Scanner sc  = new Scanner(System.in);
        return sc.nextLine();
    }

    public static byte inputByte(String title){
        System.out.print(title);
        Scanner sc = new Scanner(System.in);
        return sc.nextByte();
    }

    public static int inputInt(String title){
        System.out.print(title);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
