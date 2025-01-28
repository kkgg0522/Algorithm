class Solution {
    static String public_video_len="";
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        public_video_len = video_len;
        if(nextIf(pos,op_start,op_end)){
            pos = op_end;
        }
        for(int i=0; i < commands.length; i++){
            String command = commands[i];
            switch(command){
                case "prev": 
                    pos = prev(pos);
                    break;
                case "next":      
                    pos = next(pos);
                    break;
            }
            if(nextIf(pos,op_start,op_end)){
                        pos = op_end;
                    }
            
        }
        return pos;
    }

    private String prev(String pos){
        int[] time = convertTime(pos);

        if(time[0]==0 && time[1]<=10){ //조건 검사 00:10초보다 작으면 0초로
            time[1] = 0;
            return convertString(time);
        }


        time[1] -= 10;

        if(time[1]<0){
            time[0]--;
            time[1]+=60;
        }

        return convertString(time);
    }


    private String next(String pos){
        int[] time = convertTime(pos);
        
        if(currentBigVideoLen(time)){
            return public_video_len;
        }

        time[1] += 10;

        if(time[1]>=60){
            time[0]++;
            time[1]%=60;
        }

        return convertString(time);
    }


    private boolean currentBigVideoLen(int[] pos){
        String video_len = public_video_len;
        int lenEndTime = convertInt(convertTime(video_len));
        int lenStartTime = convertInt(convertTime(prev(video_len)));

        int posIf = convertInt(pos);

        if((posIf >= lenStartTime && posIf <= lenEndTime) || posIf >= lenEndTime){
            return true;
        }
        return false;
    }


    private boolean nextIf(String pos, String op_start, String op_end){
        int posIf = convertInt(convertTime(pos));
        int opStartTime = convertInt(convertTime(op_start));
        int opEndTime = convertInt(convertTime(op_end));


        if(posIf >= opStartTime && posIf <= opEndTime){
            return true;
        }
        return false;
    }

    private int convertInt(int[] time){
        String strTime;
        if(time[1] < 10){
            strTime = time[0] * 10 + "" + time[1];
        }else {
            strTime = time[0]+ "" + time[1];
        }
        return Integer.parseInt(strTime);
    }

    private int[] convertTime(String time){
        String[] times = time.split(":") ;
        int[] realTimes = new int[times.length];
        for(int i=0; i<times.length; i++){
            realTimes[i] = Integer.parseInt(times[i]);
        }
        return realTimes;
    }


    private String convertString(int[] times){
        String time1;
        String time2;
        if(times[0]<=9){
            time1 = "0" + times[0] + ":";
        }else{
            time1 = "" + times[0] + ":";
        }

        if(times[1]<=9){
            time2 = "0" + times[1];
        }else{
            time2 = "" + times[1];
        }

        return time1 + time2;
    }
}