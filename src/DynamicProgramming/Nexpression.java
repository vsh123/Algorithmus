package DynamicProgramming;

import java.util.*;
/*

    문제 : N으로 표현

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42895?language=java

    이슈 사항
        1. 완전 탐색으로 진행해보자(N 깊이는 최대 8)
        - 경우 -> +,-,*,/ 총 4가지
        - 최대 N^7가지의 경우 발생
        - N/N 표현 안됨? ㄴㄴㄴㄴ
        - N/N - NNN이랑 NNN - N/N은 다른 거임(절대값)


 */

public class Nexpression {
    class number implements Comparable<number>{
        int dep;
        int num;

        public number(int dep, int num){
            this.dep = dep;
            this.num = num;
        }

        @Override
        public int compareTo(number o){
            return dep - o.dep;
        }

    }

    public int solution(int N, int number) {
        int answer = 0;
        int[] ans = new int[8];
        ans[0] =N;
        for(int i =1;i<8;i++){
            ans[i] = ans[i-1]*10+N;
        }
        Queue<number> q = new PriorityQueue<number>();
        for(int i =0;i<8;i++) {
                q.offer(new number((i + 1), ans[i]));
        }

        while(!q.isEmpty()){
            number temp = q.poll();
            int dep = temp.dep;
            int num = temp.num;
            if(num==number)
                return dep;
            for(int i =0;i<8;i++) {
                if(dep + (i+1)<=8) {
                    q.offer(new number(dep + (i + 1), num + ans[i]));
                    if ((num - ans[i]) != 0)
                        q.offer(new number(dep + (i + 1), Math.abs(num - ans[i])));
                    q.offer(new number(dep + (i + 1), num * ans[i]));
                    if ((num / ans[i]) != 0)
                        q.offer(new number(dep + (i + 1), num / ans[i]));
                }
            }
        }
        return -1;
    }
}
