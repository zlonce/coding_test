import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int count = 0;

        for (int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            int c = cost[2];

            if (find(parent, start) != find(parent, end)) {
                union(parent, start, end);
                answer += c;
                count++;

                if (count == n - 1) break;
            }
        }

        return answer;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    private void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}