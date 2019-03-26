package DynamicProgramming;

/*

    문제 : 서울에서 경산까지

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42899?language=java

    이슈 사항
        1. memo[i-1][j-travel[i-1][2]] 이게 0이면 안됨 -> 전거를 거치지 않았다는 뜻
           https://hrothgar.tistory.com/55
 */

public class FromSeuolToGyeongSan {
    public int solution(int K, int[][] travel) {
        int answer = 0;
        int len = travel.length;
        int[][] memo = new int[len+1][K+1];

        for(int i=0;i<K+1;i++){
            memo[1][i] = Math.max(i<travel[0][2]?0:travel[0][3],i<travel[0][0]?0:travel[0][1]);
        }
        for(int i =2;i< len+1;i++){
            for(int j=0;j<K+1;j++){
                if(j>=travel[i-1][2] && j>=travel[i-1][0] && memo[i-1][j-travel[i-1][2]]!=0 && memo[i-1][j-travel[i-1][0]] !=0)
                    memo[i][j] = Math.max(memo[i-1][j-travel[i-1][2]] + travel[i-1][3],memo[i-1][j-travel[i-1][0]] + travel[i-1][1]);
                else if(j>=travel[i-1][2] && memo[i-1][j-travel[i-1][2]]!=0)
                    memo[i][j] = memo[i-1][j-travel[i-1][2]] + travel[i-1][3];
                else if(j>=travel[i-1][0] && memo[i-1][j-travel[i-1][0]] !=0)
                    memo[i][j] = memo[i-1][j-travel[i-1][0]] + travel[i-1][1];
            }
        }
        answer = memo[len][K];

        return answer;
    }

}
