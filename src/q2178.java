import java.util.*;

public class q2178 {
    //미로 탐색
    public int findmaze(int N, int M, int[] maze){
        Queue<xynum> q = new LinkedList<xynum>();
        ((LinkedList<xynum>) q).push(new xynum(0,0,1));
        char[][] nmaze = new char[N][M];
        for(int i = 0;i<N;i++){
            for(int j = 0; j<M;j++){
                nmaze[i][j] = Integer.toString(maze[i]).charAt(j);
            }
            System.out.println();
        }

        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int num = q.peek().num;
            if(x==N-1&&y==M-1)
                break;
            nmaze[x][y] = '-';
            if(x>0&&nmaze[x-1][y]=='1'){
                ((LinkedList<xynum>) q).push(new xynum(x-1,y,num+1));
            }
            if(x<N-1&&nmaze[x+1][y]=='1'){
                ((LinkedList<xynum>) q).push(new xynum(x+1,y,num+1));
            }
            if(y>0&&nmaze[x][y-1]=='1'){
                ((LinkedList<xynum>) q).push(new xynum(x,y-1,num+1));
            }
            if(y<M-1&&nmaze[x][y+1]=='1'){
                ((LinkedList<xynum>) q).push(new xynum(x,y+1,num+1));
            }
            q.poll();
        }

        return 1;
    }

}

class xynum{
    int x,y,num;

    public xynum(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}