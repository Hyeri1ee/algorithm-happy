
import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList[] sugangbaguni;
    static int[] limit; //남은 리밋
    static boolean[] possible1;  // 1차 수강신청 성공 여부
    static boolean[] possible2;  // 2차 수강신청 성공 여부
    static Set[] result;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // n(학생수), m(과목수) 입력받기
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // m개의 과목 정원 입력받기
        st = new StringTokenizer(bf.readLine());
        sugangbaguni = new ArrayList[m + 1];
        result = new Set[m+1];
        limit = new int[m + 1];
        possible1 = new boolean[m + 1];
        possible2 = new boolean[m + 1];

        for (int i = 1; i < m + 1; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
            sugangbaguni[i] = new ArrayList<>();
            possible1[i] = true;  // 초기에는 모든 과목 신청 가능
            possible2[i] = true;
        }

        // 1차 수강바구니
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(bf.readLine());

            while (st.hasMoreTokens()) {
                int go = Integer.parseInt(st.nextToken());
                if (go == -1)
                    break;
                if (limit[go] > 0) {
                    sugangbaguni[go].add(i);//학생 번호 넣기
                    limit[go]--;

                } else {
                    possible1[go] = false; //go 과목 수강바구니 터짐
                }
            }
        }
        //suganbaguni 배열을 result 에 복사
        for (int i = 1; i <= m; i++) {
            result[i] = new HashSet();
            if (possible1[i])
                result[i].addAll(sugangbaguni[i]);
        }
        //수강바구니 초기화
        for (int i = 1 ; i <m+1;  i++)
            sugangbaguni[i].clear();
        // 2차 수강바구니
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(bf.readLine());

            while (st.hasMoreTokens()) {
                int go = Integer.parseInt(st.nextToken());
                if (go == -1)
                    break;
                if (limit[go] > 0 ) {
                    sugangbaguni[go].add(i);//학생 번호 넣기
                    limit[go]--;

                } else {
                    possible2[go] = false; //go 과목 수강바구니 터짐
                }
            }
        }

        //suganbaguni 배열을 result 에 복사
        for (int i = 1; i <= m; i++) {
            if (possible2[i])
                result[i].addAll(sugangbaguni[i]);
        }

        // 결과 출력
        for (int i = 1; i < n + 1; i++) {
            boolean exist = false;
            for (int j = 1; j < m + 1; j++) {
                // 1차 또는 2차 수강신청에서 성공한 경우
                if (result[j].contains(i)) {
                    sb.append(j).append(" ");
                    exist = true;
                }
            }
            if (!exist) {
                sb.append("망했어요");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
