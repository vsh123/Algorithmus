import java.util.*;

/*
    문제 : 다리를 지나는 트럭

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42583?language=java

 */

public class Truck {
    class truck{
        int weight;
        int time;

        public truck(int weight,int time){
            this.weight = weight;
            this.time = time;
        }
    }


    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int size=0;
        List<truck> list = new LinkedList<truck>();
        List<truck> list2 = new LinkedList<truck>();

        for(int i = 0; i < truck_weights.length;i++){
            list.add(new truck(truck_weights[i],bridge_length));
        }

        while(true){
            time++;
            if(!list.isEmpty()) {
                truck temp = list.get(0);
                if (temp.weight + size <= weight) {
                    size = temp.weight + size;
                    list2.add(temp);
                    ((LinkedList<truck>) list).removeFirst();
                }
            }
            boolean isend =false;
            for(truck s : list2){
//                System.out.println(time+" "+ s.weight+ " " + s.time );
                s.time--;
                if(s.time==0) {
                    size -= s.weight;
                    isend = true;
                }
            }

            if(isend)
                ((LinkedList<truck>) list2).removeFirst();

            if(list.isEmpty()&&list2.isEmpty())
                break;

        }
        time++;
//        System.out.println(time);

        return time;
    }
}
