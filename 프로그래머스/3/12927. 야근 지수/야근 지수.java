import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            queue.offer(work);
        }

        while (n > 0 && !queue.isEmpty()) {
            int max = queue.poll();
            if (max == 0) {
                queue.offer(0);
                break;
            }

            queue.offer(max - 1);
            n--;
        }

        long answer = 0;
        while (!queue.isEmpty()) {
            long work = queue.poll();
            answer += work * work;
        }

        return answer;
    }
}