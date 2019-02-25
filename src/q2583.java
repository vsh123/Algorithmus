import java.util.*;
import java.io.*;

/*
    문제 : 영역 구하기(DFS)

    문제 출처 : https://www.acmicpc.net/problem/2583

    이슈 사항
    1.

*/

public class q2583 {
    boolean[][] size;
    int M,N,K;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    List<Integer> ans = new ArrayList<Integer>();
    public void getsize(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            size = new boolean[M][N];
            for(int i =0;i<K;i++){
                st = new StringTokenizer(bf.readLine());
                int a1 = Integer.parseInt(st.nextToken());
                int b1 = Integer.parseInt(st.nextToken());
                int a2 = Integer.parseInt(st.nextToken());
                int b2 = Integer.parseInt(st.nextToken());
                for(int a = a1;a<a2;a++){
                    for(int b = b1;b<b2;b++){
                        size[b][a]= true;
                    }
                }
            }
            findsize();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void findsize(){
        int count =0;
        for(int i =0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!size[i][j]){
                    size[i][j]=true;
                    count++;
                    ans.add(dfs(i,j));
                }
            }
        }
        Collections.sort(ans);
        System.out.println(count);
        for(int i =0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    public int dfs(int x,int y){
        int answer = 1;
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<M && ny>=0 && ny<N && !size[nx][ny]){
                size[nx][ny]=true;
                answer = answer + dfs(nx,ny);
            }
        }
        return answer;
    }
}
