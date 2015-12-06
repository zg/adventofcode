import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day6 {
    public static void main(String[] args) {
        boolean[][] lit = new boolean[1000][1000];
        int[][] brightness = new int[1000][1000];
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            Matcher m = Pattern.compile("([e|n ([n|f])]) (\\d+),(\\d+) through (\\d+),(\\d+)").matcher(scanner.nextLine());
            if(m.find()) {
                String instr = m.group(1);
                int x_s = Integer.parseInt(m.group(2));
                int y_s = Integer.parseInt(m.group(3));
                int x_e = Integer.parseInt(m.group(4));
                int y_e = Integer.parseInt(m.group(5));
                if(instr.equals("n")) {        // on
                    int count = 0;
                    for(int x = x_s; x <= x_e; x++)
                        for(int y = y_s; y <= y_e; y++) {
                            lit[x][y] = true;
                            brightness[x][y] += 1;
                        }
                } else if(instr.equals("f")) { // off
                    for(int x = x_s; x <= x_e; x++)
                        for(int y = y_s; y <= y_e; y++) {
                            lit[x][y] = false;
                            brightness[x][y] -= (brightness[x][y] > 0 ? 1 : 0);
                        }
                } else if(instr.equals("e")) { // toggle
                    for(int x = x_s; x <= x_e; x++)
                        for(int y = y_s; y <= y_e; y++) {
                            lit[x][y] = !lit[x][y];
                            brightness[x][y] += 2;
                        }
                }
            }
        }

        int lit_count = 0;
        int luminosity = 0;
        for(int x = 0; x < 1000; x++)
            for(int y = 0; y < 1000; y++) {
                lit_count += lit[x][y] ? 1 : 0;
                luminosity += brightness[x][y];
            }
        System.out.println(lit_count);
        System.out.println(luminosity);
    }
}
