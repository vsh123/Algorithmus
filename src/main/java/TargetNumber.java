import java.util.*;

/*

    문제 : 타겟 넘버

    출처 : https://programmers.co.kr/learn/courses/30/lessons/43165?language=java

    이슈 사항
        1. DFS 재귀문 잘 좀 짜자

 */

public class TargetNumber {
    int answer = 0;
    int goal;
    int[] number;
    public int solution(int[] numbers, int target) {
        number = new int[numbers.length];           //numbers 복사(전역 변수로 쓰기 위해서)
        for(int i =0; i<number.length;i++){
            number[i] = numbers[i];
        }

        goal= target;
        dfs(0,0);

        return answer;
    }

    public void dfs(int depth, int num){
        int tp = num + number[depth];       //더하기, 빼기로 구분
        int tp2 = num - number[depth];
        depth++;
        if(depth==number.length){          //모든 수를 사용했으며, 만약 타겟 넘버가 맞다면 answer ++;
            if(tp == goal)
                answer++;
            if(tp2 == goal)
                answer++;
            return;
        }


        dfs(depth, tp);
        dfs(depth, tp2);

    }
}
