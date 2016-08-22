package cryptoChat;

import javax.crypto.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;


class Encrypt {

    private static String textEc = Main.encryptedText;

    static String EncryptText() throws Exception {

        Cipher cipher = Cipher.getInstance("RSA");
        PublicKey key = KeyToString.StringPubKey();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(textEc.getBytes());
        return new String(Base64.getEncoder().encode(encryptedBytes));
    }
}