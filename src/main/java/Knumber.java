import java.util.*;

/*

    문제 : K번째수

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42748?language=java

    이슈 사항
        1.

 */

public class Knumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < answer.length;i++){
            int[] temp = new int[commands[i][1] - commands[i][0]+1];
            for(int j = 0; j<temp.length;j++){
                temp[j] = array[commands[i][0]-1+j];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] -1];
        }

        return answer;
    }
}
