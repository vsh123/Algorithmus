package kvpstudy.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P5622 {
    public static void main(String[] args) {
        input();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int ans = answer(input);
        System.out.println(ans);
    }

    public static int answer(String input) {
        List<Dial> dials = new ArrayList<>();
        int time = 0;
        initialize(dials);
        for (int i = 0; i < input.length(); i++) {
            for (Dial dial : dials) {
                if (dial.contains(input.charAt(i))) {
                    time += dial.getTime();
                    break;
                }
            }
        }
        return time;
    }

    private static void initialize(List<Dial> dials) {
        dials.add(new Dial(2, "ABC", 3));
        dials.add(new Dial(3, "DEF", 4));
        dials.add(new Dial(4, "GHI", 5));
        dials.add(new Dial(5, "JKL", 6));
        dials.add(new Dial(6, "MNO", 7));
        dials.add(new Dial(7, "PQRS", 8));
        dials.add(new Dial(8, "TUV", 9));
        dials.add(new Dial(9, "WXYZ", 10));
    }
}

class Dial {
    private int number;
    private String alphabets;
    private int time;

    public Dial(int number, String alphabets, int time) {
        this.number = number;
        this.alphabets = alphabets;
        this.time = time;
    }

    public boolean contains(char c) {
        return alphabets.contains(String.valueOf(c));
    }

    public int getTime() {
        return time;
    }
}
