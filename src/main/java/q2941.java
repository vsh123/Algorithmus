import java.util.*;
import java.io.*;

/*
    문제 : 크로아티아 알파벳

    문제 출처 : https://www.acmicpc.net/problem/2941

    이슈 사항
    c=
    c-
    dz=
    d-
    lj
    nj
    s=
    z=

*/

public class q2941 {
    public int CroatiaAlpha(){
        int answer = 0;
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String ans = st.nextToken();                            //String 입력 받음
            int idx =0;
            String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};                      //크로아티아 알파벳 저장
            String star = "********";
            String temp =ans;
            while(true){
                String tp = temp.replaceFirst(croatia[idx],star.substring(0,croatia[idx].length())); // 해당 문자가 있다면 *로 변환
                if(temp.equals(tp))          //변환이 안됐다면(변환될게 없다면)
                    idx++;                  //다음 인덱스로 넘어감
                else{                       //변환이 됐다면
                    answer++;               //answer++;
                    temp = tp;
                }
                if(idx == croatia.length)
                    break;
            }

            for(int i =0;i<temp.length();i++){      //*이 아니면 그냥 알파벳이기 때문에 answer++작업 실행
                if(temp.charAt(i) != '*')
                    answer++;
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return answer;
    }
}
