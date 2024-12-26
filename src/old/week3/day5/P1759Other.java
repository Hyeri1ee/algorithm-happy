package old.week3.day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759Other {
  public static int L,C;
  public static char[] list;
  public static char[] code;

  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(bf.readLine());

    L = Integer.parseInt(st.nextToken());
    C= Integer.parseInt(st.nextToken());

    list = new char[C];
    code = new char[L];

    st = new StringTokenizer(bf.readLine());

    for (int x = 0 ;x < C ;x++){
      list[x] = st.nextToken().charAt(0);
    }

    Arrays.sort(list);
    makeCode(0,0);


  }
  public static void makeCode(int x, int idx){
    if (idx == L){
      if (isValid()){
        System.out.println(code);
      }
      return;
    }
    for (int i = x; i < C; i++) {//for문에서 i 값이 변화하면, 그 전 list[i] 값들은 안 넣는 것으로 자동 백트래킹
      code[idx] = list[i];
      makeCode(i+1, idx + 1);
    }
  }

  public static boolean isValid() {
    int mo = 0;
    int ja = 0;

    for (char x : code) {
      if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
        mo++;
      } else {
        ja++;
      }
    }

    if (mo >= 1 && ja >= 2) {
      return true;
    }
    return false;
  }
}
