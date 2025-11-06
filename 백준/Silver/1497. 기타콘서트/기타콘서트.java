import java.util.*;
import java.io.*;
/*
22% 오류 : 곡의 개수가 최대 50까지 되기 때문에 이를 비트마스킹으로 최악의 경우, 32비트 32곡
long으로 대체하면 최대 64곡.
제한 없으려면 BigInteger
 */
public class Main {
    static int n, m;//기타 개수, 곡 개수
    static HashMap<String, Long> musicmap = new HashMap<>();

    //input
    static BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args)throws Exception{
        input();
        solve();
    }
    private static void solve(){
        String[] guitars = musicmap.keySet().toArray(new String[0]);
        long[] bitarr = Arrays.stream(guitars)
                .mapToLong(musicmap::get)
                .toArray();

        int minCount = Integer.MAX_VALUE;
        int maxSongCount = 0;

        int size = (1 << n);//16
        for(int subset = 1; subset < size; subset++){//subset 은 기타 선택 조합
            long combined = 0;


            for(int i = 0 ; i < n ; i++){
                if ((subset & (1 << i)) != 0){//해당 기타를 고른 경우
                    combined |= bitarr[i];
                }
            }

            int songCount = Long.bitCount(combined);//연주할 수 있는 곡 개수
            int count = Integer.bitCount(subset);//선택한 기타 개수 -> 출력


            if (songCount > maxSongCount) {//가능한 많은 곡  연주해야함
                maxSongCount = songCount;
                minCount = count;
            } else if (songCount == maxSongCount && count < minCount) {//곡 개수가 같을 때엔 최소 기타 개수로 연주해야함
                minCount = count;
            }



        }

        if (maxSongCount == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(minCount);




    }
    private static void input() throws Exception{
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i =0 ;i < n; i++){
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();

            long num = 0L;
            for(char ch : st.nextToken().toCharArray()){
                num = (num << 1)|(ch == 'Y' ? 1 : 0); //1칸 왼쪽으로 밀고 LSB에 1 혹은 0 넣기
                //디버깅용
                //System.out.println(Integer.toBinaryString(num));
            }

            musicmap.put(name, num);



        }
    }

}
