import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] maze = new int[N][M];
    
    for(int i = 0; i < N; i++){
      String line = br.readLine();
      for(int j = 0; j < M; j++){
        maze[i][j] = line.charAt(j) - '0';
      }
    }

    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[N][M];
    int[][] dist = new int[N][M];

    int[] dx = {-1, 1 , 0, 0}; 
    int[] dy = {0, 0, -1, 1};
    
    q.add(new int[]{0, 0}); // 시작점
    visited[0][0] = true;
    dist[0][0] = 1;

    while(!q.isEmpty()){
      int [] cur = q.poll();
      int x = cur[0];
      int y = cur[1];

      for(int d = 0; d < 4; d++){ // 0:좌, 1:우, 2:하, 3:상
        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx >= 0 && nx < N && ny >= 0 && ny < M){
          if(maze[nx][ny] == 1 && !visited[nx][ny]){
            visited[nx][ny] = true;
            dist[nx][ny] = dist[x][y] + 1;
            q.add(new int[]{nx, ny});
          }
        }
      }
    }
    System.out.println(dist[N-1][M-1]);
  }
}
  
