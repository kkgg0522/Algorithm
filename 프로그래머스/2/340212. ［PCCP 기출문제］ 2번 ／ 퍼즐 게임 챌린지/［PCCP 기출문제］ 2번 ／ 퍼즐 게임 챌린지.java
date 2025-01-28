import java.util.*;

class Solution {
      public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        int left = Arrays.stream(diffs).min().getAsInt();
        int right = Arrays.stream(diffs).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if(isClear(diffs, times, limit, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
            answer=right;
            return answer;
    }

    private boolean isClear(int[] diffs, int[] times, long limit, int mid){

        long clearTime = times[0];

        for (int i = 1; i < times.length; i++) {
            clearTime += times[i] + ((long)(times[i]+times[i-1]) * clearPuzzleValue(diffs[i], mid));
            if(isLimit(clearTime, limit)){
                return false;
            }
        }
        return true;


    }

    private int clearPuzzleValue(int diff, int level) {
        return (diff <= level) ? 0 : diff - level;

    }

    private boolean isLimit(long clearTime, long limit) {
        return clearTime > limit;
    }
}

/*
diff <= level 안틀림
diff > level diff-level 만큼 틀림 
현재 퍼즐의 난이도를 diff, 
현재 퍼즐의 소요 시간 = time_cur, 
이전 퍼즐의 소요 시간 == time_prev, 
숙련도 = level (리턴할 값)  */