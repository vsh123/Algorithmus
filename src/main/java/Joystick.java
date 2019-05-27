import java.util.*;
/*

    문제 : 조이스틱

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42860?language=java

    이슈 사항
        1. 기본적으로 알파벳 이동 수는
           a = '알파벳' - 'A'
           b = 26-a
           해서 둘 중 작은 값 삽입
 */

public class Joystick {
    public int solution(String name) {
        int answer = 0;
        boolean[] visit = new boolean[name.length()];
        int count =0;
        int position =0;
        for(int i =0;i<name.length();i++){
            int a = name.charAt(i) - 'A';
            int min = Math.min(a,26-a);
            answer += min;
            if(a==0) {
                visit[i] = true;
                count++;
            }
        }

        while(true){
            if(!visit[position]){
                visit[position] = true;
                count++;
            }
            if(count ==name.length())
                break;

            int right =0;
            int rcount =position;
            int left = 0;
            int lcount = position;
            while(true){
                right++;
                rcount++;
                if(rcount == name.length())
                    rcount =0;
                if(!visit[rcount])
                    break;
            }

            while(true){
                left++;
                lcount--;
                if(lcount == -1)
                    lcount = name.length()-1;
                if(!visit[lcount])
                    break;
            }
            if(right<=left){
//                System.out.println(rcount+" "+right);
                position = rcount;
                answer = answer +right;
            }
            else{
//                System.out.println(lcount+" "+left);
                position = lcount;
                answer = answer +left;
            }

        }
        return answer;
    }
}
