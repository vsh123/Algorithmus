import java.util.*;

/*

    문제 : 모의 고사

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42840?language=java

    이슈 사항
        1.

 */

public class MockExam {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] point = new int[3];
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        for(int i =0;i<answers.length;i++){
            int a1 = a[i%a.length];
            int b1 = b[i%b.length];
            int c1 = c[i%c.length];
            if(a1 == answers[i])
                point[0]++;
            if(b1 == answers[i])
                point[1]++;
            if(c1 == answers[i])
                point[2]++;
        }
        int max = Math.max(point[0],Math.max(point[1],point[2]));
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = 0;i<3;i++){
            if(point[i] ==max)
                temp.add(i+1);
        }

        answer = new int[temp.size()];
        for(int i =0;i<temp.size();i++){
            answer[i] = temp.get(i);
        }
        return answer;
    }
}
