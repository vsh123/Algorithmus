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

    Comparator<truck> compare = new Comparator<truck>() {
        @Override
        public int compare(truck o1, truck o2) {
            return o2.weight - o1.weight;
        }
    };

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int size=0;
        List<truck> list = new LinkedList<truck>();
        List<truck> now = new LinkedList<truck>();

        for(int i = 0; i < truck_weights.length;i++){
            list.add(new truck(truck_weights[i],0));
        }

        list.sort(compare);

        while(!list.isEmpty()){
            List<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i< list.size();i++){
                if(list.get(i).weight+size<=weight){
                    now.add(new truck(list.get(i).weight,0));
                    temp.add(i);
                    size += list.get(i).weight;
                }
            }
            for(int i =temp.size()-1;i>=0;i--){
                System.out.println("remove : "+ list.get(temp.get(i)).weight + " time :"+time);
                list.remove(temp.get(i));
            }
            for(int i =now.size()-1; i>=0; i--){
                now.get(i).time++;
                if(now.get(i).time==bridge_length){
                    size -= now.get(i).weight;
                    now.remove(i);
                }
            }
            time++;
        }

        System.out.println(time);

        return time;
    }
}
