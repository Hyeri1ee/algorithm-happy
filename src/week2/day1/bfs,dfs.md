DFS, BFS :  자료구조에서 완전 탐색을 수행하는 탐색 기법

DFS 를 구현하는 방법에는 2가지가 있다 (스택, 재귀).

BFS 를 구현하는 방법에는 1가지가 있다. (큐).

위 두 그래프의 간선을 저장하는 방법에 2가지가 있다

- 인접 행렬


- 인접 리스트


    <aside>
    🌓 즉, DFS의 경우, 총 4가지 경우로 구현을 할 수 있고
    BFS의 경우, 총 2가지 경우로 구현을 할 수 있다.

    </aside>


---

<aside>
😶 DFS (깊이 우선 탐색)

</aside>

```
1. 시작 정점을 방문
2. 자식을 모두 탐색
3. 이때 연결된 자식 노드가 존재하지 않을 때까지 들어갔다면 다시 되돌아 온다.
4. 되돌아 오는 과정에서 다른 자식 노드가 있다면 방문 후 되돌아 오는 과정을 반복하면서 모든 노드 방문
```

- **DFS 구현 ( 인접리스트 X (재귀,스택))**

```java
package week2.day1.DFS;
import java.util.*;
import java.io.*;

public class DFS_Recursion_List {

  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken()); //노드 개수
    int m = Integer.parseInt(st.nextToken()); //간선 개수
    int v = Integer.parseInt(st.nextToken()); //시작 정점

    LinkedList<Integer> [] edge = new LinkedList[n+1];//연결 리스트를 이용한 간선 저장 2차 배열
    for (int i = 1; i <= n; i++) {//초기화!!!
      edge[i] = new LinkedList<>();
    }
    boolean [] visited = new boolean[n+1];

    for (int i = 0 ; i < m ;i++){
      st = new StringTokenizer(bf.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      edge[v1].add(v2);
      edge[v2].add(v1);
    }
    for (int i = 1; i <= n; i++) {//오름차순으로 정렬
      Collections.sort(edge[i]);
    }
    
    dfs1(edge,visited,v); //재귀로 구현한 dfs
    sb.append("\n\n");
    dfs2(n,edge,visited,v); //스택으로 구현한 dfs

  }

  private static void dfs2(int n, LinkedList<Integer>[] edge,boolean[] visited, int v) {
    Stack<Integer> stack = new Stack<>();
    stack.push(v);
    visited[v] = true;
    sb.append(v +" ");

    while (!stack.isEmpty()) {
      int n = stack.peek();
      boolean flag = false;

      for (int node : edge[n]){
        if (!visited[node]){//방문하지 않았다면
          stack.push(node);
          visited[node] = true;
          flag = true;
          sb.append(node +" ");
          break;
        }
      }
      //방문할 노드가 없다면
      if (flag == false){//이 노드는 더 이상 탐색할 필요가 없으므로 스택에서 제거
        stack.pop();
      }
    }
    
  }

  private static void dfs1(LinkedList<Integer>[] edge, boolean[] visited,int v) {
    visited[v] = true;
    sb.append(v + " ");
    //방문한 노드에서 인접 노드 찾기
    for (int node : edge[v]){
      if (!visited[node])
        dfs1(edge,visited,node);
    }
  }
}

```

- **DFS 구현 ( 인접행렬X (재귀,스택))**

```java
package week2.day1.DFS;
import java.util.*;
import java.io.*;

public class DFS_Array {

  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken()); //노드 개수
    int m = Integer.parseInt(st.nextToken()); //간선 개수
    int v = Integer.parseInt(st.nextToken()); //시작 정점

    int [][] edge = new int[n+1][n+1];//2차 배열
    for (int i = 1; i <= n; i++) {//초기화!!!
      edge[i] = new int[n+1];
    }
    boolean [] visited = new boolean[n+1];

    for (int i = 0 ; i < m ;i++){
      st = new StringTokenizer(bf.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      edge[v1][v2] = edge[v2][v1] = 1;
    }

    dfs1(edge,visited,v); //재귀로 구현한 dfs
    sb.append("\n\n");
    dfs2(edge,visited,v); //스택으로 구현한 dfs

  }

  private static void dfs2(int[][] edge,boolean[] visited, int v) {
    Stack<Integer> stack = new Stack<>();
    stack.push(v);//스택에 들어가면 방문한거임.
    visited[v] = true;//1.visited처리
    sb.append(v +" ");//sb 에 추가

    while (!stack.isEmpty()) {
      int n = stack.peek();
      boolean flag = false;

      for (int node : edge[n]){
        if (!visited[node] && edge[n][node] > 0){//방문하지 않았다면
          stack.push(node);
          visited[node] = true;
          flag = true;
          sb.append(node +" ");
          break;
        }
      }
      //방문할 노드가 없다면
      if (flag == false){//이 노드는 더 이상 탐색할 필요가 없으므로 스택에서 제거
        stack.pop();
      }
    }

  }

  private static void dfs1(int[][] edge, boolean[] visited,int v) {
    visited[v] = true;
    sb.append(v + " ");
    //방문한 노드에서 인접 노드 찾기
    for (int node : edge[v]){
      if (!visited[node])
        dfs1(edge,visited,node);
    }
  }
}

```

