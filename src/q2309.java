import java.util.*;
import java.io.*;

/*
    문제 : 일곱 난쟁이

    문제 출처 : https://www.acmicpc.net/problem/2309

    이슈 사항
    1. 9C7 = 9C2
 */

public class q2309 {

    public void getnum(){
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int[] num = new int[9];
            int sum = 0;
            for(int i=0;i<num.length;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                num[i] = Integer.parseInt(st.nextToken());
                sum+=num[i];
            }

            Arrays.sort(num);

            for(int i = 0; i< num.length;i++){
                for(int j = 0; j < num.length;j++){
                    if(sum - num[i] - num[j] == 100){
                        for(int k=0;k<num.length;k++){
                            if(k!=i&&k!=j) {
                                System.out.println(num[k]);
                            }
                        }
                        return;
                    }
                }
            }

        }catch(IOException e){
            e.printStackTrace();;
        }
    }
}
