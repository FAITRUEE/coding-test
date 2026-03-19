class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // wallet 작은값, 큰값 정리
        int wMin = Math.min(wallet[0], wallet[1]);
        int wMax = Math.max(wallet[0], wallet[1]);
        
        while (true) {
            // bill 작은값, 큰값 정리
            int bMin = Math.min(bill[0], bill[1]);
            int bMax = Math.max(bill[0], bill[1]);
            
            // 들어가면 종료
            if (bMin <= wMin && bMax <= wMax) {
                break;
            }
            
            // 긴 쪽 접기
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
}
