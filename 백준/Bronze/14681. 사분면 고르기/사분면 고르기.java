import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        boolean x_bool;
        boolean y_bool;

        if(x>0){
            x_bool=true;
        }else{
            x_bool=false;
        }

        if(y>0){
            y_bool=true;
        }else {
            y_bool=false;
        }


        if(x_bool && y_bool){
            System.out.println("1");
        } else if(!x_bool && y_bool){
            System.out.println("2");
        } else if(x_bool){
            System.out.println("4");
        } else{
            System.out.println("3");
        }

    }

}

