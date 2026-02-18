import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> list = new LinkedHashMap<>(); 
        Map<String, Integer> times = new TreeMap<>(); 
        
        for(String s : records){
            String[] record = s.split(" ");
            int time = calMinute(record[0]);
            String car = record[1];
            
            if ("IN".equals(record[2])){ 
                list.put(car, time);
            }else{ 
                int inTime = list.remove(car);
                times.put(car, times.getOrDefault(car, 0) + (time-inTime));
            }
        }
        
        int last = 23 * 60 + 59;
        for(Map.Entry<String, Integer> e : list.entrySet()){
            String car = e.getKey();
            int inTime = e.getValue();
            times.put(car, times.getOrDefault(car, 0) + (last-inTime));
        }
        
        int[] answer = new int[times.size()];
        int idx = 0;
        for(int total : times.values()){
            answer[idx++] = calFee(fees, total);
        }
        return answer;
    }
    
    public int calMinute(String time){
        String[] timeArr = time.split(":");
        int hour = Integer.parseInt(timeArr[0]) * 60;
        int min = Integer.parseInt(timeArr[1]);
        return hour + min;
    }
    
    public int calFee(int[] fees, int time){
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if(time <= basicTime) return basicFee;
        int feeTime = time - basicTime;
        int extraFee = (int)Math.ceil((double)feeTime / unitTime);
        int totalFee = basicFee + extraFee * unitFee;
        
        return totalFee;
    }
}