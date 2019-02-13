import java.util.*;

/*
    문제 출처 : https://www.acmicpc.net/problem/7576
    이슈 사항
    1. 메모리 사용량이 너무 많음
        -> 아마 xynum을 사용해서 인걸로 확인 됨
        -> 포인터를 이용한 방식 생각해보기
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


        while(!q.isEmpty()){
            xynum temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int num = temp.num;
            if(q.isEmpty())
                answer = num;


            if(x > 0 && tomato[x-1][y]==0){
                tomato[x-1][y]=2;
                q.offer(new xynum(x-1, y,num+1));
            }
            if(x<N-1&&tomato[x+1][y]==0){
                tomato[x+1][y]=2;
                q.offer(new xynum(x+1,y,num+1));
            }
            if(y>0&&tomato[x][y-1]==0){
                tomato[x][y-1]=2;
                q.offer(new xynum(x,y-1,num+1));
            }
            if(y<M-1&&tomato[x][y+1]==0){
                tomato[x][y+1]=2;
                q.offer(new xynum(x,y+1,num+1));
            }



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
