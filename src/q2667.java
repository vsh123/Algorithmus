import java.util.*;
import java.io.*;

/*
    문제 : 단지번호붙이기(DFS)

    문제 출처 : https://www.acmicpc.net/problem/2667

    이슈 사항

    1. ArrayList 정렬 하는법
        - 오름차순 : Collections.sort(리스트 명);
        - 내림차순 : Collections.sort(리스트 명,new AscendingInteger()(Integer일때));

 */


public class q2667 {
    int[][] maze;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int N;
    List<Integer> answer = new ArrayList<Integer>();

    public void getMaze(){
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            maze = new int[N][N];
            for(int i =0;i<N;i++){
                st = new StringTokenizer(bf.readLine());
                String s = st.nextToken();
                for(int j = 0; j< N;j++){
                    maze[i][j] = s.charAt(j) - '0';
                }
            }
            findAddress();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void findAddress(){
        for(int i = 0; i<N;i++){
            for(int j = 0; j<N;j++){
                if(maze[i][j]==1){
                    maze[i][j]=2;
                    answer.add(dfs(i,j));
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for(int i =0; i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }

    public int dfs(int x,int y){
        int ans = 1;
        for(int i = 0; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N && maze[nx][ny]==1){
                maze[nx][ny]=2;
                ans = ans + dfs(nx,ny);
            }
        }
        return ans;
    }
}
