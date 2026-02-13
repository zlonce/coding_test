class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int k = arr1[0].length;
        int m = arr2[0].length;
        int[][] answer = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int r = 0; r < k; r++){
                    answer[i][j] += arr1[i][r] * arr2[r][j];
                }
            }
        }
        return answer;
    }
}