import java.util.*;

/*

    문제 : 기능 개발

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42586?language=java

    이슈 사항
        1.

 */

public class FuncDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> ans = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0 ; i<progresses.length; i++){
            int day = (100 - progresses[i])/speeds[i];
            int remain = (100 - progresses[i])%speeds[i];
            if(remain!=0)
                day++;
            q.offer(day);
        }

        while(!q.isEmpty()){
            int s = q.poll();
            int count = 1;
            while(!q.isEmpty()){
                if(q.peek()<=s){
                    q.poll();
                    count++;
                }
                else
                    break;
            }
            ans.add(count);
        }
        answer = new int[ans.size()];
        for(int i = 0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
