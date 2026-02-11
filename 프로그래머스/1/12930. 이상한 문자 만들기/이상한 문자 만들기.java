class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            
            if(a == ' '){
                answer += ' ';
                idx = 0;
                continue;
            }
            
            if(idx%2 == 0){
                answer += Character.toUpperCase(a);
            }else{
                answer += Character.toLowerCase(a);
            }
            
            idx++;
        }
        return answer;
    }
}