import java.util.*;

/*

    문제 : 가장 큰 수

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42746?language=java

    이슈 사항
        1. 그냥 두 수 붙여서 큰 값대로 정렬하면 되는 문제였는데 너무 어렵게 생각함.

 */

public class MostBigNum {

    Comparator<String> Compnum = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            String x = a+b;
            String y = b+a;
            return Integer.parseInt(y) - Integer.parseInt(x);
        }
    };

    public String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        for(int i =0;i<num.length;i++) {
            num[i] =  String.valueOf(numbers[i]);
        }
        Arrays.sort(num,Compnum);
        if(num[0].charAt(0)=='0')
            return "0";
        for(int i =0;i<num.length;i++){
            answer = answer+num[i];
        }
        return answer;
    }
}
