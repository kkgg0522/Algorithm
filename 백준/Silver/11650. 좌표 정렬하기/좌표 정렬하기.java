import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Coordinate> list = new ArrayList<>();

        int repeat_count = Integer.parseInt(br.readLine());
        String[] temp;
        Coordinate coordinate;
        for (int i = 0; i < repeat_count; i++) {
            temp=br.readLine().split(" ");
            coordinate = new Coordinate(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            list.add(coordinate);
        }
        Collections.sort(list,Coordinate::compareTo);
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).toString());
        }
        bw.flush();
    }

    public static class Coordinate implements Comparable<Coordinate> {
        private int x;
        private int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y +"\n";
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x != o.x) {
                return x-o.x;
            } else {
                return y-o.y;
            }
        }
    }
}