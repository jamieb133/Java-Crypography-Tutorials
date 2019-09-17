import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import java.security.Key;
import java.security.SecureRandom;

public class KeyGeneratorExample
{
    public static void main(String args[]) throws Exception
    {
        //create key generator 
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecureRandom secRandom = new SecureRandom();
        keyGen.init(secRandom);

        Key key = keyGen.generateKey();
        System.out.println(key);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(cipher.ENCRYPT_MODE, key);

        String msg = new String("Hi how are you?");
        byte[] bytes = cipher.doFinal(msg.getBytes());

        System.out.println("Original msg is: " + msg);
        System.out.println("Encrypted msg is: " + bytes);





    }
    
}

