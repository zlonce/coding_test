class Solution {
    public int max = 0;
    public int solution(int k, int[][] dungeons) {
        int count = 0;
        boolean[] visited = new boolean[dungeons.length];
        
        advanture(k, dungeons, visited, count);
        
        return max;
    }
    
    public void advanture(int k, int[][] dungeons, boolean[] visited, int count){
        if (count > max) max = count;

        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] == true) continue;
            if(k >= dungeons[i][0]){
                visited[i] = true;
                int remain = k - dungeons[i][1];
                advanture(remain, dungeons, visited, count+1);
                visited[i] = false;
            }
        }
    }
}