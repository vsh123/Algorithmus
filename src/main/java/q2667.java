import java.util.*;
import java.io.*;

/*
    문제 : 단지번호붙이기(DFS)

    문제 출처 : https://www.acmicpc.net/problem/2667

    이슈 사항

    1. ArrayList 정렬 하는법
        - 오름차순 : Collections.sort(리스트 명);
        - 내림차순 : Collections.sort(리스트 명,new AscendingInteger()(Integer일때));


    2. main문에서는 메소드 호출만 실시합니다.
 */


public class q2667 {
    int[][] maze;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int N;
    List<Integer> answer = new ArrayList<Integer>();

    public void getMaze(){                      //입력 받는 과정
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

    public void findAddress(){          //전체 탐색을 진행, 만약 집이 있다면(1이라면) 2로변경하고 DFS 실시
        for(int i = 0; i<N;i++){
            for(int j = 0; j<N;j++){
                if(maze[i][j]==1){
                    maze[i][j]=2;
                    answer.add(dfs(i,j));   //해당 단지 결과를 answer에 add
                }
            }
        }
        System.out.println(answer.size());      //총 단지 수
        Collections.sort(answer);               //오름차순 정렬
        for(int i =0; i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }

    public int dfs(int x,int y){
        int ans = 1;
        for(int i = 0; i < 4; i++){             //동서남북으로 탐색 실시
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
