package 알고리즘_코딩테스트.dayone.mar31;

public class BOJ_1992 {
    /*
8
1111 0000
1111 0000
0001 1100
0001 1100

11110000
11110000
11110011
11110011


((110(0101))(0010)1(0001))
     */

    static int n;
    static int[][] arr;

    public static void main(String[] args){
        divide(0,7,0,7); //왼쪽,오른쪽,위,아래

    }

    private static void divide(int left, int right, int up, int down){

        int widthx = right-left;
        int widthy = up -down;

        if (widthx == 1 && widthy == 1){
           //issamemath(left,right,up,down);
           return;
        }

        divide(left,(left+right)/2,up, (up+down)/2);
        divide(left+(left+right)/2,right,up, (up+down)/2);
        divide(left,(left+right)/2,up + (up+down)/2, (up+down)/2);
        divide(left+(left+right)/2,right,up + (up+down)/2, (up+down)/2);


    }

    /*private static boolean issamemath(int left, int right, int up, int down) {
        //이중반복문으로 0,1개수로 판별

    }*/
}
