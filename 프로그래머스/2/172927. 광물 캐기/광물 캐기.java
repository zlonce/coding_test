import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = totalPicks * 5;
        int len = Math.min(minerals.length, maxMinerals);

        List<int[]> groups = new ArrayList<>();
        
        for (int i = 0; i < len; i += 5) {
            int[] count = new int[3]; // 0: diamond, 1: iron, 2: stone
            
            for (int j = i; j < i + 5 && j < len; j++) {
                if (minerals[j].equals("diamond")) {
                    count[0]++;
                } else if (minerals[j].equals("iron")) {
                    count[1]++;
                } else {
                    count[2]++;
                }
            }
            
            groups.add(count);
        }
        
        groups.sort((a, b) -> {
            int scoreA = a[0] * 25 + a[1] * 5 + a[2];
            int scoreB = b[0] * 25 + b[1] * 5 + b[2];
            return scoreB - scoreA; 
        });

        for (int[] group : groups) {
            if (picks[0] > 0) { // 다이아 곡괭이
                answer += group[0] + group[1] + group[2];
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이
                answer += group[0] * 5 + group[1] + group[2];
                picks[1]--;
            } else if (picks[2] > 0) { // 돌 곡괭이
                answer += group[0] * 25 + group[1] * 5 + group[2];
                picks[2]--;
            }
        }
        
        return answer;
    }
}