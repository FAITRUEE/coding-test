import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int M = sc.nextInt(); 
        
        int[] P = new int[M];
        for (int i = 0; i < M; i++) {
            P[i] = sc.nextInt();
        }
        
        long maxRevenue = 0;
        int bestPrice = 0;
        
        for (int i = 0; i < M; i++) {
            int price = P[i];
            
            int buyers = 0;
            for (int j = 0; j < M; j++) {
                if (P[j] >= price) buyers++;
            }
            
            int sold = Math.min(buyers, N);
            long revenue = (long) price * sold;
            
            if (revenue > maxRevenue) {
                maxRevenue = revenue;
                bestPrice = price;
            }
        }
        
        System.out.println(bestPrice + " " + maxRevenue);
    }
}
