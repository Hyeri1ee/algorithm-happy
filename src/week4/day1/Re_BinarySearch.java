package week4.day1;
/*
이진 탐색 : 상한 , 하한
 */
public class Re_BinarySearch {

  static int[] arr = new int[10];

  //하한 LowerBound
  /*
  <key 이상 값이 처음으로 나오는 index 구하기>
  key 가 모든 값보다 크다면 배열 길이가 리턴
   */
  static int getLowerBound(int key){
    int low = 0;
    int high = arr.length;
    while(low < high){
      int mid = (low + high) / 2;
      if (key <= arr[mid]) {
        //처음으로 key와 동일하거나 이상을 찾아야 한다 = mid를 포함하여 범위를 줄인다
        high = mid;
      }else{
        //arr[mid] < key 이기 때문에 범위에 mid는 포함되지 않는다
        low = mid + 1;
      }
    }
    //low와 high 동일해서 아무거나 반환
    return low;
  }

  //상한 UpperBound
  /*
  <key 보다 큰 값이 처음으로 나오는 index 구하기>
  key 가 모든 값보다 크면 배열 길이 리턴
   */
  static int getUpperBound(int key){
    int low = 0;
    int high = arr.length;

    while(low < high){
      int mid = (low + high) / 2;
      if (key < arr[mid]){
        //처음으로 key 보다 큰 값을 찾아야 한다
        //key 와 mid 값이 동일한 경우를 제외하여 범위를 줄인다
        high = mid;
      }else{
        low = mid + 1;
      }
    }
    return low;
  }

}
