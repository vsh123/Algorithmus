import java.util.*;
import java.io.*;

/*
    문제 : DSLR(BFS)
    문제 출처 : https://www.acmicpc.net/problem/9019
    이슈 사항
    1. 메모리 초과
        -> 한번 탐색했던 숫자는 visit[]에 넣어서 큐에 삽입을 안함

    2. 문제 이해를 제대로 못함
        -> L : n이 0일 때이지 n-1이 0일 때가 아님!

    3. 문제 풀이 속도가 너무 오래걸림
        -> 역추적을 이용하라는데 확인해봐야 할듯
        -> 큐에는 int만 넣고 char 배열에다 DSLR 삽입 후 숫자 찾으면 역추적으로 문자열 출력하게 했는데도 시간이 너무 오래걸림...
        -> substring이 문제였음!!!!!!!!!!
            Left push는 d1(num/1000)해주면 되고 d2 d3 d4(num%1000)*10
            Right push는 d1 d2 d3(num/10) d4(num%10)*1000
 */

public class q9019 {
    public void getDSLR(){
        List<String> answer = new ArrayList<String>();
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            for(int i = 0; i<N;i++) {
                st = new StringTokenizer(bf.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                answer.add(findDSLR(A,B));
            }
            for(int i = 0; i< answer.size();i++){
                System.out.println(answer.get(i));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String findDSLR(int A, int B){
        int[] visit = new int[10000];
        char[] visits = new char[10000];
        for(int i =0; i<10000;i++){
            visit[i] = 10000;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(A);
        visit[A] = -1;

        while(!q.isEmpty()){
            int num = q.poll();

            if(num == B){
                String s = "";
                int find = num;
                while(true){
                    s = visits[find] + s;
                    find = visit[find];
                    if(find == A)
                        break;
                }
                return s;
            }
            int Dnum = (2*num)%10000;
            int Snum = num-1;
            if(num == 0)
                Snum = 9999;
            int Lnum = (num%1000)*10 + num/1000;
            int Rnum = (num%10)*1000 + num/10;
            if(visit[Dnum] == 10000) {
                q.offer(Dnum);
                visit[Dnum] = num;
                visits[Dnum] = 'D';
            }

            if(visit[Snum] == 10000) {
                q.offer(Snum);
                visit[Snum] = num;
                visits[Snum] = 'S';
            }

            if(visit[Lnum] == 10000) {
                q.offer(Lnum);
                visit[Lnum] = num;
                visits[Lnum] = 'L';
            }

            if(visit[Rnum] == 10000) {
                q.offer(Rnum);
                visit[Rnum] = num;
                visits[Rnum] = 'R';
            }
        }
        return "1";
    }
}

class stringnum{
    String name;
    int num;
    public stringnum(String name, int num){
        this.name =name;
        this.num = num;
    }
}
