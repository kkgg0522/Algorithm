class Solution {    
   static char[][] parks;
    static int[] current;

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        current = new int[]{-1,-1};

        parksMap(park);

        for (String route : routes) {
            String[] currentRoute = route.split(" ");
            int n = Integer.parseInt(currentRoute[1]);

            switch (currentRoute[0]) {
                case "N":
                    moveN(n * -1);
                    break;
                case "S":
                    moveS(n);
                    break;
                case "W":
                    moveW(n * -1);
                    break;
                case "E":
                    moveE(n);
                    break;
            }
        }
        answer = current;
        return answer;
    }

    private void moveN(int n){
        for(int i=0; i>n; i--){
            if(!(isParkOutY(current[0]+(i-1))&&isObstacleY(current[0]+(i-1)))){
                return;
            }
        }
        current[0] += n;
    }

    private void moveS(int n){
        for(int i=0; i<n; i++){
            if(!(isParkOutY(current[0]+(i+1))&&isObstacleY(current[0]+(i+1)))){
                return;
            }
        }
        current[0] += n;
    }



    private void moveE(int n){
        for(int i=0; i<n; i++){
            if(!(isParkOutX(current[1]+(i+1))&&isObstacleX(current[1]+(i+1)))){
                return;
            }
        }
        current[1] += n;
    }

    private void moveW(int n){
        for(int i=0; i > n; i--){
            if(!(isParkOutX(current[1]+(i-1))&&isObstacleX(current[1]+(i-1)))){
                return;
            }
        }
        current[1] += n;
    }




    // x, y 가 아닌 y, x
    private void parksMap(String[] park){
        parks = new char[park.length][park[0].length()];

        for(int i=0; i<parks.length; i++){
            parks[i] = park[i].toCharArray();
            if(current[0]==-1) {
                for (int j = 0; j < parks[0].length; j++) {
                    if (parks[i][j] == 'S') {

                        current[0] = i;
                        current[1] = j;
                        break;
                    }
                }
            }
        }
    }

    private boolean isParkOutX(int x){
        try{char out = parks[current[0]][x];

            if(out == 'X'){
                return false;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }

        return true;
    }

    private boolean isParkOutY(int y){
        try{
            char out = parks[y][current[1]];
            if(out == 'X'){
                return false;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }

    private boolean isObstacleX(int x){
        return parks[0].length > x && x >= 0;
    }

    private boolean isObstacleY(int y){
        return (parks.length > y) && (0 <= y);
    }

}