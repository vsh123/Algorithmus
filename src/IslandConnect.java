import java.util.*;
/*

    문제 : 섬 연결하기

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42861?language=java

    이슈 사항
        1. Spanning Tree, 최소 비용 신장트리
        2. 크루스칼 알고리즘 만들어보자
            - 간선을 가중치 기준 오름차순 정렬
            - 순서대로 사이클을 이루는 지 검사
            참고 : https://gmlwjd9405.github.io/2018/08/29/algorithm-kruskal-mst.html
        3. 사이클 검사 오오오오(트리공부..)
 */

public class IslandConnect {
    int[] root;
    int[] rank;
    Comparator<int[]> Compcost = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2];
        }
    };

    public int solution(int n, int[][] costs) {
        root=new int[n];
        rank=new int[n];
        for(int i =0;i<n;i++){
            root[i] = i;
            rank[i] = 0;
        }
        Arrays.sort(costs,Compcost);
        int cost =0;
        for(int i =0;i<costs.length;i++){
            int a = costs[i][0];
            int b = costs[i][1];
            if(!iscircle(a,b)){
                cost = cost+costs[i][2];
                union(a,b);
            }
        }
        return cost;
    }

    public int find(int x){
        if(root[x] ==x){
            return x;
        }
        else{
            return root[x] = find(root[x]);
        }
    }

    void union(int x,int y){
        x=find(x);
        y=find(y);

        if(rank[x] < rank[y]){
            root[x] =y;
        }else {
            root[y] = x;
            if (rank[x] == rank[y])
                rank[x]++;
        }
    }

    boolean iscircle(int x,int y){
        x=find(x);
        y=find(y);

        if(x==y)
            return true;

        return false;
    }

}
