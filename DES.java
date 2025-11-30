import javax.crypto.*;
import java.util.Base64;
import java.util.Scanner;

public class DES {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text: ");
        String plain = sc.nextLine();

        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey key = kg.generateKey();
        Cipher c = Cipher.getInstance("DES");
        
        c.init(Cipher.ENCRYPT_MODE, key);
        String enc = Base64.getEncoder().encodeToString(c.doFinal(plain.getBytes()));

        c.init(Cipher.DECRYPT_MODE, key);
        String dec = new String(c.doFinal(Base64.getDecoder().decode(enc)));

        System.out.println("Encryption: "+enc);
        System.out.println("Decryption: "+dec);
    }
    
}
