# 💡**문제 분석 요약**

Solution 함수의 매개변수는 3개가 주어진다.

bridge_length : 다리에 올라갈 수 있는 트럭 수

weight : 다리가 견딜 수 있는 무게

truck_weight : 트럭별 무게를 배열로 줌

모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 반환하는 Solution 함수를 작성하는 문제이다.

# 💡**알고리즘 설계**

Queue 를 활용하여, sum (다리를 건너는 트럭들의 무게의 합) , answer (다리를 모두 건너는데에 걸리는 시간) 을 계산한다.

이때 큐는 현재 다리의 상태 즉, 다리를 건너고 있을 경우 큐에 값을 넣어주어 상태를 판별 할 수 있다.

또한, 트럭 1대가 다리 1칸을 건너는데 걸리는 시간은 1이다.

1) 큐가 비어있는 경우

2) 큐가 비어있지 않은 경우

2-1) 큐의 사이즈와 다리의 길이가 같은 경우

2-2) 다음 트럭이 최대 무게를 초과할때

2-3) 다음 트럭이 최대 무게를 초과하지 않을때

이렇게 경우의 수를 나누어 생각한다.

# 💡코드

```java
package week1.day3;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;

    Queue<Integer> q = new LinkedList<Integer>();
    int sum = 0; // 다리를 건너는 트럭들의 무게 합

    for(int t : truck_weights) {

      while(true) {
        //큐가 비어있다면 다음 트럭 삽입
        if(q.isEmpty()) {
          q.offer(t);
          sum += t;
          answer++;
          break;
        }
        //큐의 사이즈와 다리의 길이가 같다면 큐에서 큐에서 처음 값을 빼고 최대 무게
        else if(q.size() == bridge_length) {
          sum -= q.poll();
        }
        //큐가 비어있지 않을 때
        else {
          //다음 트럭이 최대 무게 초과
          if(sum + t > weight) {
            q.offer(0);
            answer++;
          }
          //다음 트럭이 최대 무게 이내
          else {
            q.offer(t);
            sum += t;
            answer++;
            break;
          }
        }
      }
    }

    //걸린 시간 + 마지막 트럭의 통과시간(다리의 길이)
    return answer + bridge_length;
  }
}
```

# 💡시간복잡도

O(n)  이때 n 은 truck_weight의 길이

# 💡 틀린 이유

문제 자체에서 1초당 1칸을 트럭이 움직인다는 게 주어지지 않아서 이해하는데 시간이 오래걸렸다.

# 💡 느낀점 or 기억할정보

복잡한 문제는 경우의 수를 나누어 생각하자.

<details>
<summary>출처</summary>
<div>

[[프로그래머스] 다리를 지나는 트럭 - Java](https://hyojun.tistory.com/entry/프로그래머스-다리를-지나는-트럭-Java)

</div>
</details>

