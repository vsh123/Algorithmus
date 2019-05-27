import java.util.*;
import java.io.*;

/*
    문제 : 2Xn 타일링2(DP)

    문제 출처 : https://www.acmicpc.net/problem/11727

    이슈 사항
    1. 점화식 DP[n] = DP[n-1] + 2*DP[n-2]

*/

public class q11727 {
    int[] dp;
    public void tiling(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            dp = new int[n+1];
            int answer = finddp(n);
            System.out.println(answer);
        }catch(IOException e){
            e.printStackTrace();;
        }
    }

    public int finddp(int n){
        if(n==1) return 1;
        if(n==2) return 3;
        if(dp[n] != 0) return dp[n];
        return dp[n] = (finddp(n-1) + 2 * finddp(n-2))%10007;
    }
}
