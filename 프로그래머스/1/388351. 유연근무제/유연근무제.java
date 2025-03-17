class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int sun = 7 - startday;
        int sat;
        
        if(startday == 0){
            sun = 6;
        }
        
        if(sun == 0){
            sat = 6;
        }else{
            sat = sun - 1;
        }
        for(int i=0; i<schedules.length; i++){
            int time = schedules[i] + 10;
            int minu = time % 100;
            int hour = time / 100;
            if(minu > 59){
                minu = minu % 60;
                hour++;
            }
            hour = hour % 24;
            time = (hour*100) + minu;
            
            int count = 5;
            for(int j=0; j<timelogs[0].length; j++){
                if(j==sat || j == sun){
                    continue;
                }
                
                if(timelogs[i][j] <= time){
                    count--;
                }
            }
            
            if(count == 0){
                answer++;
            }
        }
        return answer;
    }
}