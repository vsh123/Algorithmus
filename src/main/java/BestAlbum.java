import java.util.*;

/*

    문제 : 베스트앨범

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42579?language=java

    이슈 사항
        1. o1 - o2 -> 오름차순
           o2 - o1 -> 내림차순

 */

public class BestAlbum {
    class rank{
        int first;
        int second;
        int count;
        public rank(int first,int second, int count){
            this.first = first;
            this.second = second;
            this.count = count;
        }
    }

    Comparator<rank> CompCount = new Comparator<rank>() {
        @Override
        public int compare(rank o1, rank o2) {
            return o2.count - o1.count;
        }
    };

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Map<String,rank> map = new HashMap<String,rank>();
        List<rank> list = new LinkedList<rank>();
        List<Integer> ans = new ArrayList<Integer>();

        for(int i = 0; i < genres.length;i++){
            if(map.containsKey(genres[i])){
                if(map.get(genres[i]).first!=-1&&plays[map.get(genres[i]).first]<plays[i]){
                   map.put(genres[i],new rank(i, map.get(genres[i]).first,map.get(genres[i]).count + plays[i]));
                }
                else if(map.get(genres[i]).second==-1){
                    map.put(genres[i],new rank(map.get(genres[i]).first, i,map.get(genres[i]).count + plays[i]));
                }
                else if(map.get(genres[i]).second!=-1&&plays[map.get(genres[i]).second]<plays[i]){
                    map.put(genres[i],new rank(map.get(genres[i]).first, i,map.get(genres[i]).count + plays[i]));
                }
                else{
                    map.put(genres[i],new rank(map.get(genres[i]).first, map.get(genres[i]).second,map.get(genres[i]).count + plays[i]));
                }
            }
            else{
                map.put(genres[i],new rank(i, -1, plays[i]));
            }
        }

        for(String key : map.keySet()){
           System.out.println(key + " " +map.get(key).count );
            list.add(new rank(map.get(key).first,map.get(key).second,map.get(key).count));
        }

        for(int i = 0; i< list.size();i++){
//            System.out.println(list.get(i).count);
        }

        answer = new int[list.size()*2];

        list.sort(CompCount);

//        System.out.println();

        for(int i = 0; i< list.size();i++){
//            System.out.println(list.get(i).count);
        }

        for(int i = 0;i<list.size();i++){
            ans.add(list.get(i).first);
            if(list.get(i).second!=-1)
                ans.add(list.get(i).second);
        }
        answer = new int[ans.size()];
        System.out.println("--------------------------");
        for(int i =0; i<ans.size();i++){
            System.out.println(ans.get(i));
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
