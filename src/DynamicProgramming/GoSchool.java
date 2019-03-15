package DynamicProgramming;

import java.util.*;
/*

    문제 : 등굣길

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42898?language=java

    이슈 사항
        1. 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.


 */


public class GoSchool {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int x =1000000007;
        int[][] ans = new int[n+1][m+1];
        ans[1][1] = 1;
        ans[0][1] = ans[1][0] = 1;
        for(int i =0;i<puddles.length;i++){
            ans[puddles[i][1]][puddles[i][0]] = -1;
        }

        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(j==1 && ans[i][j]!=-1)
                    ans[i][j] = ans[i-1][j]%x;
                if(i==1 && ans[i][j]!=-1)
                    ans[i][j] = ans[i][j-1]%x;
                else if(ans[i][j]!=-1) {
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                    if(ans[i - 1][j]==-1)
                        ans[i][j]++;
                    if(ans[i][j - 1]==-1)
                        ans[i][j]++;
                    ans[i][j] = ans[i][j]%x;
                }
            }
        }

        for(int i=0;i<=n;i++){
            for(int j =0;j<=m;j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        answer= ans[n][m];
        return answer;
    }
}
