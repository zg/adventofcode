public class Day10 {
    private static int lookAndSayLength(String init, int iters) {
        StringBuilder[] outputs = new StringBuilder[iters + 1];
        outputs[0] = new StringBuilder().append(init);

        for(int i = 1; i <= iters; i++) {
            outputs[i] = new StringBuilder();
            String input = outputs[i-1].toString();
            StringBuilder output = outputs[i];
            char curr = input.charAt(0);
            int seq_count = 1;
            for(int cursor = 1; cursor < input.length(); cursor++) {
                if(curr == input.charAt(cursor)) {
                    seq_count += 1;
                } else {
                    output.append(seq_count+""+curr);
                    curr = input.charAt(cursor);
                    seq_count = 1;
                }
            }
            output.append(seq_count+""+curr);
        }
        return outputs[iters].toString().length();
    }

    public static void main(String[] args) {
        System.out.println(lookAndSayLength("1113222113", 40));
        System.out.println(lookAndSayLength("1113222113", 50));
    }
}
