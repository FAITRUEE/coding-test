class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int h = 3; h <= total; h++) {
            for (int w = h; w <= total; w++) {
                if (w * h == total && 2 * w + 2 * h - 4 == brown) {
                    return new int[]{w, h};
                }
            }
        }
        
        return new int[]{};
    }
}
