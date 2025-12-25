class Solution {
    int video_len_, pos_, op_start_, op_end_;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        
        //초기화
        video_len_ = change(video_len);
        pos_ = change(pos);
        op_start_ = change(op_start);
        op_end_ = change(op_end);
        
        int answer = pos_;
         System.out.println("[answer (시작)] : " + answer);
        
        for (String command : commands){
            //opstart - opend 사이에 있는지 보기
            if (isbetween (answer, op_start_, op_end_)){//사이에 있으면
                answer = op_end_;
                System.out.println("[answer (사이)] : " + answer);
            }
            
            //command수행
            switch(command){
                case ("next"):
                {
                    answer = (answer + 10 > video_len_) ?  video_len_ : answer + 10;
                    break;
                }
                case ("prev"):
                {
                    answer = (answer - 10 < 0) ? 0 : answer - 10;
                    break;   
                }
                    
                    
            }
            
             System.out.println("[answer] : " + answer);
            
            
            
        }
        //마지막 command 시
        if (isbetween (answer, op_start_, op_end_)){//사이에 있으면
                answer = op_end_;
        }
        //문자로 바꿔주기
        String mm_f = ""; 
        String ss_f = "";
        int mm = answer / 60;
        int ss = answer % 60;
        if (mm < 10)
            mm_f = "0" + mm +"";
        else
            mm_f = mm+"";
        
        if (ss < 10)
            ss_f = "0" + ss +"";
        else
            ss_f = ss+"";
        
        
            
        String result = mm_f + ":" + ss_f;
        return result;
    }
    
    private static boolean isbetween (int target, int s, int e){
        return s <= target && target <= e;
    }
    
    private static int change(String s){
        String[] p = s.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }
}