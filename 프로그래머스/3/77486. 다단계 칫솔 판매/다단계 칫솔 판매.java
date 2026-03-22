import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int size = enroll.length;
        int[] answer = new int[size];
        HashMap<String, Member> list = new HashMap<>();
        for(int i = 0; i < size; i++){
            list.put(enroll[i], new Member(referral[i]));
        }        
        
        for(int i = 0; i < seller.length; i++){
            int pay = amount[i] * 100;
            calResult(list, seller[i], pay);
        }
        
        for(int i = 0; i < size; i++){
            String m = enroll[i];
            answer[i] = list.get(m).result;
        }
        
        return answer;
    }
    
    public void calResult(HashMap<String, Member> list, String member,int pay){
        if(member.equals("-") || pay == 0) return;
        String referrer = list.get(member).name;
        int override = (int)(pay*0.1);
        int remaining = pay - override;
        list.get(member).result += remaining;
        
        calResult(list, referrer, override);
    }
}

class Member{
    String name;
    int result;
    
    public Member(String referrer){
        this.name = referrer;
        this.result = 0;
    }
}