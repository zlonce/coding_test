import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int tan : tangerine) {
            count.put(tan, count.getOrDefault(tan, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (k <= 0) break;
            k -= entry.getValue();
            answer++;
        }

        return answer;
    }
}