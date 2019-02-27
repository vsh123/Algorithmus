import java.util.*;

public class BestAlbum {

    Comparator<rank> Compcount = new Comparator<rank>() {
        @Override
        public int compare(rank o1, rank o2) {
            System.out.println(o1.count + " " +o2.count);
            return o1.count-o2.count;
        }
    };

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Map<String,rank> map = new HashMap<String,rank>();
        List<rank> list = new LinkedList<rank>();

        for(int i = 0; i < genres.length;i++){
            if(map.containsKey(genres[i])){
                if(map.get(genres[i]).first!=-1&&plays[map.get(genres[i]).first]<plays[i]){
                   map.put(genres[i],new rank(i, map.get(genres[i]).first,map.get(genres[i]).count + plays[i]));
                }
                else if(map.get(genres[i]).first==-1){
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

        answer = new int[list.size()*2];

        Collections.sort(list, Compcount);

        for(String key : map.keySet()){
            System.out.println(key + " " +map.get(key).count );
        }

        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).first);
            System.out.println(list.get(i).second);
            answer[i*2] = list.get(i).first;
            answer[i*2+1] = list.get(i).second;
        }

        return answer;
    }


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
}
