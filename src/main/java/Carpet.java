/*

    문제 : 카펫

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42842?language=java

    이슈 사항
        1. 빨간색 기준으로 우선 맞추고, 테두리를 나중에 구성
        2. width 구할 때 red%i가 0이 아니면 해당 계산은 이루어지지 않음.

 */


public class Carpet {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        for(int i =1; i<=red;i++){
            if(red%i!=0)
                continue;
            int width = red/i;
            int bheight = i+2;
            int bwidth = width+2;
            if(((bheight*bwidth)-red) == brown){
                answer[0] = bwidth;
                answer[1] = bheight;
                return answer;
            }

        }
        return answer;
    }
}
