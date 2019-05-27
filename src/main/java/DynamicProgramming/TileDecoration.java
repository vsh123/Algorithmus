package DynamicProgramming;

import java.util.*;
/*

    문제 : 타일 장식물

    출처 : https://programmers.co.kr/learn/courses/30/lessons/43104?language=java

    이슈 사항
        1. N번째 정사각형의 한 변의 길이 (N-1)+(N-2)


 */

public class TileDecoration {
    public long solution(int N) {
        long answer = 0;
        long[] ans = new long[N+1];
        ans[1] = 1;
        ans[2] = 1;
        for(int i =3;i<=N;i++){
            ans[i] = ans[i-1]+ans[i-2];
        }
        answer = ans[N]*2+(ans[N]+ans[N-1])*2;
        return answer;
    }
}