<aside>
😶 BFS (너비 우선 탐색)

</aside>

```
1. 시작 정점을 방문
2. 시작 정점에 인접한 모든 정점들을 우선 방문
3. 더 이상 방문 할 정점이 없으면 다음 레벨로 내려간다.
4. 다시 인접한 모든 정점들을 우선 방문
```

- **BFS: 인접 리스트로 구현x큐**

    ```java
    import java.util.*;
    
    public class BFS_List{
    		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	public static void main(String[] args){
    		int n = Integer.parseInt(bf.readLine()); //정점의 개수
    		int m = Integer.parseInt(bf.readLine()); //간선의 개수
    		int v = Integer.parseInt(bf.readLine()); //탐색을 시작할 정점의 번호
    		
    		boolean visited[] = new boolean[n+1]; //방문 여부를 검사할 배열
    		
    		LinkedList<Integer> [] addList = new LinkedList[n+1];
    		
    		for (int i = 0 ; i <= n; i++){
    			addList[i] = new LinkedList<Integer>();
    		}
    		
    		//두 정점 사이에 여러 개의 간선이 있을 수 있다.
    		// 입려긍로 주어지는 간선은 양방향이다.
    		for (int i = 0; i < m ; i++){
    			int v1 = Integer.parseInt(bf.readLine());
    			int v2 = Integer.parseInt(bf.readLine());
    			addList[v1].add(v2);
    			addList[v2].add(v1);
    		}
    		
    		//방문 순서를 위해 오름차순 정렬
    		for (int i = 1 ; i <= n; i++){
    			Collections.sort(addList[i]));
    		}
    		
    		System.out.println("BFS-인접리스트");
    		BFS_list(v, addList, visited);
    	}
    	
    	//BFS-인접리스트
    	public static void bfs_list(int v, LinkedList<Integer>[] addList, boolean[] visited){
    		Queue<Integer> queue = new LinkedList<>();
    		visited[v] = true;
    		queue.offer(v);
    		
    		while(!queue.isEmpty()){
    			v = queue.poll();
    			System.out.println(v + " ");
    			
    			Iterator<Integer> iter =  addList[v].listIterator();
    			
    			while(iter.hasNext()){
    				int w = iter.next();
    				if (!visited[w]){
    					visited[w] = true;
    					queue.offer(w);
    				}
    			}
    		}
    	
    	}
    }
    ```

- **BFS: 인접 행렬(배열)로 구현**

    ```java
    import java.util.*;
    
    public class BFS_Array{
    	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	public static void main(String[] args){
    		int n = Integer.parseInt(bf.readLine); //정점의 개수
    		int m = Integer.parseInt(bf.readlLine); //간선의 개수
    		int v = Integer.parseInt(bf.readLine); //탐색을 시작할 정점의 번호
    		
    		boolean visited[] = new boolean[n+1]; //방문 여부를 담을 배열
    		
    		int [][] array = new int[n+1][n+1];
    		
    		//두 정점 사이에 여러개의 간선이 있을 수 있다.
    		//입력으로 주어지는 간선은 양방향이다.
    		for (int i = 0 ; i < m; i++){
    			int v1 = Integer.parseInt(bf.readLine);
    			int v2 = Integer.parseInt(bf.readLine);
    			
    			array[v1][v2] = 1;
    			array[v2][v1] = 1;
    			
    		}
    		System.out.println("BFS-인접행렬");
    		bfs_array(v, array, visited);
    	}
    	
    	//BFS - 인접행렬
    	public static void bfs_array(int v, int[][] array, bolean[] visited){
    		Queue<Integer> q = new Linkedlist<>();
    		int n = array.length - 1;
    		
    		q.offer(v);
    		visited[v] = true;
    		
    		while(!q.isEmpty()){
    			v = q.poll();
    			System.out.print(v + " ");
    			
    			for (int i = 1; i<= n; i++){
    				if (array[i] == 1 && !visited[i]){
    					q.offer(i);
    					visited[i] = true;
    				}
    			}
    		}
    	}
    }
    ```


<aside>
😶 DFS VS BFS

</aside>

시간복잡도 (DFS, BFS)

- 인접행렬 → T(n) = n x O(n) = O(n^2), 인접 리스트 → T(n) = O(n+e)


DFS

- 장점
    - 최선의 경우 가장 빠른 알고리즘. 운좋게 해에 도달하는 올바른 경로를 선택하면, 최소 실행시간에 해를 찾는다.
    - BFS에 비해 저장공간의 필요성이 적다. 백트래킹 해야하는 노드들만 저장해주면 된다
- 단점
    - 찾은 해가 최적이 아닐 가능성이 있다

BFS

- 장점
    - 너비를 우선으로 탐색하기 때문에 답이 되는 경로가 여러개인 경우에도 최단 경로를 보장
- 단점
    - 최소 실행시간보다 오래 걸림
- 출처

  [[Java] DFS, BFS 정리](https://bbangson.tistory.com/42)

  [[Java] BFS 너비 우선 탐색 - 인접리스트 / 인접행렬로 구현](https://minhamina.tistory.com/36)

  [[Java] DFS & BFS](https://velog.io/@jeongbeom4693/Java-DFS-BFS)