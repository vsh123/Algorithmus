import java.util.*;
/*

    문제 : 단속카메라

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42884?language=java
    이슈 사항
        1. 진입 지점 기준으로 오름차순 정렬해서 계산해야함 그렇지 않으면 꼬임..왜지
            ->[[-2,-1], [1,2],[-3,0]] 일 때 정렬안하면 성공 못함
        2. 이차원 배열 정렬하는 법 이해하기

 */


public class CatchCamera {
    Comparator<int[]> Compstart = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    };

    public int solution(int[][] routes) {
        int answer = 0;
        boolean[] visit = new boolean[routes.length];
        Arrays.sort(routes,Compstart);

        for(int i =0;i<routes.length;i++){
            if(!visit[i]){
                visit[i] = true;
                int start = routes[i][0];
                int end = routes[i][1];
                for(int j =i; j<routes.length;j++){
                    if(!visit[j] && (routes[j][0]<=end)){
                        visit[j] = true;
                        start = Math.max(start, routes[j][0]);
                        end = Math.min(end, routes[j][1]);
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}
