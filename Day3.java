import java.util.HashSet;
import java.util.Scanner;

public class Day3 {
    public Day3() {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> visited = new HashSet<>();
        boolean flag = false;
        Coord santa_loc = new Coord();
        Coord robo_loc = new Coord();
        visited.add("0,0");
        for(char dir : scanner.next().toCharArray()) {
            if(dir == '^') {
                if(flag) santa_loc.y++;
                    else  robo_loc.y++;
            } else if(dir == 'v') {
                if(flag) santa_loc.y--;
                    else  robo_loc.y--;
            } else if(dir == '<') {
                if(flag) santa_loc.x--;
                    else  robo_loc.x--;
            } else if(dir == '>') {
                if(flag) santa_loc.x++;
                    else  robo_loc.x++;
            }
            if(flag) visited.add(santa_loc.toString());
                else visited.add(robo_loc.toString());
            flag = !flag;
        }
        System.out.println(visited.size());
    }

    public static void main(String[] args) {
        Day3 day3 = new Day3();
    }

    private class Coord {
        int x;
        int y;

        public String toString() {
            return this.x+","+this.y;
        }
    }
}
