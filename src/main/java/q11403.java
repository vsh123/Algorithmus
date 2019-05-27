import java.util.*;
import java.io.*;
/*
    문제 : 경로 찾기(DFS)

    문제 출처 : https://www.acmicpc.net/problem/11403

    이슈 사항
    1. DFS하고 이동가능한 좌표를 어떻게 넘겨줄지 잘 생각해야함.
 */

public class q11403 {
    int[][] graph;
    boolean[] visit;
    public void getgraph() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            graph = new int[N + 1][N + 1];
            visit = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 1; j < graph[i].length; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 1; i <= N; i++)
            {
                visit[i] = true;
                DFS(0, i);
                visit = new boolean[N+1];
            }
            for(int i =1; i<=N;i++){
                for(int j =1;j<graph[i].length;j++){
                    System.out.print(graph[i][j]);
                    if(j+1!=graph[i].length)
                        System.out.print(" ");
                }
                System.out.println();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void DFS(int parent,int start){
        for(int i = 1;i<graph[start].length;i++){
            if(graph[start][i]==1){
                if(!visit[i]){
                    visit[i] = true;
                    DFS(start, i);
                }
            }
        }
        for(int i = 1;i<graph[start].length;i++){
            if(parent!=0&&graph[start][i]==1)
                graph[parent][i]= 1;
        }
    }
}
