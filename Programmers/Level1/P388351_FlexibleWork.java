class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int count = 0;
        int n = schedules.length;
        
        for (int i = 0; i < n; i++) {
            // 출근 인정 시각 계산 (분 + 10, 60분 넘으면 시 올림)
            int schedule = schedules[i];
            int hour = schedule / 100;
            int minute = schedule % 100 + 10;
            if (minute >= 60) {
                hour += 1;
                minute -= 60;
            }
            int deadline = hour * 100 + minute;
            
            boolean pass = true;
            
            for (int j = 0; j < 7; j++) {
                // 현재 요일 계산 (1=월 ~ 7=일)
                int day = (startday - 1 + j) % 7 + 1;
                
                // 토(6), 일(7)은 스킵
                if (day == 6 || day == 7) continue;
                
                if (timelogs[i][j] > deadline) {
                    pass = false;
                    break;
                }
            }
            
            if (pass) count++;
        }
        
        return count;
    }
}
