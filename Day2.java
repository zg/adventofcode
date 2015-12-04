import java.util.regex.Pattern;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\nx]"));
        int required_paper = 0;
        int required_ribbon = 0;
        while(scanner.hasNextInt()) {
            int l = scanner.nextInt();
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            int min = Math.min(l,Math.min(w,h));
            int max = Math.max(l,Math.max(w,h));
            required_paper += 2*l*w+2*w*h+2*h*l+Math.min(l*w,Math.min(w*h,h*l));
            required_ribbon += 2*(l+w+h-min-max)+2*min+l*w*h;
        }
        System.out.println("Required paper: " + required_paper);
        System.out.println("Required ribbon: " + required_ribbon);
    }
}
