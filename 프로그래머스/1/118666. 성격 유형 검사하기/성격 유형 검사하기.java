import java.util.*;


class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> score = new HashMap<>();
        
        for(int i = 0; i < survey.length; i++){
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);
            int point = choices[i];
            
            if(point < 4){
                point = 4 - point;
                score.put(left, score.getOrDefault(left, 0) + point);    
            }
            if(point > 4){
                point = point - 4;
                score.put(right, score.getOrDefault(right, 0) + point);         
            }
        }
        
        StringBuilder type = new StringBuilder();
        
        type.append(score.getOrDefault('R', 0) >= score.getOrDefault('T', 0) ? 'R' : 'T');
        type.append(score.getOrDefault('C', 0) >= score.getOrDefault('F', 0) ? 'C' : 'F');
        type.append(score.getOrDefault('J', 0) >= score.getOrDefault('M', 0) ? 'J' : 'M');
        type.append(score.getOrDefault('A', 0) >= score.getOrDefault('N', 0) ? 'A' : 'N');
        
        return type.toString();
    }
}