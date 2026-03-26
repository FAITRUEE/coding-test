import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 중복 제거용 Set
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            wordSet.add(br.readLine().trim());
        }

        // List로 변환
        List<String> wordList = new ArrayList<>(wordSet);

        // 정렬: 길이 순, 길이 같으면 사전 순
        Collections.sort(wordList, (a, b) -> 
            a.length() != b.length() ? a.length() - b.length() : a.compareTo(b)
        );

        // 출력
        for (String word : wordList) {
            System.out.println(word);
        }
    }
}
