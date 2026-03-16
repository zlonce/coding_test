import java.util.*;

class Solution {
    List<Integer>[] tree;
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges){
            int parent = edge[0];
            int child = edge[1];
            tree[parent].add(child);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);

        dfs(info, 0, 0, list);

        return answer;
    }

    private void dfs(int[] info, int sheep, int wolf, List<Integer> list) {
        for (int next : list) {
            int nextSheep = sheep;
            int nextWolf = wolf;

            if (info[next] == 0) {
                nextSheep++;
            } else {
                nextWolf++;
            }

            if (nextWolf >= nextSheep) {
                continue;
            }

            answer = Math.max(answer, nextSheep);

            List<Integer> nextList = new ArrayList<>(list);
            nextList.remove(Integer.valueOf(next)); 
            nextList.addAll(tree[next]);           

            dfs(info, nextSheep, nextWolf, nextList);
        }
    }
}