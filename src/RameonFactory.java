import java.util.*;
/*

    문제 : 라면공장

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42629?language=java

    이슈 사항
        1. 밀가루가 다 떨어지기 전까지 구입할 수 있는 밀가루의 최대 수량 구하기


 */


public class RameonFactory {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int day=0;
        Queue<Integer> q = new PriorityQueue<Integer>();
        for(int i=1;i<k;i++){
            stock--;
            if(stock==0){
                int max =-1;
                for(int j=day;j<dates.length;j++){
                    if(dates[j]<=i){
                        q.offer(1001-supplies[j]);
                        supplies[j]=0;
                    }
                    else {
                        day = j;
                        break;
                    }
                }
                stock = stock + (1001-q.poll());
                answer++;
            }
        }
        return answer;
    }
}
