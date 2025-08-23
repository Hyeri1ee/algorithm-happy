

import java.util.*;
import java.io.*;
/*
짚고 넘어갈거

Comparable vs comparator
StringTokenzier 선언 위치
nextint, st.nexttoken 혼재할때
 */
//머리 아플때 구현 (2/3)
public class Main {
    static class Player implements Comparable<Player>{
        int level;
        String nickname;
        public Player(int le, String ni){
            this.level =le;
            this.nickname = ni;
        }

        @Override//닉네임 사전순
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }
    static class room{
        int firstlevel; //처음입장한 플레이어 레벨
        static int num; //방 한개의 정원
        ArrayList<Player> playersin; //들어온 player

        public room(int f){
            this.firstlevel = f;
            playersin = new ArrayList<>();
        }

        public void add(Player p){
            this.playersin.add(p);
        }

        public boolean isFull(){
            return (num == this.playersin.size());
        }

        public void print(){
            StringBuilder sb = new StringBuilder();
            if (isFull()){
                sb.append("Started!\n");
            }else{
                sb.append("Waiting!\n");
            }
            Collections.sort(playersin);//사전순 정렬
            for(Player p : playersin){
                sb.append(p.level +" " + p.nickname +"\n");
            }

            System.out.print(sb);
        }

    }

    static int p, m; //플레이어 수, 방의 정원
    static Player[] players; //플레이어 입력값 저장
    static ArrayList<room> rooms = new ArrayList<>(); //만들어진 방 정보

    public static void main(String[] args) throws IOException{
        input();
        //출력
        for(room r : rooms){
            r.print();
        }
    }

    private static void input()throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        players = new Player[p];
        room.num = m;


        for(int i = 0 ; i < p;i++){
            st = new StringTokenizer(bf.readLine());
            players[i]=new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            //rooms에 배정
            if (rooms.isEmpty())
            {
                rooms.add(new room(players[i].level));//rooms에 room하나 생성
                rooms.get(0).playersin.add(players[i]);//생성한 room에 플레이어 추가
            }else{
                boolean entered= false;
                for(int j = 0 ; j < rooms.size(); j++){//만들어진 방중에 입장 가능한 방 있는지 확인
                    if (canEnter(rooms.get(j), players[i])){

                        rooms.get(j).add(players[i]);
                        entered = true;
                        break;

                    }else{//들어갈 수 없음
                        continue;
                    }
                }

                if (!entered){//어디에도 들어갈 수 없으면 방 새로 만들기
                    rooms.add(new room(players[i].level));//rooms에 room하나 생성
                    rooms.get(rooms.size()-1).playersin.add(players[i]);//생성한 room에 플레이어 추가
                }
            }
        }



    }

    private static boolean canEnter(room r, Player p){
        //room의 현재 인원 봐야함
        boolean notFull = ! r.isFull();

        //room 처음 입장 플레이어 기준으로 -10, +10까지 입장 가능
        boolean correctLevel = Math.abs(r.firstlevel  - p.level) <= 10;

        return notFull &&  correctLevel;
    }

}
