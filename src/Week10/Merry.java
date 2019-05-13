package Week10;

/*

    문제 : 결혼

    출처 : https://www.acmicpc.net/problem/5567

    이슈 사항
        1.
 */

import java.util.Scanner;

public class Merry {
    static boolean[][] friends;             //친구 관계를 나타내기 위한 2차원 배열
    static boolean[] invited;               //초대 여부를 확인하기 위한 배열

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        friends = new boolean[n + 1][n + 1];//배열 생성
        invited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {       //만약 친구관계인 경우 true로 설정
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends[a][b] = true;
            friends[b][a] = true;
        }

        for (int i = 1; i <= n; i++) {      //만약 1번(주인공)의 친구라면 invited를 true로 설정
            if (friends[1][i]) {
                invited[i] = true;
                findFriend(i);              //친구의 친구까지 가능하기 때문에 그 친구의 친구들도 탐색
            }
        }

        invited[1] = false;                 //자기 자신은 초대인원에서 제외

        for (int i = 1; i <= n; i++) {
            if (invited[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void findFriend(int x) {
        for (int i = 1; i <= friends.length - 1; i++) {
            if (friends[x][i]) {
                invited[i] = true;
            }
        }
    }
}
