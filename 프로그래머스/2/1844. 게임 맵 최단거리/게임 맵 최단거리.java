import java.util.*;

class Solution {
    static int answer = -1; // 우측하단에 도착하지못할경우 -1출력
    public int solution(int[][] maps) {
        bfs(maps);
        
        return answer;
    }
    static void bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visit = new boolean[n][m];
        
        Queue<int[]> que = new LinkedList<>();
        
        que.offer(new int[]{0,0,1});
        int[] areaX = new int[]{-1, 1, 0, 0};
        int[] areaY = new int[]{0, 0, -1, 1};
        while(!que.isEmpty()){
            int[] tmp = que.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            
            if(x==n-1&&y==m-1){
                answer = count;
                return;
            }
            
            for(int i=0; i<areaX.length; i++){
                int cx = x+areaX[i];
                int cy = y+areaY[i]; 
                if((cx>=0&&cx<n)&&cy>=0&&cy<m){
                    if(!visit[cx][cy]&&maps[cx][cy]==1){
                        que.offer(new int[]{cx,cy, count+1});
                        visit[cx][cy] = true;
                    }
                }
            }       
        }
        return;
    }
}