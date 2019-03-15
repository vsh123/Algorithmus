package DynamicProgramming;

import java.util.*;
/*

    문제 : 카드 게임

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42896?language=java

    이슈 사항
        1. DP 어렵다ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ


 */

public class CardGame {
    public int solution(int[] left, int[] right) {
        int[][] dp = new int[left.length+1][right.length+1];
        for(int i=0;i<left.length;i++){
            for(int j=1;j<right.length+1;j++){
                if(i!=0)
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]);
                if(left[i]>right[j-1])
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+right[j-1]);
            }
        }

        int answer = -1;
        for(int i =0;i<right.length;i++){
            answer= Math.max(answer,dp[left.length-1][i]);
        }
        return answer;
    }
}
