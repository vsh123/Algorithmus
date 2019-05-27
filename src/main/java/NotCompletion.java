import java.util.*;
/*
    문제 : 완주하지 못한 선수

    출처 : 프로그래머스


 */

public class NotCompletion {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < participant.length; i++){
            if(map.containsKey(participant[i])){
                map.put(participant[i],map.get(participant[i])+1);
            }
            else
                map.put(participant[i],1);
        }

        for(int i = 0; i< completion.length;i++){
            if((map.get(completion[i])-1)==0)
                map.remove(completion[i]);
            else{
                map.put(completion[i],map.get(completion[i])-1);
            }
        }
        Set<String> s = map.keySet();
        s.iterator().next();
        String answer = s.iterator().next();
        return answer;
    }
}
