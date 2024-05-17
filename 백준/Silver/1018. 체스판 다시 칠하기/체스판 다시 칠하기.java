import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static char[][] board;
    static int count;

    static char stan_change(char x){
       if(x=='W')
           return 'B';
       else
           return 'W';
    }

    static int board_cutting(char[][] boards){
        int b_count=0;
        int w_count=0;
        char bStart='B';
        char wStart='W';
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(boards[i][j]!=bStart)
                    b_count++;
                if(boards[i][j]!=wStart)
                    w_count++;
                if(j==7) continue;
                bStart=stan_change(bStart);
                wStart=stan_change(wStart);
            }
        }

        return Math.min(b_count, w_count);
    }


    static char[][] cutting_array(int m, int n){
        char[][] temp_array = new char[8][8];
        int m_start = m - 7;
        int n_start = n - 7;
        for (int i = m_start; i <= m; i++) {
            for (int j = n_start; j <= n; j++) {
                temp_array[i-m_start][j-n_start]=board[i][j];
            }
        }
        return temp_array;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().trim().split(" ");
        int m = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);

        board = new char[m][n];
        for (int i = 0; i < m; i++) {
            board[i] = br.readLine().trim().toCharArray();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 7; i < m; i++) {
            for (int j = 7; j < n; j++) {
                if(i==8&&j==21)
                    count++;
                list.add(board_cutting(cutting_array(i,j)));
            }
        }

        Collections.sort(list);
        System.out.print(list.get(0));
    }
} 
