package Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Card {
    public static void run() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String ans = st.nextToken();                            //String 입력 받음
            int num = Integer.parseInt(ans);
            HashMap<String, Integer> cardSet = new HashMap<>();
            for (int i = 0; i < num; i++) {
                String card = new StringTokenizer(bf.readLine()).nextToken();
                if (cardSet.containsKey(card)) {
                    cardSet.put(card, cardSet.get(card) + 1);
                    continue;
                }
                cardSet.put(card, 1);
            }
            int maxNum = 0;
            String answer = "";
            for (String key : cardSet.keySet()) {
                int count = cardSet.get(key);
                if (count < maxNum) {
                    continue;
                }
                if ((count == maxNum)) {
                    if (Long.parseLong(answer) < Long.parseLong(key)) {
                        continue;
                    }
                }
                maxNum = count;
                answer = key;
            }
            System.out.println(Long.parseLong(answer));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
