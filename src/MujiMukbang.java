import java.util.*;
/*

    문제 : 무지의 먹방 라이브

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42891?language=java

    이슈 사항
        1. 자바공부 필요 (Comparator 등)

 */

public class MujiMukbang {
    class Food{
        int time;
        int idx;
        Food(int t, int i){
            time = t;
            idx = i;
        }
    }

    Comparator<Food> CompTime = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.time-o2.time;
        }
    };

    Comparator<Food> CompIdx = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.idx-o2.idx;
        }
    };

    public int solution(int[] food_times, long k){
        int answer = 0;
        List<Food> foods = new LinkedList<Food>();
        int n = food_times.length;

        for(int i = 0; i < n; i++){
            foods.add(new Food(food_times[i],i+1));
        }

        foods.sort(CompTime);

        int pretime = 0;
        int i = 0;
        for(Food f : foods){
            long diff = f.time - pretime;
            if(diff!=0){
                long spend = diff * n;
                if(spend <= k){
                    k-=spend;
                    pretime = f.time;
                }
                else{
                    k%=n;
                    foods.subList(i, food_times.length).sort(CompIdx);
                    return foods.get(i+(int)k).idx;
                }
            }
            i++;
            n--;
        }
        return -1;
    }
}
