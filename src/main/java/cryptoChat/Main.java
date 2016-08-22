package cryptoChat;
import java.math.BigInteger;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static String encryptedText;
    public static String decryptedText;
    public static BigInteger publicKeyModulus;
    static String publicKeys1;
    static String textToDecrypt;
    static String privateKeyString;

    public static void main(String[] args) throws Exception {

        new Main().start();

    }

    private void start() {

        hello();
        selectChoice();
    }

    private static void hello() {
        System.out.println("              Crypto Chat          ");
        System.out.println(1 + " " + "crypt");
        System.out.println(2 + " " + "decrypt");
        System.out.println(3 + " " + "send to email");
        System.out.println(4 + " " + "Open key generator");
        System.out.println(5 + " " + "exit");
    }

    private void selectChoice()  {

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Введите текст для шифровки");
                encryptedText = scanner.next();
                System.out.println("Введите публичный ключ");
                publicKeys1 = scanner.next();
                publicKeys1.replaceAll("[\\s]{2,}", " ");
                try {
                    System.out.println("encrypted  = " + Encrypt.EncryptText());
                } catch (Exception e) {
                    System.out.println("something went wrong please try again");
                    start();
                }
                start();
                break;
            case 2:
                System.out.println("Введите текст");
                textToDecrypt = scanner.next();
                System.out.println("Введите приватный ключ");
                privateKeyString = scanner.next();
                privateKeyString.replaceAll("[\\s]{2,}", " ");
                try {
                    System.out.println("decrypted  = " + Decrypt.Decrypt());
                } catch (Exception e) {
                    System.out.println("something went wrong please try again");
                    start();
                }
                start();
            case 3:
                //
                start();
                break;
            case 4:
                try {
                    KeyGen.keyGen();
                } catch (Exception e) {
                    System.out.println("something went wrong please try again");
                    start();
                }
                start();
                break;
            case 5:
                break;
            default:
                System.out.println("wrong choice please try again");
                start();
                break;
        }
    }
}