class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean can = true;
        int cur1 = 0 ;
        int cur2 = 0;
        int turn = 1;
        
        
            for(String target : goal){
                
                String compare2 = "";
                String compare1 = "";
                
                if (cur2 >= cards2.length)
                    compare2 = "";
                else
                    compare2 = cards2[cur2];
                
                 if (cur1 >= cards1.length)
                    compare1 = "";
                else
                    compare1 = cards1[cur1];
                
                int isin = check(target, compare1, compare2);
                
                if (isin == 1) cur1++;
                else if (isin == 2)
                    cur2++;
                else
                {
                    can = false;
                    break;
                }
            }
        
        
        String answer = (can) ? "Yes" : "No";
        return answer;
    }
    
    private static int check(String t, String w1, String w2){
        if (t.equals(w1)) return 1;
        else if (t.equals(w2)) return 2;
        else return 3;
    }
}