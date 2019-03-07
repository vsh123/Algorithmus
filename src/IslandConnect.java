import java.util.*;
/*

    문제 : 섬 연결하기

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42861?language=java

    이슈 사항
        1.

 */

public class IslandConnect {
    boolean[] visit;
    int[][] ans;
    List<Integer> answers = new ArrayList<Integer>();
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ans = new int[n][n];
        for(int i =0;i<costs.length;i++){
            ans[costs[i][0]][costs[i][1]] = ans[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        visit[0] = true;
        dfs(n,0,0);
        visit = new boolean[n];
        Collections.sort(answers);
        answer = answers.get(0);
        return answer;
    }

    public void dfs(int n, int which,int cost){
        n--;
        if(n==0){
            answers.add(cost);
            return;
        }
        for(int i =0;i<ans[which].length;i++){
            if(ans[which][i]>0 && !visit[i]){
                visit[which] = true;
                cost = cost + ans[which][i];
                dfs(n,i,cost);
                visit[which] = false;
            }
        }
    }
}
