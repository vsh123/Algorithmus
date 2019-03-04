import java.util.*;

/*

    문제 : H-Index

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42747?language=java

    이슈 사항
        1.

 */

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i =citations.length-1;i>=0;i--){
            if((citations.length-i)>=citations[i]){
                return citations[i];
            }
        }
        return answer;
    }
}
