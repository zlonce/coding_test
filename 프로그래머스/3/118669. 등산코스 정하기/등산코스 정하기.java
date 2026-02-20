import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        ArrayList<int[]>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        
        for(int path[] : paths){
            int s = path[0], e = path[1], t = path[2];
            list[s].add(new int[]{e, t});
            list[e].add(new int[]{s, t});
        }
        
        boolean[] isGate = new boolean[n+1];
        boolean[] isSummit = new boolean[n+1];
        for (int gate : gates) isGate[gate] = true;
        for (int summit : summits) isSummit[summit] = true;

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int gate : gates) {
            dist[gate] = 0;
            pqueue.offer(new int[]{0, gate});
        }

        while (!pqueue.isEmpty()) {
            int[] cur = pqueue.poll();
            int cost = cur[0], now = cur[1];

            if (dist[now] < cost) continue;
            if (isSummit[now]) continue;

            for (int[] next : list[now]) {
                int nNode = next[0], nCost = next[1];

                if (isGate[nNode]) continue;

                int newCost = Math.max(cost, nCost);
                if (dist[nNode] > newCost) {
                    dist[nNode] = newCost;
                    pqueue.offer(new int[]{newCost, nNode});
                }
            }
        }

        int[] answer = {-1, Integer.MAX_VALUE};
        int[] sortedSummits = summits.clone();
        Arrays.sort(sortedSummits);

        for (int summit : sortedSummits) {
            if (dist[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = dist[summit];
            }
        }

        return answer;
    }
}