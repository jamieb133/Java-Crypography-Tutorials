import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class StoringIntoKeyStore
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
        System.out.println("data stored");

    }
}