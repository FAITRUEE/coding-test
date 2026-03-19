class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        long sum = sequence[0];
        int[] answer = new int[]{0, sequence.length - 1}; // 일단 최대 길이로 초기화
        
        
        while (right < sequence.length) {
            if (sum == k) {
                // 현재 길이 (right-left)가 저장된 것보다 짧으면 갱신
                if (right-left < answer[1] - answer[0]){
                    answer[0] = left;
                    answer[1] = right;
                }
                right++;
                if (right < sequence.length) sum += sequence[right];
                
            } else if (sum < k) {
                right++;
                if (right < sequence.length) sum += sequence[right];
            } else {
                sum -= sequence[left];
                left++;
                
            }
        }
        return answer;
    }
}
