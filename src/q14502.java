import java.util.*;
import java.io.*;

/*
    문제 : 연구소

    문제 출처 : https://www.acmicpc.net/problem/14502

    이슈 사항
    1. 6중 포문..!!
 */


public class q14502 {
    int[][] maze;
    int[][] temp;

    boolean[][] visit;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int M;
    int N;
    int max = 0;

    public void getMaze(){
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            maze = new int[N][M];
            temp = new int[N][M];
            for(int i =0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                for(int j =0;j<M;j++){
                    maze[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            resettemp();

            for(int i1 = 0; i1< N;i1++){
                for(int j1 =0;j1<M;j1++){
                    if(temp[i1][j1]==0) {
                        temp[i1][j1]=1;
                        for (int i2 = 0; i2 < N; i2++) {
                            for (int j2 = 0; j2 < M; j2++) {
                                if(temp[i2][j2]==0) {
                                    temp[i2][j2]=1;
                                    for (int i3 = 0; i3 < N; i3++) {
                                        for (int j3 = 0; j3 < M; j3++) {
                                            if(temp[i3][j3]==0) {
                                                temp[i3][j3] = 1;
                                                int ans = spread(temp);
                                                max = Math.max(max,ans);
                                                resettemp();
                                                temp[i1][j1]=1;
                                                temp[i2][j2]=1;
                                            }
                                        }
                                    }
                                    resettemp();
                                    temp[i1][j1]=1;
                                }
                            }
                        }
                        resettemp();
                    }
                }
            }

            System.out.println(max);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public int spread(int[][] temp){
        visit = new boolean[N][M];
        int count = 0;
        for(int i =0; i <N;i++){
            for(int j =0 ;j<M;j++){
                if(temp[i][j] ==2){
                    visit[i][j] = true;
                    dfs(i,j);
                }
            }
        }
        for(int a =0; a<N;a++){
            for(int b=0;b<M;b++){
                if(temp[a][b]==0)
                    count++;
            }
        }

        return count;
    }

    public void dfs(int x,int y){
        for(int i =0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<M && temp[nx][ny]==0&&!visit[nx][ny]){
                visit[nx][ny]=true;
                temp[nx][ny]=2;
                dfs(nx,ny);
            }
        }
    }

    public void resettemp(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = maze[i][j];
            }
        }
    }
}

