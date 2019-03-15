import java.util.*;
/*

    문제 : 이중우선순위큐

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42628?language=java

    이슈 사항
        1. new Comparator 사용법
        2. 5 13에서 min을 지우면 5가 사라지는데
        이 상태에서 4 삽입하고
        max 두번지우면 없던 5가 사라짐


 */

public class DoublePriorityQueue {
    Queue<Integer> minHeap = new PriorityQueue<Integer>();

    Queue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int size = 0;
        for(int i =0;i<operations.length;i++){
            String[] temp = operations[i].split(" ");
            String oper = temp[0];
            int num = Integer.parseInt(temp[1]);
            if(oper.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
                size++;
            }
            else {
                if(size!=0) {
                    size--;
                    delete(num);
                }
            }
        }
        if(size!=0&&!maxHeap.isEmpty()&&!minHeap.isEmpty()) {
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }
        return answer;
    }

    public void delete(int num){
        if(num==1)
            minHeap.remove(maxHeap.poll());
        else
            maxHeap.remove(minHeap.poll());
    }
}
