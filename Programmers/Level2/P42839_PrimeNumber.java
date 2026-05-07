import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> results = new HashSet<>();
        permute(numbers.toCharArray(), new boolean[numbers.length()], "", results);
        
        for (int num : results) {
            if (isPrime(num)) answer++;
        }

        return answer;
    }
    
    private void permute(char[] arr, boolean[] used, String current, Set<Integer> results) {
        if (!current.isEmpty()) {
            results.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permute(arr, used, current + arr[i], results);
                used[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
}
