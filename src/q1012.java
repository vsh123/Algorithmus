import java.util.*;
import java.io.*;


public class q1012 {
    int[][] maze;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int tcase;
    int M;
    int N;
    List<Integer> answer = new ArrayList<Integer>();

    public void getMaze(){
        int K;
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            tcase = Integer.parseInt(st.nextToken());
            for(int a = 0; a< tcase;a++) {
                st = new StringTokenizer(bf.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());
                maze = new int[N][M];
                for (int i = 0; i < K; i++) {
                    st = new StringTokenizer(bf.readLine());
                    int y = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());
                    maze[x][y] = 1;
                }
                findlarva();
            }
            for(int i =0; i<answer.size();i++){
                System.out.println(answer.get(i));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void findlarva(){
        int count = 0;
        for(int i = 0; i<N;i++){
            for(int j = 0; j<M;j++){
                if(maze[i][j]==1){
                    maze[i][j]=2;
                    count++;
                    dfs(i,j);
                    for(int a =0 ;a < N;a++){
                        for(int b =0; b<M;b++){
                            System.out.print(maze[a][b]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        }
        answer.add(count);
    }

    public void dfs(int x,int y){
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N && maze[nx][ny]==1){
                maze[nx][ny]=2;
                dfs(nx,ny);
            }
        }
        return ;
    }
}
