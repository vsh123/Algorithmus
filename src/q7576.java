import java.awt.*;
import java.util.*;
/*
    문제 출처 : https://www.acmicpc.net/problem/7576
    이슈 사항
    1.
 */

public class q7576 {
    public int getnum(){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] tomato = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                tomato[i][j] = sc.nextInt();
            }
        }
        int answer = alltomato(N,M,tomato);
        return answer;
    }

    public int alltomato(int N,int M, int[][] tomato){
        int answer = 0;
        Queue<xynum> q = new LinkedList<xynum>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 1){
                    q.offer(new xynum( i, j, 0));
                }
            }
        }

        System.out.println(q);

        while(!q.isEmpty()){
            xynum temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int num = temp.num;
            if(q.isEmpty())
                answer = num;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    System.out.print(tomato[i][j]+"     ");
                }
                System.out.println();
            }
            System.out.println("------------------------");

            if(x > 0 && tomato[x-1][y]==0){
                tomato[x-1][y]=2;
                q.offer(new xynum(x-1, y,num+1));
                System.out.println(num+1);
            }
            if(x<N-1&&tomato[x+1][y]==0){
                tomato[x+1][y]=2;
                q.offer(new xynum(x+1,y,num+1));
                System.out.println(num+1);
            }
            if(y>0&&tomato[x][y-1]==0){
                tomato[x][y-1]=2;
                q.offer(new xynum(x,y-1,num+1));
                System.out.println(num+1);
            }
            if(y<M-1&&tomato[x][y+1]==0){
                tomato[x][y+1]=2;
                q.offer(new xynum(x,y+1,num+1));
                System.out.println(num+1);
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    System.out.print(tomato[i][j]+"     ");
                }
                System.out.println();
            }
            System.out.println("answer = " + answer);
            System.out.println();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 0){
                    return -1;
                }
            }
        }

        return answer;
    }
}