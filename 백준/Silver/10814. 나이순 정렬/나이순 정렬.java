import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Human implements Comparable<Human> {
        int seq;
        int age;
        String name;
        static int sqeence = 0;
        public Human(int age, String name) {
            this.age = age;
            this.name = name;
            this.seq = sqeence++;
        }
        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Human o) {
            if(this.age == o.age)
                return this.seq - o.seq;

            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Human> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            Human hu = new Human(Integer.parseInt(st.nextToken()),st.nextToken());
            list.add(hu);
        }

        Collections.sort(list);

        for(Human h : list)
            System.out.println(h.toString());
    }
}