import java.util.*;
import java.io.*;

/*
    문제 : 타일 채우기

    문제 출처 : https://www.acmicpc.net/problem/2133

    이슈 사항
    1. 점화식 DP[n] = 2 * DP[n-1]+ 3 * DP[n-2] + 2*DP[n-3] + 2*DP[n-4] ...... +2*DP[0]
        -> 정확히 반으로 쪼갤 수 없음
        -> dp[i][1] = (dp[i-1][1] + dp[i-3][0]) % 1000000007;이유룰 모루겠음

*/

public class q14852 {
    long[][] dp;
    public void tiling(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            dp = new long[n+1][2];
            long answer = finddp(n);
            System.out.println(answer);
        }catch(IOException e){
            e.printStackTrace();;
        }
    }

    public long finddp(int n){
        dp[0][0] = 0;
        dp[1][0] = 2;
        dp[2][0] = 7;
        dp[2][1] = 1;
        for(int i = 3; i<= n; i++){
            dp[i][1] = (dp[i-1][1] + dp[i-3][0]) % 1000000007;
            dp[i][0] = (3 * dp[i-2][0] + 2*dp[i-1][0] + 2*dp[i][1]) % 1000000007;
        }
        return dp[n][0];
    }
}
