import java.util.*;

/*
    문제 출처 : https://www.acmicpc.net/problem/2178
    이슈 사항
    1. queue<T>의 사용 미흡(BFS) 공부 더 해야 함
        - poll(),peek() 차이 공부
    2. 초기 코드의 메모리 초과
        -> 이미 한번 등록된 좌표가 중복 등록 되어서 메모리가 초과 됨
        -> 한번 offer된 좌표의 값은 2로 변경
        -> poll 된 좌표의 값은 -로 변경
 */


public class q2178 {
    public int getnum(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] maze = new String[N];

        for(int i = 0; i< N;i++){
            maze[i]=sc.next();
        }
        int answer = findmaze(N,M,maze);
        return answer;
    }

    //미로 탐색
    public int findmaze(int N, int M, String[] maze){
        int min = 999999999;
        Queue<xynum> q = new LinkedList<xynum>();
        ((LinkedList<xynum>) q).push(new xynum(0,0,1));
        char[][] nmaze = new char[N][M];
        for(int i = 0;i<N;i++){
            for(int j = 0; j<M;j++){
                nmaze[i][j] = maze[i].charAt(j);
            }
        }

        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            if(x==N-1&&y==M-1)
                break;
            int num = q.poll().num;

            nmaze[x][y] = '-';
            if(x > 0 && nmaze[x-1][y]=='1'){
                nmaze[x-1][y]='2';
                q.offer(new xynum(x-1,y,num+1));
            }
            if(x<N-1&&nmaze[x+1][y]=='1'){
                nmaze[x+1][y]='2';
                q.offer(new xynum(x+1,y,num+1));
            }
            if(y>0&&nmaze[x][y-1]=='1'){
                nmaze[x][y-1]='2';
                q.offer(new xynum(x,y-1,num+1));
            }
            if(y<M-1&&nmaze[x][y+1]=='1'){
                nmaze[x][y+1]='2';
                q.offer(new xynum(x,y+1,num+1));
            }
        }


        while(!q.isEmpty()){
            min = Math.min(min , q.peek().num);
            q.poll();
        }

        return min;
    }

}
