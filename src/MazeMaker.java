import java.awt.*;
import java.util.*;
import java.io.*;
/*
    문제 : 미로 만드는 사람(BFS)

    출처 : TopCoder 알고리즘 트레이닝 08. 미로 만드는 사람

    이슈 사항
    1.
 */

public class MazeMaker {
    public void getMaze(){
        String[] maze = {"X.X","...","XXX","X.X"};
        int startRow = 0;
        int startCol = 1;
        int[] moveRow = {1,0,-1,0};
        int[] moveCol = {0,1,0,-1};
        System.out.println(longestPath(maze,startRow,startCol,moveRow,moveCol));
    }

    public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol){
        int row = maze.length;
        int col = maze[0].length();
        int[][] imaze = new int[row][col];
        boolean[][] visit = new boolean[row][col];
        for(int i = 0; i < imaze.length;i++){
            for(int j = 0; j< imaze[i].length;j++){
                if(maze[i].charAt(j) == '.')
                    imaze[i][j] = 1;
                else
                    imaze[i][j] = 0;
                System.out.println("OK");
            }
        }

        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(startRow,startCol));
        visit[startRow][startCol] = true;

        while(!q.isEmpty()){
            Point temp = q.poll();
            System.out.println(temp + " " + imaze[temp.x][temp.y]);
            int x = temp.x;
            int y = temp.y;

            for(int i = 0; i<moveRow.length;i++){
                int nx = x+moveRow[i];
                int ny = y+moveCol[i];
                if(nx>=0&&nx<row&&ny>=0&&ny<col){
                    if(imaze[nx][ny]!=0 && !visit[nx][ny]){
                        System.out.println("input ="+nx+" "+ny);
                        q.offer(new Point(nx,ny));
                        visit[nx][ny] = true;
                        imaze[nx][ny] = imaze[x][y]+1;
                    }
                }
            }

            if(q.isEmpty()){
                for(int i = 0; i < imaze.length;i++){
                    for(int j = 0; j< imaze[i].length;j++){
                        if(imaze[i][j] ==1 && (i!=startRow || j!=startCol)) {
                            System.out.println(i+" "+j);
                            return -1;
                        }
                    }
                }
                return imaze[x][y]-1;
            }
        }
        return -1;
    }
}
