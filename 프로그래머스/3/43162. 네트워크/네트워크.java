class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, computers, visited, n);
                answer++;
            }
                
        }
                
        return answer;
    }
    public void dfs(int computer, int[][] computers, boolean[] visited, int n){
        visited[computer] = true;

        for(int i = 0; i < n; i++){
            if(computers[computer][i] == 1 && !visited[i]){
                dfs(i, computers, visited, n);
            }
        }
    }
}