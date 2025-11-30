import javax.crypto.*;
import java.util.Base64;
import java.util.Scanner;

public class AESExample {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the message: ");
        String msg = sc.nextLine();

        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);
        SecretKey key = kg.generateKey();

        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        String enc = Base64.getEncoder().encodeToString(c.doFinal(msg.getBytes()));
        System.out.println("Encryption: " + enc);

        c.init(Cipher.DECRYPT_MODE, key);
        String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));
        System.out.println("Decryption: " + dec);
    }
}
