import java.util.*;
import java.io.*;

/*
    문제 : 로또(DFS)

    문제 출처 : https://www.acmicpc.net/problem/6603

    이슈 사항

    1. main문에서는 메소드 호출만 실시합니다.
 */



public class q6603 {
    int[] ans;
    boolean[] visit;
    int num;
    public void getlotto(){                      //입력 받는 과정
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            while(true) {                       // 0이 입력될때 까지 반복
                st = new StringTokenizer(bf.readLine());
                int k = Integer.parseInt(st.nextToken());
                num = k;
                if(k==0)
                    break;
                ans = new int[k];
                for(int i =0;i<k;i++){
                    ans[i] =Integer.parseInt(st.nextToken());
                }
                visit = new boolean[k];
                for(int i =0;i<=k-6;i++){         //사전 순이므로 첫번째 올 수 있는 수는 0번 째부터 k-6번째까지 밖에 없음(6개를 맞춰야 하기 때문)
                    List<Integer> a = new ArrayList<Integer>();
                    a.add(ans[i]);
                    dfs(i, a);
                }
                System.out.println();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void dfs(int idx, List<Integer> a){
        if(a.size()==6){                        // 6개가 됐다면 출력하고 리턴
            for(int i =0;i<a.size();i++){
                System.out.print(a.get(i)+ " ");
            }
            System.out.println();
            return;
        }

        for(int i =idx+1;i<=num-(6-a.size());i++){  //35번째 줄과 마찬가지로 마지막이 idx였으니 현재 위치는 idx+1부터 num-(6-a.size())까지의 수를 넣을 수 있음
            a.add(ans[i]);
            dfs(i,a);
            a.remove(a.size()-1);
        }

        return;
    }
}
