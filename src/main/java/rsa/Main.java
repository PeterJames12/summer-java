package rsa;

import java.util.Scanner;

/**
 * author Igor
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int counter;
    private static String sms;
    private static String key;
    private static String message;

    public static void main(String[] args) {

        hello();
        selectChoice();
        someMethod();
        System.out.println(sms);
        scanner.close();
    }

    private static void hello() {

        System.out.println("              Crypto Chat          ");
        System.out.println(1 + " " + "crypt");
        System.out.println(2 + " " + "decrypt");
    }

    private static void selectChoice() {

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                crypt();
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println("wrong choice try again");
                counter++;
                if (counter < 3) {
                    selectChoice();
                }
                break;
        }
    }

    private static void crypt() {
        System.out.println("enter you public key");
        key = scanner.next();

    }

    private static String someMethod() {
        System.out.println("enter you message");
        message = scanner.next();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(key)
                .append(" ")
                .append(message);
        return sms = stringBuilder.toString();
    }
}
