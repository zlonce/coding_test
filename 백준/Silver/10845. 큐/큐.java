import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String input = br.readLine().trim();
            int size = list.size();
            int rear = size -1;

            switch(input){
                case "pop": {
                    if(size == 0)
                        sb.append(-1).append("\n");
                    else{
                        sb.append(list.get(0)).append("\n");
                        list.remove(0);
                    }
                    break;
                }
                case "size": {
                    sb.append(size).append("\n");
                    break;
                }
                case "empty": {
                    if(size == 0)
                        sb.append(1).append("\n");
                    else 
                        sb.append(0).append("\n");
                    break;
                }
                case "front": {
                    if(size == 0)
                        sb.append(-1).append("\n");
                    else
                        sb.append(list.get(0)).append("\n");
                    break;
                }
                case "back": {
                    if(size == 0)
                        sb.append(-1).append("\n");
                    else 
                        sb.append(list.get(rear)).append("\n");
                    break;
                }
                default: {
                    int num = Integer.parseInt(input.substring(5));
                    list.add(num);
                }
            }
        }
        bw.append(sb.toString());
        bw.flush();
        bw.close();
    }
}
