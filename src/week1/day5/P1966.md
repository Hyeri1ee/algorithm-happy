# 💡**문제 분석 요약**

문서의 개수 N, 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M,

이때 궁금한 문서가 몇 번째로 인쇄되는지 출력한다.

# 💡**알고리즘 설계**

처음 queue에  각 원소들의 중요도를 차례로 넣을 때 max (가장 중요도가 큰 값)를 정한다.

result = 목표 원소가 없어지는 차례 0으로 초기화.

theOne = 목표 원소의 queue에서의 위치. location(초기 위치)로 초기화

1) max > 맨 앞 원소 중요도

맨 앞 원소가 나갈 차례가 아니므로 이를  뽑아서 다시 queue의 뒤쪽으로 넣는다

1-1) theOne  값이 0인 경우

목표 원소가 뒤로 간 케이스 이므로, que.size()-1 값을 theOne에 더해준다

1-2) theOne 값이 0이 아닌 경우

목표 원소가 front 부분을 앞 당겨 진 케이스 이므로, theOne에 -1을 해준다.

2) max = 맨 앞 원소 중요도

2-1) theOne  값은 앞 당겨지는 케이스밖에 없으므로 -1을 해준다. 다만, theOne 값이 -1이 되면 목표 원소가 빠져나간 것이므로, while을 break 해주고 result 값을 증가시킨다. 그후, StringBuilder 값에 result 를 넣어준다.

2-2) 그 외의 경우에는 front 원소를 빼주고, result 값을 증가시킨다음, max 값을 갱신한다.

3) max < 맨 앞 원소 중요도

이 케이스인 경우는 max 값을 매번 갱신하기 때문에 있을 수가 없다.

# 💡코드

```java
package week1.day5;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1966 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  public static void main(String [] args) throws Exception{
    int n = Integer.parseInt(bf.readLine());

    for (int i = 0 ;  i < n ; i++){
      String read = bf.readLine();
      String [] arr = read.split(" ");
      StringTokenizer st = new StringTokenizer(bf.readLine());

      int total = Integer.parseInt(arr[0]);
      int location = Integer.parseInt(arr[1]);

      Queue<Integer> que = new LinkedList<>();
      int max = 0;
      for (int j = 0 ; j < total; j++){
         int newOne = Integer.parseInt(st.nextToken());
         max = (max > newOne) ? max : newOne;
         que.offer(newOne);
      }

      int result = 0;
      int theOne = location;
      //이제 몇 번째로 인쇄되는지 보기
      while(! que.isEmpty()){
        int peek = que.peek();
        if (max > peek)
        {//다시 돌아가기
          que.poll();
          que.offer(peek);
          if (theOne == 0)
            theOne += que.size()-1;
          else
            theOne--;
        }
        else { //max == peek
          que.poll();
          theOne--;
          if (theOne == -1){
            result++;
            break;
          }
          result++;
          //max 다시 정하기
          max = 0;
          for (int k = 0 ;  k <que.size() ; k++){
            if (max < que.peek())
              max = que.peek();
            int pe = que.poll();
            que.offer(pe);
          }
        }
      }
      sb.append(Integer.toString(result) + "\n");
    }
    System.out.println(sb);
  }
}

```

# 💡시간복잡도

O(n^3)

# 💡 틀린 이유

갱신시켜야 되는 변수 값이 result, theOne, max 로 많아서 빼먹는 경우가 있었다.

# 💡 느낀점 or 기억할정보

변수값의 개수를 줄이는 식으로 보완하자.

- 다른 사람 풀이

    ```java
    package week1.day5;
    
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.StringTokenizer;
    public class P1966other {
      public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    
        int T = Integer.parseInt(bf.readLine()); //테스트 케이스 개수
        int count;
        while(T-- > 0 ){
          StringTokenizer st = new StringTokenizer(bf.readLine());
    
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());
    
          LinkedList<int []> q = new LinkedList<>(); //queue로 활용할 연결리스트
          st = new StringTokenizer(bf.readLine());
    
          for (int i = 0 ; i < N; i++){
            //{초기 위치, 중요도}
            q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
          }
    
          count = 0; //출력 횟수
          while(!q.isEmpty()){ //한 케이스에 대한 반복문
            int[] front = q.poll(); //가장 첫 원소
            boolean isMax = true; //front 원소가 가장 큰 원소인지를 판단하는 변수
    
            //큐에 남아있는 원소들과 중요도를 비교
            for (int i =0 ; i<q.size(); i++){
              //처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
              if (front[1] < q.get(i)[1]){
                //뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다. (한번에!!!)
                q.offer(front);
                for (int j = 0 ; j < i ; j++){
                  q.offer(q.poll());
                }
                isMax = false;
                break;
              }
            }
            if (isMax == false)
              continue;
    
            //isMax == true 인 경우
            count++;
            if (front[0] ==  M)
              break;
          }
          sb.append(count).append("\n");
    
        }
        System.out.print(sb);
      }
    }
    
    ```

  [[백준] 1966번 : 프린터 큐 - JAVA [자바]](https://st-lab.tistory.com/201)

  뽑은 원소 및 i 이전의 원소들을 한번에 뒤로 보내는 것이 효율적이라 생각한 코드이다.