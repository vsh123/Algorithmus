import java.util.*;
import java.io.*;

/*
    문제 : 타일 채우기

    문제 출처 : https://www.acmicpc.net/problem/2133

    이슈 사항
    1. 점화식 DP[n] = 3*DP[n-2] + 2*DP[n-4] + 2*DP[n-6] ..... + 2*DP[0]
        -> 정확히 반으로 쪼갤 수 없음

*/

public class q2133 {
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
        if(n==0) return 1;
        if(n==1) return 0;
        if(n==2) return 3;
        if(dp[n] != 0) return dp[n];
        int result = 3 * finddp(n-2);
        for(int i = 3; i <=n;i++){
            if(i%2 == 0){
                result += 2*finddp(n-i);
            }
        }
        return dp[n] = result;
    }
}
