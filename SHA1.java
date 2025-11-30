import java.security.MessageDigest;
import java.util.Scanner;

public class SHA1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte [] hash = md.digest(msg.getBytes());

        System.out.println("SHA 1: ");
        for( byte b : hash){
            System.out.printf("%02x", b);
        }
    }
}
