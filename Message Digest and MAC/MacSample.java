import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

public class MacSample
{
    public static void main(String args[]) throws Exception
    {
        //create a KeyGenerator
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");

        //create a SecureRandom
        SecureRandom secRandom = new SecureRandom();

        //init KeyGenerator
        keyGen.init(secRandom);

        //create and generate keys
        Key key = keyGen.generateKey();
        Key key2 = keyGen.generateKey(); //use this to test if output string is the same (it isn't)

        //create and init mac object
        Mac mac1 = Mac.getInstance("HmacSHA256");
        Mac mac2 = Mac.getInstance("HmacSHA256");
        mac1.init(key);
        mac2.init(key);

        //compute mac
        String msg = new String("Hi how are you");
        byte[] bytes = msg.getBytes();
        byte[] macResult1 = mac1.doFinal(bytes);
        byte[] macResult2 = mac2.doFinal(bytes);
        String result1 = new String(macResult1);
        String result2 = new String(macResult2);

        System.out.println("Mac string results: ");
        System.out.println(result1);
        System.out.println(result2);

        System.out.println("Mac raw results: ");
        System.out.println(macResult1);
        System.out.println(macResult2);

        if (result1 == result2)
        {
            System.out.println("Hash is the same :)");
        }
        else
        {
            System.out.println("Hash is not the same :(");
        }



        
    }
}