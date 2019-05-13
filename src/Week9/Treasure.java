package Week9;


/*
    문제 : 단지번호붙이기(DFS)

    문제 출처 : https://www.acmicpc.net/problem/1026

    이슈 사항

    1.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Treasure {
    public static void run() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String ans = st.nextToken();                            //String 입력 받음
            int num = Integer.parseInt(ans);
            st = new StringTokenizer(bf.readLine());
            List<Integer> a1 = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                a1.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(bf.readLine());
            List<Integer> b1 = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                b1.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(a1);
            Collections.sort(b1);
            int answer = 0;
            for (int i = 0; i < a1.size(); i++) {
                answer += b1.get(i) * a1.get((num - 1) - i);
            }

            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
