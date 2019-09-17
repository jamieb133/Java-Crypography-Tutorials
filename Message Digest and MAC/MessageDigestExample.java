import java.security.MessageDigest;
import java.util.Scanner;

public class MessageDigestExample
{
    public static void main(String args[]) throws Exception
    {
        //read data from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message");
        String message = sc.nextLine();

        //create MessageDigest
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        //passing data to new MessageDigest
        md.update(message.getBytes());

        //compute digest
        byte[] digest = md.digest();
        System.out.println(digest);

        //convert byte array to hex string
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < digest.length; i++)
        {
            hexString.append(Integer.toHexString((0xFF & digest[i])));
        }
        System.out.println("Hex format :" + hexString.toString());
    }
}