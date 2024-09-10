package week4.day1;
/*
이진탐색 구현
 */
public class BinarySearch {
  static int [] arr = {1,3,5,7,8,10,20,35,99,100};
  public static void main(String[] args) {
    
    int index = binarySearch(5,0,arr.length-1);

    int index2 = binarySearch2(5,0,arr.length-1);

    System.out.println(index);
    System.out.println(index2);
  }
  
  private static int binarySearch(int key, int low, int high){//재귀적 탐색
    int mid;
    
    if (low <= high){
      mid = (low + high) / 2;
      if (key == arr[mid]) //탐색 성공
        return mid;
      else if (key < arr[mid]){ //왼쪽 부분 arr[0]부터 arr[mid-1]에서의 탐색
        return binarySearch(key, low, mid-1);
      }else{//오른쪽 부분 arr[mid+1]부터 arr[high]에서의 탐색
        return binarySearch(key, mid+1, high);
      }
      
    }
    return -1;//탐색 실패
  }

  private static int binarySearch2(int key, int low, int high){//반복적 탐색
    int mid;

    while(low <= high){
      mid = (low + high) / 2;
      if (key == arr[mid]){
        return mid;
      }else if (key < arr[mid]){
        high = mid-1;
      }else {
        low = mid+1;
      }
    }
    return -1; //탐색 실패
  }
}
