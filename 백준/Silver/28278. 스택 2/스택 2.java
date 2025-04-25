import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<Integer> stack = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //명령어의 수

        while(N --> 0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("1")){
                stack.addFirst(Integer.parseInt(st.nextToken()));
            }else if(command.equals("2")){
                sb.append(stack.isEmpty() ? -1 : stack.pollFirst()).append("\n");
            }else if(command.equals("3")){
                sb.append(stack.size()).append("\n");
            }else if(command.equals("4")){
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            }else if(command.equals("5")){
                sb.append(stack.isEmpty()? -1 : stack.getFirst()).append("\n");
            }
        }
        br.close();//rr

        System.out.println(sb);

    }

}