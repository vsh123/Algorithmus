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
        for(int i =0; i<n;i++){                    //모든 컴퓨터에 대해서 for문 실시
            if(!visit[i]){                        // 만약 방문하지 않았다면(아직 네트워크를 형성하지 않았다면)
                visit[i] = true;
                dfs(computers[i]);
                answer++;                         // 새로운 네트워크를 형성하였기 때문에 ++
            }
        }
        return answer;
    }

    public void dfs(int[] computer){
        for(int i =0;i<computer.length;i++){     //DFS를 통해서 해당 컴퓨터랑 연결된 모든 컴퓨터를 탐색하여 vistied = true로 설정
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
