class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int x = n % a;
            int y = n / a;
            
            answer += b*y;
            n = x + y*b;
            
        }
        
        return answer;
    }
}