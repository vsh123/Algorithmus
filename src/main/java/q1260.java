import java.util.*;
import java.io.*;
/*
    문제 : DFS와 BFS

    문제 출처 : https://www.acmicpc.net/problem/1260

    이슈 사항
    1. 간선이 없을 수도 있음
        4 3 2
        2 3
        3 1
        1 2
        ----
        2 1 3
        2 1 3
 */
public class q1260 {
    int[][] dfsgraph;
    List<Integer> a = new ArrayList<Integer>();
    boolean[] visit;
    boolean[] bfsvisit;
    public void getgraph(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] graph = new int[N+1][N+1];
            dfsgraph = new int[N+1][N+1];
            visit = new boolean[N+1];
            bfsvisit = new boolean[N+1];
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = graph[b][a] = dfsgraph[a][b] = dfsgraph[b][a] =1;
            }
            DFS(V);
            for(int i=0;i<a.size();i++){
                System.out.print(a.get(i));
                if(i+1!=a.size())
                    System.out.print(" ");
            }
            System.out.println();
            BFS(graph,V);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void DFS(int start){
        visit[start] = true;
        a.add(start);
        if(a.size()==dfsgraph.length-1)
            return ;
        for(int i =1; i<dfsgraph[start].length;i++){
            if(dfsgraph[start][i]==1 && !visit[i]){
                dfsgraph[start][i] = dfsgraph[i][start] = 0;
                DFS(i);
            }
            if(a.size()==dfsgraph.length-1)
                return ;
        }
    }

    public void BFS(int[][] graph, int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        int count = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp);
            count++;

            if(count == graph.length-1){
                break;
            }
            else{
                System.out.print(" ");
            }

            for(int i = 1; i<graph[temp].length;i++){
                if(graph[temp][i]==1 && !bfsvisit[i]){
                    q.offer(i);
                    bfsvisit[i] = true;
                    graph[temp][i]=graph[i][temp]=0;
                }
            }
        }
    }
}
