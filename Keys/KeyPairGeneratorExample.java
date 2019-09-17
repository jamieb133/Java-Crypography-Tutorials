import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyPairGeneratorExample
{
    public static void main(String args[]) throws Exception
    {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);

        //generate pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //get private key from pair
        PrivateKey privKey = pair.getPrivate();

        //get public key from the key pair
        PublicKey publicKey = pair.getPublic();
        System.out.println("Keys generated");

    }
}