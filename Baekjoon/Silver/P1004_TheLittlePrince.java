import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            long x1 = sc.nextLong(), y1 = sc.nextLong();
            long x2 = sc.nextLong(), y2 = sc.nextLong();
            int n = sc.nextInt();
            
            int count = 0;
            for (int i = 0; i < n; i++) {
                long cx = sc.nextLong(), cy = sc.nextLong(), r = sc.nextLong();
                
                boolean startInside = (x1-cx)*(x1-cx) + (y1-cy)*(y1-cy) < r*r;
                boolean endInside   = (x2-cx)*(x2-cx) + (y2-cy)*(y2-cy) < r*r;
                
                if (startInside != endInside) {
                    count++;
                }
            }
            
            System.out.println(count);
        }
        
        sc.close();
    }
}
