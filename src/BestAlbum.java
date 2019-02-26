import java.util.*;

public class BestAlbum {

    Comparator<song> Compplay = new Comparator<song>() {
        @Override
        public int compare(song o1, song o2) {
            return o1.play-o2.play;
        }
    };

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        int idx =0;
        Map<String,Integer> map = new HashMap<String,Integer>();
        List<song> list = new LinkedList<song>();

        for(int i = 0;i < genres.length; i++){
            if(map.containsKey(genres[i]))
                map.put(genres[i],map.get(genres[i])+plays[i]);
            else
                map.put(genres[i],plays[i]);
        }

        for(String key : map.keySet()){
            list.add(new song(key,map.get(key)));
        }

        answer = new int[2*list.size()];

        list.sort(Compplay);
        for(int i = 0; i< list.size(); i++){
            List<song> temp = new LinkedList<song>();
            for(int j = 0; j < genres.length;j++){
                if(list.get(i).equals())
            }
        }
        return answer;
    }

    class song{
        String name;
        int play;
        public song(String name,int play){
            this.name = name;
            this.play = play;
        }
    }
}
