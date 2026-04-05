import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int minP = Integer.MAX_VALUE;
        int minS = Integer.MAX_VALUE;
        
        for (int i = 0; i < M; i++) {
            int P = sc.nextInt();
            int S = sc.nextInt();
            minP = Math.min(minP, P);
            minS = Math.min(minS, S);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (int k = 0; k * 6 < N + 6; k++) {
            int bought = k * 6;
            int remaining = Math.max(0, N - bought);
            int cost = k * minP + remaining * minS;
            ans = Math.min(ans, cost);
        }
        
        System.out.println(ans);
    }
}
