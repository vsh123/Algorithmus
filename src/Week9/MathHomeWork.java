package Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MathHomeWork {
    private static List<String> answer = new ArrayList<>();

    static Comparator<String> mathComp = new Comparator<String>() {
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
            String ans = st.nextToken();
            int num = Integer.parseInt(ans);
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(bf.readLine());
                String word = st.nextToken();
                checkWord(word);
            }
            Collections.sort(answer, mathComp);
            for (String temp : answer) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkWord(String word) {
        String number = "";
        for (int i = 0; i < word.length(); i++) {
            if ((word.charAt(i) >= '0') && (word.charAt(i) <= '9')) {
                number += word.charAt(i);
                continue;
            }
            if (number.length() != 0) {
                answer.add(cutZero(number));
                number = "";
            }
        }
        if (number.length() != 0) {
            answer.add(cutZero(number));
        }
    }

    private static String cutZero(String number) {

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {

                return number.substring(i);
            }
        }
        return "0";
    }
}
