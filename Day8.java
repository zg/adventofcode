import java.util.Scanner;

public class Day8 {
    public static void main(String[] args) {
        int p1_total = 0;
        int p2_total = 0;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String in = scanner.nextLine();
            StringBuilder mem = new StringBuilder();
            for(int cursor = 1; cursor < in.length() - 1; cursor++) {
                switch(in.charAt(cursor)) {
                    case '\\':
                        if(in.charAt(cursor + 1) == 'x') {
                            int code = Integer.parseInt(""+in.charAt(cursor+2)
                                                          +in.charAt(cursor+3),16);
                            mem.append(Character.toChars(code));
                            cursor += 2;
                        } else
                            mem.append(in.charAt(cursor + 1));
                        cursor += 1;
                        continue;
                    default:
                        mem.append(in.charAt(cursor));
                    continue;
                }
            }
            StringBuilder esc = new StringBuilder().append("\"");
            for(int cursor = 0; cursor < in.length(); cursor++) {
                switch(in.charAt(cursor)) {
                    case '\\':
                        esc.append("\\\\");
                        if(in.charAt(cursor + 1) == 'x')
                            esc.append("x");
                        else
                            esc.append("\\"+in.charAt(cursor + 1));
                        cursor += 1;
                        continue;
                    case '\"':
                        esc.append("\\\"");
                    continue;
                    default:
                        esc.append(in.charAt(cursor));
                    continue;
                }
            }
            esc.append("\"");
            p1_total += in.length() - mem.toString().length();
            p2_total += esc.toString().length() - in.toString().length();
        }
        System.out.println(p1_total);
        System.out.println(p2_total);
    }
}
