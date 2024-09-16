# 시간 줄이는 법

---

<aside>
😮

이진탐색(=이분탐색)

</aside>

이진탐색은 탐색 범위를 반으로 나누어 찾는 값을 포함하는 범위를 좁혀가는 방식으로 동작한다.

반드시 원소들이 일정한 순서로 정렬된 구조에서만 사용될 수 있음.

> 설계
>
>
>
> 1-1. 배열에서의 동작방식(반복문)
>
> <aside>
> 😶‍🌫️
>
> 1. 정렬된 배열에서 중간 인덱스(mid)를 찾는다.
> 2. 찾으려는 값(target)과 중간 값(mid_val)을 비교한다.
> 3. target이 mid_val보다 작으면 mid를 기준으로 왼쪽 부분 배열을 탐색한다.target이 mid_val보다 크면 mid를 기준으로 오른쪽 부분 배열을 탐색한다.
> 4. 탐색 범위를 반으로 줄인다.
> 5. 탐색 범위가 더 이상 없을 때까지 위 과정을 반복한다.
> </aside>
>
> ```java
> function binarySearch(arr, target){
> int left = 0;
> int right = arr.length -1;
> while(left <= right){
> 	int mid = Math.floor((left + right)/2);
> 	if (arr[mid] == target)
> 		return mid;
> 	else if (arr[mid] < target){
> 		left = mid + 1;
> 	else
> 		right = mid - 1;
> }
> return -1; //일치하는 값이 없으면 -1 반
> }
> ```
>
> 1-2. 배열에서의 동작방식(재귀함수)
>
> ```java
> int binarySearch(int arr[], int low, int high, int key){
> 	if (low > high) //종료 조건 2: 검색 실패
> 		return -1;
> 	int mid = low + (high-low)/2;
> 	if (arr[mid] == key) //종료 조건 1: 검색 성공
> 		return mid;
> 	else if (arr[mid] > key)
> 		return binarySearch(arr, low, mid-1,key);
> 	else
> 	return binarySearch(arr, mid+1, high, key);
> }
> ```
>
> 2-1. 트리에서의 동작방식(순환적인 탐색 연산)
>
> <aside>
> 😶‍🌫️
>
> 1. 트리에서 중간 노드를 찾는다.
> 2. 찾으려는 값과 중간 노드의 값과를 비교한다.
> 3. 찾으려는 값이 중간 노드의 값보다 작으면 왼쪽 하위 트리에서 탐색을 계속한다.찾으려는 값이 중간 노드의 값보다 크면 오른쪽 하위 트리에서 탐색을 계속한다.
> 4. 탐색 범위를 반으로 좁힌다.
> 5. 탐색 범위가 더 이상 없을 때까지 위 과정을 반복한다.
> </aside>
>
> ```java
> TreeNode* search(TreeNode* node, int key){
> 	Treenode* p = node;
> 	if (node == NULL) return NULL; //탐색 실패한 경우 마지막 노드까지 도달
> 	if(key == node->data) return node;//탐색 성공한 경우 해당 노드 주소 반환
>   else if (key > node -> data) 
> 	  search(node->right, key);
> 	else
> 		search(node->left, key);
> 		}
> 		}
> ```
>
> 2-2. 반복적인 탐색 연산
>
> ```java
> 
> TreeNode* search2(TreeNode* node, int key){
> 	getu(node != NULL){
> 			if(key == node-> data) reutrn node;
> 			else if (key < node -> data)
> 				node = node -> left;
> 			else
> 				node = node -> right;
> 				}
> 				return NULL;
> }
> 	
> ```

##### 이진 탐색 상한, 하한

```
[3. 단순한 이진 탐색 시 문제점]

배열: {1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 6} 에서

 

3 을 찾고자 할 때, 

중간 값(index: lo 와 hi 의 가운데) 을 기준으로 3 이 어느쪽에 오는지 확인하는데,

중간 값이 아래와 같을 시, 적절히 다음 작업을 진행하는데,

3 보다 크면, 하위 구간에서 
3 보다 작으면 상위 구간에서 
같으면 발견한 것
문제는 발견한 경우 이 index 가 항상 같은 값 중 정렬 상 가장 앞서는 인덱스가 아닐 수 있다는 것이다.

등호가 있으면, 하한 값을 찾는 것이고
등호가 없으면, 상한 값을 찾는 것이다.
- 참고 : Re_BinarySearch.java
```



---

<aside>
😮

DP (동적 계획법)

</aside>

복잡한 문제를 더 작은 하위 문제로 나누어 해결하는 알고리즘 설계 기법

- DP와 재귀적 호출의 차이점
    - 재귀적 호출은 하향식 (top-down) 접근 방식을 사용합니다. 큰 문제를 작은 하위 문제로 나누어 해결하는 방식입니다.
    - DP는 상향식(bottom-up) 접근방식으로 작은 하위문제들 부터 시작하여 그 결과를 저장하고, 이를 이용하여 점진적으로 큰 문제의 해를 구해나갑니다.