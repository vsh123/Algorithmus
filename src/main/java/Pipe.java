
/*
    문제 : 쇠파이프

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42585?language=java

 */

public class Pipe {
    public int solution(String arrangement) {
        int answer = 0;
        int pipe = 0;
        for(int i =0; i < arrangement.length(); i++){
            if(arrangement.charAt(i)=='(' && arrangement.charAt(i+1)!=')'){
                pipe++;
            }
            else if(arrangement.charAt(i)=='(' && arrangement.charAt(i+1)==')'){

                answer=answer+pipe;
            }
            else if(arrangement.charAt(i)==')'&& arrangement.charAt(i-1)!='('){
                pipe--;
                answer++;
            }
        }
        return answer;
    }
}
