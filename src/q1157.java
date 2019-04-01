import java.util.*;
import java.io.*;

/*
    문제 : 단어 공부

    문제 출처 : https://www.acmicpc.net/problem/1157

    이슈 사항
    1.

*/


public class q1157 {
    public String AlphaStudy(){
        String answer = "";
        int[] alpha = new int[27];                                  //문자 수량을 담을 배열 생성 1~26만 이용 1 = A, 2 = B .... 26 = Z
        int max =0;
        int idx =0;
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String ans = st.nextToken();                            //String 입력 받음
            for(int i =0;i<ans.length();i++){                       //각 단어 검사
                int temp=0;
                if(ans.charAt(i)<=90)                               //대문자라면(아스키코드 이용)
                    temp = ans.charAt(i) - 64;                      //temp = 해당 문자의 index
                else                                                //소문자라면(아스키코드 이용)
                    temp = ans.charAt(i) - 96;

                alpha[temp]++;                                      //해당 문자 수량 ++
                if(alpha[temp]>max){                                //만약 기존에 max 수량이 지금 수량보다 크다면
                    idx = temp;                                     //인덱스 기억
                    max = alpha[temp];                              //max값 재저장
                    answer = String.valueOf((char)(temp+64));       //answer = 해당 index+64(아스키코드 변환)
                }
                else if(temp!=idx && alpha[temp]==max){             //만약 현재 index랑 기존 max 인덱스랑 다른데 값이 같다면
                    answer = "?";                                   //answer = "?"
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return answer;
    }
}
