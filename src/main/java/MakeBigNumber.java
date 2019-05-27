import java.util.*;
/*

    문제 : 큰 수 만들기

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42883?language=java

    이슈 사항
        1. "10000" , 2 일때 에러발생

        2. 앞에서 부터 count+1 만큼 자른 후 제일 큰 수 앞부분
 */

public class MakeBigNumber {
    public String solution(String number, int k) {
        String answer ="";
        int count =k;
        String temp = number;
        while(true) {
            if(temp.length()==count)
                break;
            String tp = temp.substring(0,count+1);
            int index = 0;
            char num ='/';
            for(int i =0;i<tp.length();i++){
                if(tp.charAt(i)>num){
                    index = i;
                    num = tp.charAt(i);
                }
            }
            answer += num;
            count = count - index;
            temp = temp.substring(index+1);
            if(count == 0){
                answer = answer +temp;
                break;
            }
        }
        return answer;
    }
}
