package cryptoChat;

import java.io.*;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

class KeyGen {

    static void keyGen() throws NoSuchAlgorithmException, IOException {
        Scanner scanner = new Scanner(System.in);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        String encodedPrivKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());

        String encodedPubKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        System.out.println("SAVE THIS SOMEWHERE" + "\n" + "\n");
        System.out.println("Public key : " + "\n" + encodedPubKey + "\n");
        System.out.println("Private key : " + "\n" + encodedPrivKey);
        System.out.println("DO YOU WANT TO SAVE THIS TO FILE?" + "\n" + "y/n");
        char i = scanner.next().charAt(0);
        if (i == 'Y' || i == 'y'){
            StringBuilder keys = new StringBuilder();
            keys.append("Public key : "  + encodedPubKey +" Private key : " + encodedPrivKey);
            String keyBuilder = keys.toString();
            System.out.println("Введите путь файла" + "\n" + "Пример : C:\\Test" );
            String path = scanner.next(); // + "\\keys.txt";
            File file = new File(path);
            if(!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fop = new FileOutputStream(file);
            byte[] contentInBytes = keyBuilder.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            System.out.println("Файл успешно создан");
        }else if (i == 'N' || i == 'n'){
            System.out.println("OK");
        }
        else {
            System.out.println("Неправильная буква");
        }
    }
}
