import java.awt.*;
import java.util.*;
import java.io.*;

/*
    문제 출처 : https://www.acmicpc.net/problem/7576
    이슈 사항
    1. 메모리 사용량이 너무 많음
        -> 아마 xynum을 사용해서 ;인걸로 확인 됨(아니여따)
        -> Point를 이용한 방식 생각해보기
        -> Scanner 문제?
 */
public class q7576 {
    public int getnum(){
//                Scanner sc = new Scanner(System.in);
        int answer =0;
                try {
                    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
                    String s = bf.readLine();
                    StringTokenizer st = new StringTokenizer(s);
                    int M = Integer.parseInt(st.nextToken());
                    int N = Integer.parseInt(st.nextToken());
                    int[][] tomato = new int[N][M];
                    for(int i = 0; i < N; i++){
                        s = bf.readLine();
                        st = new StringTokenizer(s);
                        for(int j = 0; j < M; j++){
                            tomato[i][j] = Integer.parseInt(st.nextToken());
                        }
                    }
                    answer = alltomato(N,M,tomato);
                }catch (IOException e){
                    e.printStackTrace();
                }
        return answer;
    }

    public int alltomato(int N,int M, int[][] tomato){
        int answer = 0;
        int count = 0;
        int day = 0;
        int tp =0;
        Queue<Point> q = new LinkedList<Point>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 1){
                    q.offer(new Point( i, j));
                    count++;
                }
            }
        }


        while(!q.isEmpty()){
//            System.out.println("count = " + count);
            Point temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            count--;

            if(x > 0 && tomato[x-1][y]==0){
                tomato[x-1][y]=2;
                q.offer(new Point(x-1, y));
                tp++;
            }
            if(x<N-1&&tomato[x+1][y]==0){
                tomato[x+1][y]=2;
                q.offer(new Point(x+1,y));
                tp++;
            }
            if(y>0&&tomato[x][y-1]==0){
                tomato[x][y-1]=2;
                q.offer(new Point(x,y-1));
                tp++;
            }
            if(y<M-1&&tomato[x][y+1]==0){
                tomato[x][y+1]=2;
                q.offer(new Point(x,y+1));
                tp++;
            }

            if(count==0){
                day++;
                count = tp;
                tp = 0;
            }


        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 0){
                    return -1;
                }
            }
        }

        return day-1;
    }
}
