import java.util.*;
/*

    문제 : 구명보트

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42885?language=java

    이슈 사항
        1. 무게가 40 ~ 240 사이라는걸 이용

*/


public class Boat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int[] count = new int[250];
        int pcount=0;
        for(int i =0;i<people.length;i++){
            count[people[i]]++;
        }

        for(int i =0;i<people.length;i++){
            int x = people[i];
            if(count[x]>0){
                System.out.print(x+" and ");
                count[x]--;
                pcount++;
                int num = limit - x;
                for(int j =num;j>=40;j--){
                    if(count[j]>0){
                        System.out.println(j);
                        count[j]--;
                        pcount++;
                        break;
                    }
                }
                answer++;
            }
            if(pcount == people.length)
                break;
        }

        return answer;
    }
}
