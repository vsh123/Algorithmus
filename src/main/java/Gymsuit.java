import java.util.*;
/*

    문제 : 체육복

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42862?language=java

    이슈 사항
        1. 그리디 알고리즘인지는 모르겠음
        2. 문제 조건을 자세히 알고하자

 */

public class Gymsuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] ans = new int[n+1];
        for(int i=0;i<reserve.length;i++){
            ans[reserve[i]] = 1;
        }

        for(int i=0;i<lost.length;i++){
            ans[lost[i]] = ans[lost[i]]-1;
        }



        for(int i =1;i<ans.length;i++){
            if(ans[i] == -1){
                if(ans[i-1] == 1){
                    ans[i-1] =0;
                    ans[i] =0;
                }
                else if(i<ans.length-1 && ans[i+1] == 1){
                    ans[i+1] =0;
                    ans[i] =0;
                }
            }
        }

        for(int i =1;i<ans.length;i++){
            if(ans[i] == 0 || ans[i] ==1)
                answer++;
        }
        return answer;
    }
}
