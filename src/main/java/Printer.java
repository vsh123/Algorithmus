import java.util.*;

/*
    문제 : 프린터

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42587?language=java

 */

public class Printer {
    class paper{
        int priorities;
        int location;

        public paper(int priorities, int location){
            this.priorities = priorities;
            this.location =location;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<paper> list = new LinkedList<paper>();

        for(int i = 0; i<priorities.length;i++){
            list.add(new paper(priorities[i],i));
        }

        while(!list.isEmpty()){
            paper temp = list.get(0);
            boolean ismax = true;
            for(int i =1;i<list.size();i++){
                if(temp.priorities<list.get(i).priorities){
                    ((LinkedList<paper>) list).removeFirst();
                    list.add(temp);
                    ismax=false;
                    break;
                }
            }

            if(ismax){
                ((LinkedList<paper>) list).removeFirst();
                answer++;
                if(temp.location==location)
                    return answer;
            }
        }

        return answer;
    }
}
