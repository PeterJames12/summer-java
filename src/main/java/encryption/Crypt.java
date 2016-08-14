package encryption;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

/**
 * author Igor
 */
class Crypt {

    static byte[] decrypt(String key) throws Exception {

        BigInteger modulus = new BigInteger(Ask.modulus(), 16);

        BigInteger exp = new BigInteger(Ask.exp(), 16);

        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(modulus, exp);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = kf.generatePrivate(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decodedStr = Base64.getDecoder().decode(key);

        return cipher.doFinal(decodedStr);
    }

    static byte[] encrypt(byte[] b1) throws Exception {

        BigInteger modulus = new BigInteger(Ask.modulus(), 16);
        BigInteger pubExp = new BigInteger("010001", 16);

        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, pubExp);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey = kf.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(b1);
    }
}
