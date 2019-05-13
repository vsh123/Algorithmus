package Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
    문제 : 단어 정력

    문제 출처 : https://www.acmicpc.net/problem/1181

    이슈 사항

    1.
 */

public class WordSort {
    private static Comparator<String> dictionSort = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        }
    };

    public static void run() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String ans = st.nextToken();                            //String 입력 받음
            int num = Integer.parseInt(ans);
            List<String> dictionary = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                dictionary.add(new StringTokenizer(bf.readLine()).nextToken());
            }
            dictionary = dictionary.stream()
                    .distinct()
                    .sorted(dictionSort)
                    .collect(Collectors.toList());
            for(String a:dictionary){
                System.out.println(a);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
