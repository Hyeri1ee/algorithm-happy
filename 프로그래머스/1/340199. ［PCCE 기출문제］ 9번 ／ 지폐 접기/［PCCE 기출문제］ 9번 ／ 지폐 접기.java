class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true){
            
            
            int target_max = Math.max(bill[0], bill[1]);
            int target_min = Math.min(bill[0], bill[1]);
            int wallet_max = Math.max(wallet[0], wallet[1]);
            int wallet_min = Math.min(wallet[0], wallet[1]);
            
            if (target_max <= wallet_max && target_min <=  wallet_min)
                break;
            
             //갱신
            int temp  = target_max/2;//길이 긴 쪽 반접기
            answer++;
            if (target_max == bill[0])
                bill[0] = temp;
            else
                bill[1] = temp;
        
        }
    
        return answer;
    }
}