package BaeMin;

public class test1 {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        int x;
        int y;
        if(v[0][0] == v[1][0])
            x= v[2][0];
        else if(v[0][0] == v[2][0])
            x = v[1][0];
        else
            x = v[0][0];

        if(v[0][1] == v[1][1])
            y= v[2][1];
        else if(v[0][1] == v[2][1])
            y = v[1][1];
        else
            y = v[0][1];

        answer[0] = x;
        answer[1] = y;

        return answer;
    }
}
