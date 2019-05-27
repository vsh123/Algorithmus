import java.util.*;
import java.io.*;

/*
    문제 : 퇴사(DFS)

    문제 출처 : https://www.acmicpc.net/problem/14501

    이슈 사항

    1. main문에서는 메소드 호출만 실시합니다.

    2. DP로도 생각해보자
 */

public class q14501 {
    int[] time;
    int[] money;
    int max =0;
    int limit =0 ;
    public void goHome(){                      //입력 받는 과정
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            limit =N;
            time = new int[N+1];
            money = new int[N+1];
            for(int i =1;i<=N;i++){
                 st = new StringTokenizer(bf.readLine());
                 time[i] = Integer.parseInt(st.nextToken());
                 money[i] = Integer.parseInt(st.nextToken());
            }
            solve();
            for(int i=1; i<=N;i++){                         //DFS 실시(1일차 부터 N일차를 했을 경우)
                int ans = money[i];
                dfs(i+time[i],ans);
            }

        //    System.out.println(max);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void dfs(int tm, int ans){
        if(tm==limit+1){                                    // 만약 N+1일차라면 return
            max = Math.max(max, ans);
            return;
        }
        for(int i =tm;i<=limit;i++){
            if(i+time[i]>limit+1){                          //이번 일을 끝냈을 때 N+1이 넘어간다면 -> 일을 못함
                max = Math.max(max, ans);
            }
            else{
                dfs(i+time[i], ans + money[i]);  //이번 일 끝내고 다음일도 할 수 있는지 DFS 실시
            }
        }
    }


    public void solve(){
        int[] dp = new int[limit+1];
        int answer= 0;
        for(int i =1;i<=limit;i++){                                     //모든 dp를 해당 날짜에 일을 했을때(단 N+1이하일때)로 초기화
            if(i+time[i]<=limit+1)
                dp[i] = money[i];
        }
        for(int i =2;i<=limit;i++){
            for(int j=1;j<i;j++){
                if(i-j>=time[j] && (i+time[i]<=limit+1)){               //i일과 j일의 차이가 time[j] j에서 걸리는 시간 보다 클때의 점화식 점화식 - dp[i] = dp[i] = Math.max(dp[i],dp[j]+money[i]);
                    dp[i] = Math.max(dp[i],dp[j]+money[i]);
                }
            }
        }

        for(int i =1;i<=limit;i++){
                answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);
    }
}
