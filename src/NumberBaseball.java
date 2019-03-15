import java.util.*;

/*

    문제 : 숫자 야구

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42841?language=java

    이슈 사항
        1. 111 ~ 999까지 다해보지 뭐
        2. case1 보다 case2가 속도가 조금 더 빨랐음
           -> case1이 반복문의 횟수가 조금더 많음

 */


public class NumberBaseball {
    public int solution(int[][] baseball) {
            int answer = 0;


             //case 1 가능한 모든 수를 List에 삽입 후 비교
/*            List<Integer> number= new ArrayList<Integer>();
            for(int a = 1; a<=9;a++){
                int num = a*100;
                for(int b = 1; b<=9;b++){
                    if(a!=b) {
                        int num2 = num+b*10;
                        for (int c = 1; c <= 9; c++) {
                            if(a!=c && b!=c){
                                int num3 = num2 +c;
                                number.add(num3);
                            }
                        }
                    }
                }
            }

            answer = number.size();
            for(int i =0;i<number.size();i++){
                for(int j=0;j<baseball.length;j++){
                    if((IsStrike(number.get(i),baseball[j][0])!=baseball[j][1]) || (IsBall(number.get(i),baseball[j][0])!=baseball[j][2])){
                        answer--;
                        break;
                    }
                }
            }*/


          //case 2 111 ~ 999 수 중 숫자가 서로 같은 것, 0이 포함된 것들을 제외하고 계산
        for(int i =111;i<1000;i++){
            if((i/100 == (i%100)/10) || (i/100 ==i%10) || ((i%100/10) == i%10) || ((i%100)/10 == 0 || i%10 == 0))
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
