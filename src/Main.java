import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        q1697 test = new q1697();
        int answer = test.getpoint();
        System.out.println(answer);
    }
}
/*

class q1697 {
    public int getpoint(){
        int answer = 0;
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            answer =findtime(N,K);
        }catch (IOException e){
            e.printStackTrace();
        }
        return answer;
    }

    private int findtime(int N, int K){
        int answer = 0;
        Queue<Point> point = new LinkedList<Point>();

        point.offer(new Point(N,0));

        while(!point.isEmpty()){
            Point temp = point.poll();
            int x = temp.x;
            int time = temp.y;
            if(x == K) {
                answer = time;
                break;
            }
            point.offer(new Point(x-1,time+1));
            point.offer(new Point(x+1,time+1));
            point.offer(new Point(x*2,time+1));

        }

        return answer;
    }
}*/
