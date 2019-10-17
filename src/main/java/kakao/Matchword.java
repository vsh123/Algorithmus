package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Matchword {
    public int[] solution(String[] words, String[] queries) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        List<String> wordList = Arrays.asList(words);

        for (String query : queries) {
            String q = query.replaceFirst("\\?", ".*");
            q = q.replaceAll("\\?", "");
            if (map.containsKey(query)) {
                answer.add(map.get(query));
                continue;
            }

            long count = 0;
            String finalQuery = q;
            if (query.matches("\\.*")) {
                count = wordList.stream()
                        .filter(word -> word.length() == query.length())
                        .count();
            } else {
                count = wordList.stream()
                        .filter(word -> word.length() == query.length())
                        .filter(word -> word.matches(finalQuery))
                        .count();
            }

            map.put(query, (int) count);
            answer.add((int) count);
        }
        int[] ans = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }
}
