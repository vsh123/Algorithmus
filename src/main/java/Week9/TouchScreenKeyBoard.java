package Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TouchScreenKeyBoard {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    final static char[][] dictionary =
            {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                    {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                    {'z', 'x', 'c', 'v', 'b', 'n', 'm'}};
    static StringBuilder answer = new StringBuilder();

    public static void run() {
        try {
            st = new StringTokenizer(bf.readLine());
            String ans = st.nextToken();                            //String 입력 받음
            int num = Integer.parseInt(ans);
            for (int i = 0; i < num; i++) {
                touchScreen();
            }
            System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static private void touchScreen() {
        try {
            st = new StringTokenizer(bf.readLine());
            String word = st.nextToken();                            //String 입력 받음
            int count = Integer.parseInt(st.nextToken());
            List<DicSet> dicSet = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String name = new StringTokenizer(bf.readLine()).nextToken();
                int distance = checkDistance(word, name);
                dicSet.add(new DicSet(name, distance));
            }
            Collections.sort(dicSet);

            for (DicSet temp : dicSet) {
                answer.append(temp.print());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int checkDistance(String word, String name) {
        int distance = 0;
        int xdistance, ydistance;
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int y = 0; y < dictionary.length; y++) {
                for (int x = 0; x < dictionary[y].length; x++) {
                    if (word.charAt(i) == dictionary[y][x]) {
                        x1 = x;
                        y1 = y;
                    }
                    if (name.charAt(i) == dictionary[y][x]) {
                        x2 = x;
                        y2 = y;
                    }
                }
            }
            xdistance = Math.abs(x1 - x2);
            ydistance = Math.abs(y1 - y2);
            distance += (xdistance + ydistance);
        }
        return distance;
    }
}

class DicSet implements Comparable<DicSet> {
    private String name;
    private int distance;

    DicSet(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    String print() {
        return (name + " " + distance + "\n");
    }

    private int compareName(String name) {
        return name.compareTo(this.name);
    }

    private int compareDistance(int distance) {
        return distance - this.distance;
    }

    private boolean checkDistance(int distance) {
        return this.distance == distance;
    }

    @Override
    public int compareTo(DicSet o) {
        if (o.checkDistance(this.distance)) {
            return o.compareName(this.name);
        }
        return o.compareDistance(this.distance);
    }
}
