package encryption;

import java.util.Base64;
import java.util.Scanner;

import static encryption.Ask.enterCrypt;
import static encryption.Ask.message;
import static encryption.Crypt.decrypt;
import static encryption.Crypt.encrypt;

/**
 * author Igor
 */
public class Main {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        new Main().start();
    }

    private void start() throws Exception {

        hello();
        selectChoice();
    }

    private void hello() {

        System.out.println("              Crypto Chat          ");
        System.out.println(1 + " " + "crypt");
        System.out.println(2 + " " + "decrypt");
        System.out.println(3 + " " + "send to email");
        System.out.println(4 + " " + "exit");
    }

    private void selectChoice() throws Exception {

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                byte[] linux = encrypt(message());
                String arch = Base64.getEncoder().encodeToString(linux);
                System.out.println("Take ur encrypt message");
                System.out.println(arch);
                start();
                break;
            case 2:
                byte[] decryptArch = decrypt(enterCrypt());
                String dec = new String(decryptArch, "UTF-8");
                System.out.println("Take ur decrypt message");
                System.out.println(dec);
                start();
                break;
            case 3:
                //TODO create method to send email
                break;
            case 4:
                break;
            default:
                System.out.println("wrong choice try again");
                start();
                break;
        }
    }
}
