import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.Cipher;

public class CipherDecrypt
{
    public static void main(String args[]) throws Exception
    {
        //create signature
        Signature sign = Signature.getInstance("SHA256withRSA");

        //create key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();

        //get public key from pair
        PublicKey publicKey = pair.getPublic();

        //create cipher
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        //add data to cipher
        byte[] input = "hellllooooooo".getBytes();
        cipher.update(input);

        //encrypt data
        byte[] cipherText = cipher.doFinal(); //does the encryption
        System.out.println("Encrypted msg: " + new String(cipherText, "UTF8"));

        //init cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        //decrypt the cipher text
        byte[] decipheredText = cipher.doFinal(cipherText);
        System.out.println("Decrypted msg: " + new String(decipheredText));
    }
}
