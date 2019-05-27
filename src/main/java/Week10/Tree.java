package Week10;

/*

    문제 : 트리

    출처 : https://www.acmicpc.net/problem/1068

    이슈 사항
        1. 그래프 공부 필요
 */

import java.util.*;

public class Tree {
    static List<ArrayList<Integer>> node = new ArrayList<>();      //자식들을 기억하고 있는 리스트 생성
    static int answer = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int root = 0;
        int[] remem = new int[N];
        for (int i = 0; i < N; i++) {
            node.add(new ArrayList<>());                            //리스트 초기화
        }
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if (parent == -1) {
                root = i;
            }
            if (parent >= 0) {                                      //부모에 자식정보 삽입
                node.get(parent).add(i);
            }
            remem[i] = parent;
        }
        int remove = sc.nextInt();
        if (remove == root) {                                       //만약 루트 노드를 삭제하면 0 출력
            System.out.println("0");
            return;
        }
        node.get(remem[remove]).remove((Integer) remove);           //노드 삭제

        for (int i = 0; i < node.get(root).size(); i++) {           //dfs로 리프 노드까지 탐색
            dfs(node.get(root).get(i));
        }
        if(answer ==0){                                             //만약 루트노드가 자식이 없을경우, dfs가 돌지 않기 때문에 루트노드가 리프노드가 됨
            answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(Integer num) {
        if (node.get(num).size() == 0) {
            answer++;
            return;
        }
        for (int i = 0; i < node.get(num).size(); i++) {
            dfs(node.get(num).get(i));
        }
    }
}