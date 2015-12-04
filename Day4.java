import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "ckczppom";
        boolean flag = false;
            MessageDigest m = MessageDigest.getInstance("MD5");
            int count = 0;
            for(; ; count++) {
                byte[] digest = m.digest((input + Integer.toString(count)).getBytes());
                BigInteger bigInt = new BigInteger(1, digest);
                String hashText = bigInt.toString(16);
                while(hashText.length() < 32)
                    hashText = "0" + hashText;
                if(hashText.substring(0,5).equals("00000") && !flag) {
                    flag = true;
                    System.out.println(count);
                }
                if(hashText.substring(0,6).equals("000000"))
                    break;
            }
            System.out.println(count);
    }
}
