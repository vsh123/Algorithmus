package Graph;

import  java.util.*;

/*

    문제 : 가장 먼 노드

    출처 : https://programmers.co.kr/learn/courses/30/lessons/49189?language=java

    이슈 사항
        1. 20000*20000 배열에서 메모리 초과
 */

public class SoLongNode {

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] node = new int[n+1];
        boolean[] visit = new boolean[n+1];
        int dep =0;
        visit[0] = visit[1] = true;
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i= 0;i<edge.length;i++){
            int a = edge[i][0];
            int b = edge[i][1];
            if(a== 1)
                node[b] = 1;
            if(b==1)
                node[a] = 1;
        }

        for(int i =1;i<=n;i++){
            if(node[i]==1) {
                q.offer(i);
                visit[i] =true;
            }
        }

        while(!q.isEmpty()){
            int x = q.poll();
            dep = node[x];
            for(int i= 0;i<edge.length;i++){
                int a = edge[i][0];
                int b = edge[i][1];
                if(a == x && !visit[b]){
                    node[b] = node[x] +1;
                    visit[b] = true;
                    q.offer(b);
                }
                if(b == x && !visit[a]){
                    node[a] = node[x] +1;
                    visit[a] = true;
                    q.offer(a);
                }

            }

        }

        for(int i =1;i<=n;i++){
            if( node[i] == dep)
                answer++;
        }


        return answer;
    }

}
