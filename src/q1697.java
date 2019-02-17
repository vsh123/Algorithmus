import java.util.*;
import java.io.*;

/*
    문제 : 숨바꼭질(BFS)
    문제 출처 : https://www.acmicpc.net/problem/1697
    이슈 사항
    1. 왜 x < 100000이여도 상관 없는지?
        -> 100000으로 제한을 하니 visit[100001] 을 정의하고 해도 괜찮은데 이유를 모르겠음.
    2. if((x-1) == K || (x+1) == K || (x*2) == K) {
                answer = time + 1 ;
                break;
       }하면 틀렸다고 나옴
       -> 이유를 모르겠음.........
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

        int answer = 0;
        ArrayList<Integer> point = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        point.add(N);
        map.put(N,0);

        while(!point.isEmpty()){
            int x = point.get(0);
            int time = map.get(x);
            point.remove(0);
            if(x== K) {
                answer = time;
                break;
            }

            if(!map.containsKey(x-1)&&(x-1)>=0) {
                point.add(x-1);
                map.put(x-1,time+1);
            }
            if(!map.containsKey(x+1)&&(x+1)<=100000) {
                point.add(x+1);
                map.put(x+1,time+1);
            }
            if(!map.containsKey(x*2)&&(x*2)<=100000) {
                point.add(x*2);
                map.put(x*2,time+1);
            }

        }
        return answer;
    }
}

