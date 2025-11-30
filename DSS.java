import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class DSS {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024);
        KeyPair kp = kpg.generateKeyPair();

        Signature sg = Signature.getInstance("SHA1withDSA");
        sg.initSign(kp.getPrivate());
        sg.update(msg.getBytes());
        String sign = Base64.getEncoder().encodeToString(sg.sign());

        sg.initVerify(kp.getPublic());
        sg.update(msg.getBytes());
        boolean valid = sg.verify(Base64.getDecoder().decode(sign));

        System.out.println("Signature: "+sign);
        System.out.println("Valid: "+valid);
    }
}
