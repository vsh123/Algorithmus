import java.util.*;
import java.awt.*;
import java.io.*;

/*
    문제 : 숨바꼭질(BFS)
    문제 출처 : https://www.acmicpc.net/problem/1697
    이슈 사항
    1.
 */
public class q1697 {
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
        int count = 1;
        int ncount =1;
        int answer = 0;
       Queue<Point> point = new LinkedList<Point>();
       HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

       point.offer(new Point(N,0));
       map.put(N,0);

       while(!point.isEmpty()){
           Point temp = point.poll();
           int x = temp.x;
           int time = temp.y;
           System.out.println("x = "+x+" time = "+ time);
           if(x-1 == K || x+1 == K || x*2 == K) {
               answer = time+1;
               break;
           }
           ncount +=3;
           if(!map.containsKey(x-1)&&x-1>0) {
               point.offer(new Point(x - 1, time + 1));
               map.put(x-1,0);
               count++;
           }
           if(!map.containsKey(x+1)) {
               point.offer(new Point(x + 1, time + 1));
               map.put(x+1,0);
               count++;
           }
           if(!map.containsKey(x*2)) {
               point.offer(new Point(x * 2, time + 1));
               map.put(x*2,0);
               count++;
           }

       }
       System.out.println("ncount = " + ncount + " count = " + count);
       return answer;
    }
}
