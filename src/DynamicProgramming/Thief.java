package DynamicProgramming;

/*

    문제 : 도둑질

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42897?language=java

    이슈 사항
        1. i번째의 최대값 = i-2 + 지금돈 or i-1의 최대값

        2. 내생각
            i번째의 최대값 = i-2 + 지금돈 or i-1의 최대값
            i-1번재의 money를 안 더햇을때 => i-1 + money[i]도 가능하지 않나?
            dp[0] = dp[1] = money[0];
            dp[0] = money[0]일때
            dp[1] = 0이 아닌 dp[0]!

 */


public class Thief {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length];
        int[] dp2 = new int[money.length];

        dp[0] = dp[1] = money[0];
        for(int i =2; i<money.length-1;i++){
            dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
        }

        dp2[1] = money[1];
        for(int i =2; i<money.length;i++){
            dp2[i] = Math.max(dp2[i-2]+money[i], dp2[i-1]);
        }

        answer = Math.max(dp[money.length-2],dp2[money.length-1]);
        return answer;
    }

/*    public int solution(int[] money) {
        int answer = 0;
        boolean[] visited = new boolean[money.length];
        boolean[] visited2 = new boolean[money.length];
        int[] dp = new int[money.length];
        int[] dp2 = new int[money.length];
        int max = 0;

        dp[0] = dp[1] = money[0];
        visited[0] = true;
        for(int i =2; i<money.length-1;i++){
            if(money[i]==0)
                dp[i] = Math.max(dp[i-2],dp[i-1]);
            else if(!visited[i-1]){
                dp[i] = Math.max(dp[i-2]+money[i],dp[i-1]+money[i]);
                visited[i] = true;
            }
            else{
                if(dp[i-2]+money[i]<=dp[i-1]){
                    dp[i] = dp[i-1];
                }
                else{
                    dp[i] = dp[i-2]+money[i];
                    visited[i] = true;
                }
                //dp[i] = Math.max(dp[i-2]+money[i],dp[i-1]);
            }

            max= Math.max(max,dp[i]);
            //System.out.println("dp["+i+"] = "+dp[i]);
        }

        dp2[1] = money[1];
        visited2[1] = true;
        for(int i =2; i<money.length;i++){
            if(money[i]==0)
                dp2[i] = Math.max(dp2[i-2],dp2[i-1]);
            else if(!visited2[i-1]){
                dp2[i] = Math.max(dp2[i-2]+money[i],dp2[i-1]+money[i]);
                visited2[i] = true;
            }
            else{
                if(dp2[i-2]+money[i]<=dp2[i-1]){
                    dp2[i] = dp2[i-1];
                }
                else{
                    dp2[i] = dp2[i-2]+money[i];
                    visited2[i] = true;
                }
            }
            //    dp2[i] = Math.max(dp2[i-2]+money[i],dp2[i-1]);

            max= Math.max(max,dp2[i]);
            //System.out.println("dp2["+i+"] = "+dp2[i]);
        }

        answer = max;
        return answer;
    }*/
}
