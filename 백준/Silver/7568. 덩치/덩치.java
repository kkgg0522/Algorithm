import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<Human,Integer> map = new LinkedHashMap<>();
        int n = sc.nextInt();
        ArrayList<Human> humans = new ArrayList<>();
        int count;
        for (int i = 0; i < n; i++) {
            int kg=sc.nextInt();
            int cm=sc.nextInt();
            humans.add(new Human(kg,cm));
        }

        for (int i = 0; i < n; i++) {
            count=1;
            for (int j = 0; j < n; j++) {
                if(ranked(humans.get(i),humans.get(j)))
                    count++;

            }
            map.put(humans.get(i),count);
        }
        for(Map.Entry<Human,Integer> entry:map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }

    }

    static class Human{
        private int cm;
        private int kg;

        public Human(int cm, int kg){
            this.cm = cm;
            this.kg = kg;
        }

        public int getCm() {
            return cm;
        }

        public int getKg() {
            return kg;
        }

        @Override
        public String toString() {
            return getKg() + " " + getCm();
        }
    }

    static boolean ranked(Human h1, Human h2){
        return h1.getCm()<h2.getCm()&&h1.getKg()<h2.getKg();
    }
}