import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        int floor = 0;
        int position = 0;
        for(char dir : scanner.next().toCharArray()) {
            floor += dir == '(' ? 1 : -1;
            if(!flag) {
                position++;
                if(floor == -1) {
                    System.out.println("Basement reached at position " + position);
                    flag = true;
                }
            }
        }
        System.out.println("Santa is on floor #" + floor);
    }
}
