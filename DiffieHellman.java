import javax.crypto.KeyAgreement;
import java.security.*;
import java.util.Base64;

public class DiffieHellman {
    public static void main(String[] args) throws Exception{
        KeyPairGenerator kgp = KeyPairGenerator.getInstance("DH");
        kgp.initialize(512);
        KeyPair A = kgp.generateKeyPair();
        KeyPair B = kgp.generateKeyPair();
        
        javax.crypto.KeyAgreement ka = KeyAgreement.getInstance("DH");
        ka.init(A.getPrivate());
        ka.doPhase(B.getPublic(), true);
        String secretA = Base64.getEncoder().encodeToString(ka.generateSecret());

        javax.crypto.KeyAgreement kb = KeyAgreement.getInstance("DH");
        kb.init(B.getPrivate());
        kb.doPhase(A.getPublic(), true);
        String secretB = Base64.getEncoder().encodeToString(kb.generateSecret());

        System.out.println("A's shared secret key: "+secretA);
        System.out.println("B's shared secret key: "+secretB);

    }    
}
