package Week10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

    문제 : 거짓말

    출처 : https://www.acmicpc.net/problem/1043

    이슈 사항
        1.
 */

public class Lie {
    static int[][] party;
    static boolean[] impossible;
    static List<Integer> truth = new ArrayList<>();

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        party = new int[M + 1][N + 1];      //파티 수 * 참가자 수의 배열 생성
        impossible = new boolean[M + 1];
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {     //진실을 아는 사람들의 List 생성
            truth.add(sc.nextInt());
        }

        for (int i = 1; i <= M; i++) {
            int temp = sc.nextInt();
            for (int j = 0; j < temp; j++) {
                int user = sc.nextInt();
                party[i][user] = 1;         //참가자들 배열에 삽입(1로 설정)
            }
        }

        for (int i = 0; i < truth.size(); i++) {    //진실을 아는 사람들을 대상으로 for문 실시
            for (int j = 1; j <= M; j++) {          //만약 진실을 아는 사람들이 파티에 들어가있다면 같은 파티 사람들을
                if (party[j][truth.get(i)] == 1) {  //진시을 아는 사람들에 추가
                    impossible[j] = true;
                    fillTruth(j);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < impossible.length; i++) {//진실을 아는 사람들이 없는 파티들에 대해서 count
            if (!impossible[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void fillTruth(int j) {          //진실을 아는 사람들에 추가하는 메소드
        for (int i = 1; i < party[j].length; i++) {
            if (party[j][i] == 1 && !truth.contains(i)) {
                truth.add(i);
            }
        }
    }
}
