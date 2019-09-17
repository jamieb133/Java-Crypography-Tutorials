import java.io.FileInputStream;

import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStore.SecretKeyEntry;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class RetrievingFromKeyStore
{
    public static void main(String args[]) throws Exception
    {
        //create KeyStore
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        //load KeyStore
        char[] password = "changeit".toCharArray();
        String path = "/Library/Java/JavaVirtualMachines/jdk-12.0.2.jdk/Contents/Home/lib/security/cacerts";
        java.io.FileInputStream fis = new FileInputStream(path);
        keyStore.load(fis, password);

        //create KeyStore.ProtectionParameter object
        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

        //create secret key
        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        //store into key store
        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("newKeyStoreName");
        keyStore.store(fos, password);
        
        //creating secret key entry object
        SecretKeyEntry secretKeyEnt = (SecretKeyEntry)keyStore.getEntry("secretKeyAlias", protectionParam);

        //creating another SecretKey object
        SecretKey mysecretKey = secretKeyEnt.getSecretKey();
        System.out.println("Algorithm used to generate key :" + mysecretKey.getAlgorithm());
        System.out.println("Format used for the key: " + mysecretKey.getFormat());

    }
}