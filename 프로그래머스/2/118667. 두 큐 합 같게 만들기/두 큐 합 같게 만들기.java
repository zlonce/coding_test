import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int size = queue1.length;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();

        long totalQ1 = calTotal(queue1, q1);
        long totalQ2 = calTotal(queue2, q2);

        long totalSum = totalQ1 + totalQ2;
        if (totalSum % 2 != 0) return -1;

        long target = totalSum / 2;

        int count = 0;
        int limit = size * 3; 

        while (count < limit && totalQ1 != target) {
            if (totalQ1 < target) {          
                Long popNum = q2.poll();
                if (popNum == null) return -1;
                q1.offer(popNum);
                totalQ1 += popNum;
                totalQ2 -= popNum;
            } else {                         
                Long popNum = q1.poll();
                if (popNum == null) return -1;
                q2.offer(popNum);
                totalQ1 -= popNum;
                totalQ2 += popNum;
            }
            count++;
        }

        return (totalQ1 == target) ? count : -1;
    }

    public long calTotal(int[] arr, Queue<Long> q) {
        long total = 0;
        for (int k : arr) {
            q.offer((long) k);
            total += k;
        }
        return total;
    }
}
