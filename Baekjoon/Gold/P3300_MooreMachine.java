import java.util.*;

public class Main {

    static String machine;
    static String output;
    static int pos;

    static Set<Integer> parseSerial(Set<Integer> starts) {
        Set<Integer> current = new HashSet<>(starts);

        while (pos < machine.length()) {
            char c = machine.charAt(pos);
            if (c == ')' || c == '|') break;

            if (c == '(') {
                pos++; 
                current = parseParallel(current);
                pos++; 
            } else {
                Set<Integer> next = new HashSet<>();
                for (int i : current) {
                    if (i < output.length() && output.charAt(i) == c) {
                        next.add(i + 1);
                    }
                }
                current = next;
                pos++;
            }

            if (current.isEmpty()) {
                skipToEnd();
                break;
            }
        }

        return current;
    }

    static void skipToEnd() {
        int depth = 0;
        while (pos < machine.length()) {
            char c = machine.charAt(pos);
            if (c == '(') depth++;
            else if (c == ')') {
                if (depth == 0) break;
                depth--;
            } else if (c == '|' && depth == 0) break;
            pos++;
        }
    }

    static Set<Integer> parseParallel(Set<Integer> starts) {
        Set<Integer> result = new HashSet<>();

        result.addAll(parseSerial(starts));

        while (pos < machine.length() && machine.charAt(pos) == '|') {
            pos++; 

            int branchStart = pos;
            result.addAll(parseSerial(starts));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        while (T-- > 0) {
            String originalMachine = sc.nextLine().trim();
            output = sc.nextLine().trim();

            Set<Character> answers = new HashSet<>();

            for (char ch = 'A'; ch <= 'Z'; ch++) {
                machine = originalMachine.replace('_', ch);
                pos = 0;

                Set<Integer> starts = new HashSet<>();
                starts.add(0);

                Set<Integer> ends = parseSerial(starts);

                if (ends.contains(output.length())) {
                    answers.add(ch);
                }
            }

            if (answers.size() == 1) {
                System.out.println(answers.iterator().next());
            } else if (answers.size() > 1) {
                System.out.println("_");
            } else {
                System.out.println("!");
            }
        }
    }
}
