import java.util.*;

/*

    문제 : 네트워크

    출처 : https://programmers.co.kr/learn/courses/30/lessons/43162?language=java

    이슈 사항
        1. DFS(재귀)

 */


public class Network {
    boolean[] visit;
    int[][] com;
    int answer = 0;
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        com = computers;
        int answer = 0;
        for(int i =0; i<n;i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(computers[i]);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int[] computer){
        for(int i =0;i<computer.length;i++){
            if(computer[i] == 1){
                computer[i] =0;
                if(!visit[i]){
                    visit[i]= true;
                    dfs(com[i]);
                }
            }
        }
    }
}
