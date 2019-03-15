import java.util.*;
/*

    문제 : 디스크 컨트롤러

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42627?language=java

    이슈 사항
        1. 순서를 어떻게 정렬할지 잘 고민해보자.


 */

public class DiskController {
    Comparator<int[]> CompInt = new Comparator<int[]>() {   //요청 시점 기준 오름차순 정렬
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[1]!=o2[1])
                return o1[1]-o2[1];
            else
                return o1[0]- o2[0];
    }
};


class Disk{
    int time;
    int work;

    public Disk(int time,int work){
        this.time = time;
        this.work = work;
    }

}


    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int all = 0;
        int size =0;
        Arrays.sort(jobs,CompInt);
        List<Disk> list = new ArrayList<Disk>();

        for(int i =0;i<jobs.length;i++){
            list.add(new Disk(jobs[i][0],jobs[i][1]));
        }

        while(!list.isEmpty()) {
            for(int i =0;i<list.size();i++){
                if(time>=list.get(i).time){
                    time = time + list.get(i).work;
                    all = all + (time-list.get(i).time);
                    list.remove(i);
                    break;
                }
                if(i==list.size()-1)
                    time++;
            }
        }
        answer = all/jobs.length;
        return answer;
    }
}
