class Solution {
    public int[] solution(String[] wallpaper) {
        int w = wallpaper[0].length();
        int h = wallpaper.length;
        int[] answer = {h, w, -1, -1};
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if (answer[0] > i) answer[0] = i;
                    if (answer[1] > j) answer[1] = j;
                    if (answer[2] < i) answer[2] = i;
                    if (answer[3] < j) answer[3] = j;
                }
            }
        }
        
        answer[2] += 1;
        answer[3] += 1;
        
        return answer;
    }
}