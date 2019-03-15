/*

    문제 : 주식 가격

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42586?language=java

    이슈 사항
        1.

 */

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i =0;i<answer.length;i++){
            int count = 0;
            for(int j = i+1;j<prices.length;j++){
                count++;
                if(prices[i]>prices[j])
                    break;
            }
            answer[i] = count;
        }
        return answer;
    }
}
