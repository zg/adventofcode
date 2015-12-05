import java.util.Scanner;
import java.util.regex.Pattern;

public class Day5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern p1_p1 = Pattern.compile("ab|cd|pq|xy");
        Pattern p1_p2 = Pattern.compile("(.*[aeiou]){3}");
        Pattern p1_p3 = Pattern.compile("(.)\\1");
        Pattern p2_p1 = Pattern.compile("(..).*\\1");
        Pattern p2_p2 = Pattern.compile("(.).\\1");

        int p1_count = 0;
        int p2_count = 0;

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if(!p1_p1.matcher(input).find() &&
                p1_p2.matcher(input).find() &&
                p1_p3.matcher(input).find()) {
                p1_count++;
            }

            if(p2_p1.matcher(input).find() &&
               p2_p2.matcher(input).find()) {
                p2_count++;
            }
        }

        System.out.println(p1_count);
        System.out.println(p2_count);
    }
}
