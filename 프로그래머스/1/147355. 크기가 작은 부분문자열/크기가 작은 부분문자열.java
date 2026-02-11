class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int lenT = t.length();
        int lenP = p.length();
        long numP = Long.parseLong(p);
        
        for(int i = 0; i <= lenT - lenP; i++){
            long num = Long.parseLong(t.substring(i, i+lenP));
            if(numP >= num) answer++;
        }
        return answer;
    }
}