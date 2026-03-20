class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        
        for (int i=0; i < n; i++){
            int merged = arr1[i] | arr2[i];
            String binary = String.format("%" + n + "s", Integer.toBinaryString(merged)).replace(' ', '0');
            
            answer[i] = binary.replace("1", "#").replace("0", " ");
        }
        
        return answer;
        
    }
}
