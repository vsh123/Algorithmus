import java.util.*;

/*

    문제 : 저울

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42886?language=java

    이슈 사항
        1. 일단 추를 오름 차순으로 정렬
        2. 이 숫자가 가능하냐 안하냐는 어떻게 알지....? -> 점진적으로 해야지 뭐
           -> 다 하면 시간초과남
        3. 오름차순 정렬 -> (1 ~ x-1까지의 합 +1) 이 x보다 작으면 break(저 수를 만들수가 없기 때문에)
 */

public class Scale {
    public int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);
        for(int i =0;i<weight.length;i++){
            if(answer < weight[i])
                break;
            answer = answer+weight[i];
        }
        return answer;
    }
}
