import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;

public class SignatureVerfication
{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String args[]) throws Exception
    {
        //create key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();

        //get private key from pair
        PrivateKey privKey = pair.getPrivate();

        //create signature
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privKey);
        byte[] bytes = "well hi there ;)".getBytes();

        //add data to signature
        sign.update(bytes);

        //calculate signature
        byte[] signature = sign.sign();
        sign.initVerify(pair.getPublic());
        sign.update(bytes);

        //verify signature
        boolean bool = sign.verify(signature);

        if(bool)
        {
            System.out.println(ANSI_RED + "Signature verified! :)" + ANSI_RESET);
        }
        else
        {
            System.out.println(ANSI_RED + "Signature failed... :'(" + ANSI_RESET);
        }
    
    }
}