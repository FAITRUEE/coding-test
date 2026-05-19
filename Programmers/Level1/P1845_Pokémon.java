import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int limit = nums.length / 2;
        int kinds = set.size();
        
        return Math.min(limit, kinds);
    }
}
