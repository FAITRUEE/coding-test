class Solution {
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
            dfs(computers, visited, i, n);
            answer++; 
            }
        }   
        return answer;
    }
    
    void dfs(int[][] computers, boolean[] visited, int index, int n) {
        visited[index] = true;  
    
        for(int j = 0; j < n; j++) {
            if(j == index) continue;  
            if(computers[index][j] == 1 && !visited[j]) {
                dfs(computers, visited, j, n); 
            }
        }
    }
}
