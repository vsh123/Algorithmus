import java.util.*;

/*

    문제 : 단어 변환

    출처 : https://programmers.co.kr/learn/courses/30/lessons/43163?language=java

    이슈 사항
        1. NFS(큐)

 */

public class WordChange {
    class wordSet{
        String word;
        int count;
        public wordSet(String word,int count){
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<wordSet> q = new LinkedList<wordSet>();
        q.offer(new wordSet(begin,0));
        boolean[] visit = new boolean[words.length];

        while(!q.isEmpty()){
            wordSet temp = q.poll();
            String tword = temp.word;
            int tcount = temp.count;
            if(tword.equals(target)){
                return tcount;
            }
            for(int i =0 ; i<words.length;i++){
                if(!visit[i]){
                    String t = words[i];
                    int cnt = 0;
                    for(int j = 0;j<t.length();j++){
                        if(tword.charAt(j)!=t.charAt(j))
                            cnt++;
                        if(cnt >1)
                            break;
                    }
                    if(cnt == 1){
                        visit[i] = true;
                        q.offer(new wordSet(t,tcount+1));
                    }
                }
            }
        }

        return answer;
    }
}
