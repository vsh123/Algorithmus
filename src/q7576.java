import java.awt.*;
import java.util.*;
import java.io.*;

/*
    문제 : 토마토

    문제 출처 : https://www.acmicpc.net/problem/7576

    이슈 사항
    1. 메모리 사용량이 너무 많음
        -> 아마 xynum을 사용해서 ;인걸로 확인 됨(아니여따)
        -> Point를 이용한 방식 생각해보기
        -> Scanner 문제? ㅇㅇ 참고 : https://coding-factory.tistory.com/251

 */


public class q7576 {
    //입력부
    public int getnum(){
        int answer =0;
        //BufferReader를 이용한 입력값 받음(메모리 사용량이 Scanner보다 적음)
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            //토마토 배열 생성
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
        //x,y좌표만 받을 수 있는 큐를 생성
        Queue<Point> q = new LinkedList<Point>();

        //최초 전 지점을 탐색하면서 토마토가 익은 곳의 좌표를 큐에 추가
        //count는 그 day에 뺄수 있는 토마토 수를 count함
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 1){
                    q.offer(new Point( i, j));
                    count++;
                }
            }
        }

        //큐에서 하나씩 빼서 탐색 시작
        while(!q.isEmpty()){
            Point temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            //count를 줄여가면서 토마토 개수를 셈
            count--;

            //상,하,좌,우로 안익은 토마토가 있는지 검사, 만약 한번 방문한 토마토의 좌표는 2로 설정
            //tp는 다음날 토마토의 개수를 임시 count
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

            //만약 그날 주위에 영향을 미칠 토마토를 다 검사했다면(위에서 count 하나씩 감소하면서 내림)
            //day하루 증가 후 count = tp로 옮김
            if(count==0){
                day++;
                count = tp;
                tp = 0;
            }


        }

        //만약 while문을 나왔는데도 안익은 토마토가 있다면 접근이 불가능한 위치이므로 -1을 리턴
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 0){
                    return -1;
                }
            }
        }

        //while문에서 마지막에 day가 한번 더 증가되기 때문에 -1해서 return
        return day-1;
    }
}
