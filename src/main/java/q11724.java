import java.util.*;
import java.io.*;

/*
    문제 : 연결 요소의 개수(DFS)

    문제 출처 : https://www.acmicpc.net/problem/11724

    이슈 사항
    1. 재귀 함수를 이용한 DFS 잘 짜야함

*/

public class q11724 {
    boolean[][] graph;
    boolean[] visit;
    int N;
    public void getline(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph = new boolean[N+1][N+1];
            visit = new boolean[N+1];
            for(int i =0;i<M;i++){
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = graph[b][a] = true;
            }
            findCC();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void findCC(){
        int count = 0;
        for(int i =1; i < N+1; i++){
            if(!visit[i]) {
                count++;
                visit[i] = true;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    public void dfs(int y){
        for(int i = 1; i<N+1;i++){
            if(graph[y][i]){
                visit[i] = true;
                graph[y][i]=graph[i][y] =false;
                dfs(i);
            }
        }
    }
}
