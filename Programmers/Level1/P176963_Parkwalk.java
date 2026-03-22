import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        
        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (String person : photo[i]) {
                result[i] += scoreMap.getOrDefault(person, 0);
            }
        }
        return result;
    }
}
