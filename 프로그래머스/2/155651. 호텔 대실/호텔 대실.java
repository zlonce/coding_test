import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int size = book_time.length;
        int[][] times = new int[size][2];
        
        for(int i = 0; i < size; i++){
            String[] time = book_time[i];
            int startMin = calTime(time[0]);
            int endMin = calTime(time[1]) + 10;
            
            times[i][0] = startMin;
            times[i][1] = endMin;
        }   
        
        Arrays.sort(times, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] t : times) {
            int start = t[0];
            int end = t[1];

            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.add(end);
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
    
    public int calTime(String time){
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h*60 + m;
    }
}