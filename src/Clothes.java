import java.util.*;
/*

    문제 : 위장

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42578?language=java

    이슈 사항
        1.

 */

public class Clothes {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],map.get(clothes[i][1])+1);
            }
            else{
                map.put(clothes[i][1],1);
            }
        }
        for(String key : map.keySet()){
            answer *= (map.get(key)+1);
        }
        return answer-1;
    }
}
