package DynamicProgramming;

/*

    문제 : 서울에서 경산까지

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42899?language=java

    이슈 사항
        1. ???????????????????????????????????????????????????????

 */

public class FromSeuolToGyeongSan {
    int[][] ans;
    int[][] memo =new int[101][100001];    // a번째의 b초 일때의 최대 값
    int limit;
    public int solution(int K, int[][] travel) {
        int answer = 0;
        int len = travel.length;
        limit = K;
        ans = travel;

        answer = dfs(0,ans[0][1],ans[0][0]);
        answer = Math.max(answer,dfs(0,ans[0][3],ans[0][2]));

        return answer;
    }

    public int dfs(int cnt, int money, int time){
        if(time > limit)
            return -1;

        if(memo[cnt][time] == -1)
            return -1;

        if(cnt == ans.length-1 && time <= limit)
            return money;



        int x = 0;
        x = Math.max(x,dfs(cnt+1,ans[cnt+1][1]+money,ans[cnt+1][0]+time));
        x = Math.max(x,dfs(cnt+1,ans[cnt+1][3]+money,ans[cnt+1][2]+time));

        if(x==0){
            memo[cnt][time] = -1;
        } else{
            memo[cnt][time] = x-money;
        }

        return x;
    }
}
