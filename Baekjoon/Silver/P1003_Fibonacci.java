import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long[] fib = new long[41];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= 40; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = sc.nextInt();
            if (n == 0) sb.append("1 0\n");
            else if (n == 1) sb.append("0 1\n");
            else sb.append(fib[n-1]).append(" ").append(fib[n]).append("\n");
        }
        System.out.print(sb);
    }
}
