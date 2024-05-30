import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char row_char = '|';
    static char column_char = '-';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int row_num = Integer.parseInt(st.nextToken());
        int column_num = Integer.parseInt(st.nextToken());

        int rowCharCount = 0;
        int columnCharCount = 0;
        boolean start=false;

        char[][] matrix = new char[row_num][column_num];


        for (int i = 0; i < row_num; i++) {
            String line = br.readLine();
        for (int j = 0; j < column_num; j++) {
                matrix[i][j] = line.charAt(j);
                if(matrix[i][j]=='-'&&!start){
                    columnCharCount++;
                }
                if(matrix[i][j]=='-'){
                    start = true;
                } else{
                    start = false;
                }
            }
            start = false;
        }


        for (int j = 0; j < column_num; j++) {
            for (int i = 0; i < row_num; i++) {
                if(matrix[i][j]=='|'&&!start){
                    rowCharCount++;
                }
                if(matrix[i][j]=='|'){
                    start = true;
                } else{
                    start = false;
                }
            }
            start = false;
        }

        System.out.println(rowCharCount+columnCharCount);


    }

}

