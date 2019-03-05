import java.util.*;

/*

    문제 : 숫자 야구

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42841?language=java

    이슈 사항
        1. 111 ~ 999까지 다해보지 뭐

 */


public class NumberBaseball {
    public int solution(int[][] baseball) {
        int answer = 0;
        for(int i =111;i<1000;i++){
            if((i/100 == (i%100)/10) || i/100 ==i%10)
                continue;
            boolean Isok = true;
            for(int j=0;j<baseball.length;j++){
                if((IsStrike(i,baseball[j][0])==baseball[j][1]) && (IsBall(i,baseball[j][0])==baseball[j][2])){
                    continue;
                }
                else {
                    Isok=false;
                    break;
                }
            }
            if(Isok)
                answer++;
        }
        return answer;
    }

    public int IsStrike(int a,int b){
        int strike =0;
        if(a/100 == b/100)
            strike++;
        if((a%100)/10 == (b%100)/10)
            strike++;
        if(a%10 == b%10)
            strike++;

        return strike;
    }

    public int IsBall(int a, int b){
        int ball =0;
        if((a/100 == (b%100)/10) || (a/100 == b%10))
            ball++;
        if(((a%100)/10  == b/100) || ((a%100)/10  == b%10))
            ball++;
        if((a%10 == b/100) || (a%10 == (b%100)/10))
            ball++;
        return ball;
    }
}
