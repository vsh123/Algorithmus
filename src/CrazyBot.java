import java.util.*;
import java.io.*;
/*
    문제 : 고장난 로봇(DFS)

    출처 : TopCoder 알고리즘 트레이닝 07.고장난 로봇

    이슈 사항
    1. 재귀 함수를 이용한 DFS 좀 더 연습 해봐야 할듯
 */

public class CrazyBot {

    boolean[][] grid = new boolean[100][100];
    int vx[] = {1,-1,0,0};
    int vy[] = {0,0,1,-1};
    double[] prob = new double[4];

    public void getEWSN(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());
            int west = Integer.parseInt(st.nextToken());
            int south = Integer.parseInt(st.nextToken());
            int north = Integer.parseInt(st.nextToken());
            double answer = getProbability(n,east,west,south,north);
            System.out.println(answer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public double getProbability(int n, int east, int west, int south, int north){
        prob[0] = east / 100.0;
        prob[1] = west / 100.0;
        prob[2] = south / 100.0;
        prob[3] = north / 100.0;

        return dfs(50,50, n);
    }

    double dfs(int x, int y, int n){
        //이미 지났던 자리라면 탐색 종료
        if(grid[x][y]) return 0;
        //맨 밑까지 지났다면 탐색 종료
        if(n == 0) return 1;

        grid[x][y] = true;
        double ret = 0;
        for(int i =0;i<4;i++){
            //east, west, south, north 순서로 로봇을 움직입니다.
            ret += dfs(x+vx[i], y+vy[i],n-1)*prob[i];
        }
        grid[x][y] = false;     //grid 원상 복귀

        return ret;
    }
}
