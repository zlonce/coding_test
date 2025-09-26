import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            if(isVps(line))
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        bw.append(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean isVps(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(')
                stack.push(c);
            else if(c == ')'){ //짝이 있을 경우 pop
                if(stack.isEmpty())
                    return false;
                else stack.pop();
            } 
        }
        return stack.isEmpty(); //비었는지 확인
    }
}
