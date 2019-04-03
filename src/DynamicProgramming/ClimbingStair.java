package DynamicProgramming;

/*
    문제 : 계단 오르기(DP)

    문제 출처 : https://www.acmicpc.net/problem/2579

    이슈 사항
    1.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class ClimbingStair {
    List<Integer> stair = new ArrayList<Integer>();
    int[] dp;

    public void climb() {
        requestInput();
        dp = new int[stair.size()];
        dp[0] = stair.get(0);
        dp[1] = Math.max(dp[0] + stair.get(1), stair.get(1));
        dp[2] = Math.max(stair.get(2) + dp[0], stair.get(2) + stair.get(1));

        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(stair.get(i) + dp[i - 2], stair.get(i) + stair.get(i - 1) + dp[i - 3]);
        }
        System.out.println(dp[dp.length - 1]);
    }

    public void requestInput() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                stair.add(Integer.parseInt(st.nextToken()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
