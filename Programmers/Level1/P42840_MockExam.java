import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
            
        int[] score = new int[3]; 
        int maxScore = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == pattern1[i % pattern1.length]) score[0]++;
            if(answers[i] == pattern2[i % pattern2.length]) score[1]++;
            if(answers[i] == pattern3[i % pattern3.length]) score[2]++;
        }
        
        for(int i = 0; i < 3; i++){
            if(maxScore < score[i]) {
                maxScore = score[i];
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(score[i] == maxScore) list.add(i + 1);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer; 
        
    }
}
