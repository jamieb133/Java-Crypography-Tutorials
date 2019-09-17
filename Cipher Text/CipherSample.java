import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

public class CipherSample
{
    public static void main(String args[]) throws Exception
    {
        //create signature
        Signature sign = Signature.getInstance("SHA256withRSA");

        //create key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();

        //create Cipher
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        //add data to cipher
        byte[] input = "hellllooooooooo".getBytes();
        cipher.update(input);

        //encrypt data
        byte[] cipherText = cipher.doFinal();
        System.out.println(new String(cipherText, "UTF8"));
    }
}