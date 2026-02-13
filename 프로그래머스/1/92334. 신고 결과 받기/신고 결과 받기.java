import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> reportList = new HashMap<>();
        Map<String, Integer> countList = new HashMap<>();
        
        for(String user: id_list){
            reportList.put(user, new HashSet<>());
            countList.put(user, 0);
        }
        
        for(String s : report){
            String[] splitReport = s.split(" ");
            String reporter = splitReport[0];
            String reported = splitReport[1];
            
            reportList.get(reported).add(reporter);
        }
        
        for (String reportedUser: reportList.keySet()) {
            HashSet<String> reporters = reportList.get(reportedUser);
            if (reporters.size() >= k) {
                for (String reporter: reporters) {
                    countList.put(reporter, countList.get(reporter)+1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = countList.get(id_list[i]);
        }
        return answer;
    }
}