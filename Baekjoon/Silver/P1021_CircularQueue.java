import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int result = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = dq.indexOf(target);

            if (idx <= dq.size() / 2) {
                // 왼쪽 이동
                while (dq.peekFirst() != target) {
                    dq.addLast(dq.pollFirst());
                    result++;
                }
            } else {
                // 오른쪽 이동
                while (dq.peekFirst() != target) {
                    dq.addFirst(dq.pollLast());
                    result++;
                }
            }

            dq.pollFirst(); // 제거
        }

        System.out.println(result);
    }
}
