import java.util.*;

/*

    문제 : H-Index

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42747?language=java

    이슈 사항
        1. 문제 이해가 어려웠음 하하하하하

 */

public class H_Index {
    public int solution(int[] citations) {
/*        int answer = 0;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer,smaller);
        }
        return answer;*/
        int answer = 0;
        Arrays.sort(citations);
        if(citations[citations.length- 1] ==0)
            return 0;
        for(int i = citations[citations.length-1]+1;i>0;i--){
            int count =0;
            for(int j = citations.length-1;j>=0;j--){
                if(citations[j]>=i)
                    count++;
                else
                    break;
            }
            if(count>=i)
                return count;
        }
        return answer;
    }
}
