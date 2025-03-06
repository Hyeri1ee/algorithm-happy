package 알고리즘_코딩테스트.dayone.mar04;

import java.io.*;
import java.util.*;

class Meeting{
    int starttime;
    int endtime;

    public Meeting(int starttime, int endtime){
        this.starttime = starttime;
        this.endtime = endtime;
    }
}

public class BOJ_1931 {

    static int n;
    static ArrayList<Meeting> meetingList;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        //회의의 수 n 값 입력
        n = Integer.parseInt(bf.readLine());
        meetingList = new ArrayList<>();


        //회의 n개 시작시간 , 종료시간 입력
        for (int i = 0 ;  i < n ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetingList.add(new Meeting(start, end));
        }

        // 종료시간이 이른 순으로 정렬
        Collections.sort(meetingList, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.endtime == o2.endtime){//종료시간이 같은 경우, 시작시간 기준으로 오름차순
                    return o1.starttime - o2.starttime;
                }
                return o1.endtime - o2.endtime; //종료시간 기준으로 오름차순
            }
        });

        int count = 0;
        int currentendtime = 0;
        for (Meeting meeting : meetingList){
            if (currentendtime <= meeting.starttime){
                currentendtime = meeting.endtime;
                count++;
            }
        }
        System.out.println(count);
    }


}
