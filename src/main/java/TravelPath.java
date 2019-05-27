import java.util.*;

/*

    문제 : 여행경로

    출처 : https://programmers.co.kr/learn/courses/30/lessons/43164?language=java

    이슈 사항
        1. DFS
            - 가능한 모든 경로를 String으로 만들어 배열로 저장
            - 해당 배열 sort(Collections)
 */

public class TravelPath {
    String[][] card;
    List<String> s = new ArrayList<String>();
    boolean[] visit;
    public String[] solution(String[][] tickets) {
        String answer ="";
        String[] ans = new String[tickets.length+1];
        visit = new boolean[tickets.length];
        card = tickets;
        answer += "ICN";
        dfs(answer);
        Collections.sort(s);
        for(int i =0;i<ans.length;i++){
            ans[i] = s.get(0).substring(i*3,(i*3)+3);
        }
        return ans;
    }

    public void dfs(String answer){
        if(answer.length() == (card.length+1)*3){
            s.add(answer);
            return;
        }

        String tp = answer.substring(answer.length()-3);
        for(int i = 0; i<card.length;i++){
            if(tp.equals(card[i][0]) && !visit[i]){
                visit[i] = true;
                String temp = answer+card[i][1];
                dfs(temp);
                visit[i] = false;
            }
        }
    }

}
