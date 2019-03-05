import java.util.*;

/*

    문제 : 소수 찾기

    출처 : https://programmers.co.kr/learn/courses/30/lessons/42839?language=java

    이슈 사항
        1. 에라토스테네스의 체 사용
        2. 만들 수 있는 모든 수를 어떻게 구성할것인지 -> DFS이용해서
        3. List에서도 contains 사용 가능

 */

public class FindDecimal {
    List<Integer> a = new ArrayList<Integer>();
    char[] num;

    public int solution(String numbers) {
        int answer = 0;
        num = new char[numbers.length()];
        boolean[] visit = new boolean[numbers.length()];
        for(int i =0;i<num.length;i++){
            num[i] = numbers.charAt(i);
        }

        for(int i =1;i<=num.length;i++){
            makenum("",i, visit);
        }

        Collections.sort(a);
        boolean[] decimal = new boolean[a.get(a.size()-1)+1];
            if(decimal.length>1)
                decimal[1] = true;
            decimal[0] = true;

            for(int i=2;i<decimal.length;i++){
                for(int j =i*2; j<decimal.length;j=j+i){
                    decimal[j] = true;
                }
        }

        for(int i =0;i<a.size();i++){
            if(!decimal[a.get(i)])
                answer++;
        }

        return answer;
    }

    public void makenum(String temp, int depth,boolean[] visit){
        if(depth==0) {
            int tp = Integer.parseInt(temp);
            if(!a.contains(tp))
                a.add(tp);
            return;
        }
        for(int i =0;i<visit.length;i++){
            if(!visit[i]){
                visit[i] = true;
                int dep = depth-1;
                makenum(temp+num[i],dep,visit);
                visit[i] = false;
            }
        }
    }
}
