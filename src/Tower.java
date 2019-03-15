import java.util.*;

/*

    문제 : 탑

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42588?language=java

    이슈 사항
        1.

 */

public class Tower {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i = 0;i<answer.length;i++){
            int result=0;
            for(int j=i-1;j>=0;j--){
                if(heights[i]<heights[j]) {
                    result = j + 1;
                    break;
                }
            }
            answer[i]= result;
        }
        return answer;
    }
}
