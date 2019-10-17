package kvpstudy.week1;

/*
 * 제목 : 토너먼트
 * 주소 : https://www.acmicpc.net/problem/1057
 * */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1057 {
    public static void main(String[] args) {
        input();
    }

    //입력부
    public static int input() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<Integer> rounds = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int ans = answer(rounds);
        System.out.println(ans);
        return ans;
    }

    public static int answer(List<Integer> rounds) {
        int jimin = rounds.get(1);
        int hansu = rounds.get(2);
        int round = 1;
        do {
            if (isMatched(jimin, hansu)) {
                return round;
            }
            jimin = (jimin / 2) + (jimin % 2);
            hansu = (hansu / 2) + (hansu % 2);
            round++;
        } while (jimin != hansu);
        //???????????????????????????
        return -1;
    }

    private static boolean isMatched(int jimin, int hansu) {
        if (Math.abs(jimin - hansu) != 1) {
            return false;
        }
        if (jimin > hansu && (jimin % 2) != 0) {
            return false;
        }
        if (hansu > jimin && (hansu % 2) != 0) {
            return false;
        }
        return true;
    }
}
