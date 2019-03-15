package DynamicProgramming;

import java.util.*;
/*

    문제 : 정수 삼각형

    출처 : https://programmers.co.kr/learn/courses/30/lessons/43105?language=java

    이슈 사항
        1. DP DP^^


 */

public class Triangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i =1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0)
                    triangle[i][j] += triangle[i-1][0];
                else if(j==triangle[i].length-1)
                    triangle[i][j] += triangle[i-1][triangle[i-1].length-1];
                else
                    triangle[i][j] += Math.max(triangle[i-1][j-1],triangle[i-1][j]);
            }
        }

        for(int i=0;i<triangle[triangle.length-1].length;i++)
            answer = Math.max(answer,triangle[triangle.length-1][i]);
        return answer;
    }
}
