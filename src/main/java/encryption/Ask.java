package encryption;

import java.util.Scanner;

/**
 * author Igor
 */
class Ask {

    private static Scanner scanner = new Scanner(System.in);

    static String modulus() {

        System.out.println("Enter ur modulus");
        return scanner.nextLine().toUpperCase();
    }

    static byte[] message() {

        System.out.println("Enter ur message");
        return scanner.nextLine().getBytes();
    }

    static String exp() {

        System.out.println("enter ur exp");
        return scanner.nextLine();
    }

    static String enterCrypt() {

        System.out.println("enter ur crypt message");

        return scanner.nextLine();
    }
}
