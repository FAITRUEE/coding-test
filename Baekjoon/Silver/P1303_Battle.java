import java.util.*;
import java.io.*;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        
        board = new char[M][N];
        visited = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        long wPower = 0, bPower = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    long count = bfs(i, j);
                    long power = count * count;
                    if (board[i][j] == 'W') {
                        wPower += power;
                    } else {
                        bPower += power;
                    }
                }
            }
        }
        
        System.out.println(wPower + " " + bPower);
    }
    
    static long bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        char color = board[startX][startY];
        long count = 1;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] != color) continue;
                
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                count++;
            }
        }
        
        return count;
    }
}
