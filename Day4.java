import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
    public static void main(String[] args) {
        String input = "ckczppom";
        boolean flag = false;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            int x = 0;
            for(; ; x++) {
                String plaintext = input + Integer.toString(x);
                m.reset();
                m.update(plaintext.getBytes());
                byte[] digest = m.digest();
                BigInteger bigInt = new BigInteger(1, digest);
                String hashText = bigInt.toString(16);
                while(hashText.length() < 32)
                    hashText = "0" + hashText;
                if(hashText.substring(0,5).equals("00000") && !flag) {
                    flag = true;
                    System.out.println(x);
                }
                if(hashText.substring(0,6).equals("000000"))
                    break;
            }
            System.out.println(x);
        } catch(NoSuchAlgorithmException nae) {
        }
    }
}
