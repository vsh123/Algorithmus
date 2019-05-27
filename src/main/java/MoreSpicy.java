import java.util.*;
/*

    문제 : 더 맵게

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42626?language=java

    이슈 사항
        1. 힙을 이용해서는 어떻게 하면 좋을까
            -> 우선순위 큐를 이용하면 편하네......................ㅎ (정렬과 다른점이 있나봄)
 */


public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<Integer>();
        for(int i =0;i<scoville.length;i++){
            q.offer(scoville[i]);
        }
        while(true){
            if(q.peek()>=K)
                return answer;
            if(q.size()<2)
                return -1;
            int first = q.poll();
            int second = q.poll();
            int sum = first +(second*2);
            q.offer(sum);
            answer++;
        }
    }
}
