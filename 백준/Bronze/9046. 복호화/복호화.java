import java.io.*;
import java.util.*;
//폰으로 풀기 (1/3)
public class Main {
    static int t;
    static HashMap<Character,Integer> alpha;
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        while(t-- >0){
            alpha = new HashMap<>();
            char[] str = bf.readLine()
                    .toCharArray();
            for(int i=0; i < str.length; i++){
                if (str[i] == ' ') continue;

                if(!alpha.containsKey(str[i]) ){
                    alpha.put(str[i],1);


                }else{

                    alpha.put(str[i],  alpha.get(str[i])+1);

                }

            }

            //최대값 찾기 없으면 ? 출력
            int max=0;
            char result = '?';
            boolean isDuplicate = false;

            for (char key : alpha.keySet()) {
                int val = alpha.get(key);
                if (val > max) {
                    max = val;
                    result = key;
                    isDuplicate = false;
                } else if (val == max) {
                    isDuplicate = true;
                }
            }

            if (isDuplicate) {
                sb.append("?\n");
            } else {
                sb.append(result+"\n");
            }
        }

        System.out.println(sb);
    }
}
