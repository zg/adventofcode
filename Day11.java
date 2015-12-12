import java.util.Scanner;
import java.util.regex.Pattern;

public class Day11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        for(;;) {
            input = next(input);
            Pattern p1 = Pattern.compile("(abc|bcd|cde|def|efg|fgh|pqr|qrs|rst|stu|tuv|uvw|vwx|wxy|xyz)");
            Pattern p2 = Pattern.compile("(i|l|o)");
            Pattern p3 = Pattern.compile("(.)\\1.*(.)\\2");
            if(!(p1.matcher(input).find() &&
                !p2.matcher(input).find() &&
                 p3.matcher(input).find()))
                continue;
            System.out.println(input);
            break;
        }
    }

    private static String next(String s) {
        int length = s.length();
        char c = s.charAt(length - 1);

        if(c == 'z')
            return length > 1 ? next(s.substring(0, length - 1)) + 'a' : "aa";

        return s.substring(0, length - 1) + ++c;
    }
}
