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
public class Crypt {

    public static void main(String[] args) {

        try {
            byte[] b1 = decrypt("JutBa0GLHzGrlygxwWr66cizw4W4za+DbzZweNM0iloCD7xEP9LclL013lcksJL5XhjW44\nU+oxpqcX1ZSLhWuA==");
            String s1 = new String(b1, "UTF-8");
            System.out.println(s1);
            byte[] b2 = encrypt("Java".getBytes("UTF-8"));
            String s2 = Base64.getEncoder().encodeToString(b2);
            System.out.println(s2);
            byte[] b3 = decrypt(s2);
            String s3 = new String(b3, "UTF-8");
            System.out.println(s3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] decrypt(String key) throws Exception {

        BigInteger modulus = new BigInteger(
                "BA9B1DE44B0B239DCA40B94832EA238F40AD81981B59AA687F7F1A75A319ABD9334D9FA2CE25736C3AB4272171404DB49BC6A8AC210B92449F1DD1628497DAE7",
                16);
        BigInteger exp = new BigInteger(
                "00a9fa3beb45143b7832d06c35c0f3183b180e341b0ae6cd5becaf29b9f83c9d1466811e6f09af1f5a2e29a52e69c25cb224242b34c795ebb892b6065063b59841",
                16);

        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(modulus, exp);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privKey = kf.generatePrivate(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privKey);

        byte[] decodedStr = Base64.getDecoder().decode(
                key.replace("\n", "").replace("\r", "").replace(" ", ""));

        return cipher.doFinal(decodedStr);
    }

    private static byte[] encrypt(byte[] b1) throws Exception {
        BigInteger modulus = new BigInteger(
                "BA9B1DE44B0B239DCA40B94832EA238F40AD81981B59AA687F7F1A75A319ABD9334D9FA2CE25736C3AB4272171404DB49BC6A8AC210B92449F1DD1628497DAE7",
                16);
        BigInteger pubExp = new BigInteger("010001", 16);

        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, pubExp);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey = kf.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // byte[] decodedStr = Base64.decode(key, Base64.DEFAULT);

        return cipher.doFinal(b1);
    }
}
