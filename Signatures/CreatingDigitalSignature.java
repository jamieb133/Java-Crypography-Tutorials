import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

public class CreatingDigitalSignature
{
    public static void main(String args[]) throws Exception
    {
        //accept text from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text");
        String msg = sc.nextLine();

        //generate key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();

        //get private key from pair
        PrivateKey privKey = pair.getPrivate();

        //create signature
        Signature sign = Signature.getInstance("SHA256withDSA");    
        
        sign.initSign(privKey);
        byte[] bytes = "msg".getBytes();

        //add data to signature
        sign.update(bytes);

        //calc signature
        byte[] signature = sign.sign();
        System.out.println("Signature for given text: " + new String(signature, "UTF8"));

    
    }
}