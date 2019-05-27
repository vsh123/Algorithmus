package Week10;
/*
 * 참고 : https://www.crocus.co.kr/764
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SharkDinner {
    static List<Shark> sharks = new ArrayList<>();
    static boolean[] finish;
    static int changeIndex;
    static int nextIndex;
    static int answer = 0;
    static int duplicate = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        finish = new boolean[num];
        for (int i = 0; i < num; i++) {
            int size = sc.nextInt();
            int speed = sc.nextInt();
            int intel = sc.nextInt();
            Shark shark = new Shark(size, speed, intel);
            sharks.add(shark);
        }

        for (int i = 0; i < sharks.size(); i++) {
            for (int j = 0; j < sharks.size(); j++) {
                if (i != j) {
                    compareShark(i, j);
                }
            }
        }

        for (int i = 0; i < sharks.size(); i++) {
            changeIndex = -1;
            nextIndex = 0;
            dfs(i);
            dfs(i);
        }

        answer = num - answer + duplicate/2;
        System.out.println(answer);
    }

    private static boolean dfs(int index) {
        List<Integer> eatList = sharks.get(index).eatList;
        for (int i = nextIndex; i < eatList.size(); i++) {
            int t = eatList.get(i);
            if (i == changeIndex) {
                continue;
            }
            changeIndex = t;
            finish[t] = true;
            if (sharks.get(t).father == -1 || changedfs(sharks.get(t).father)) {
                sharks.get(t).father = index;
                nextIndex = i + 1;
                answer++;
                return true;
            }
        }
        return false;
    }

    private static boolean changedfs(int index) {
        List<Integer> eatList = sharks.get(index).eatList;
        for (int i = nextIndex; i < eatList.size(); i++) {
            int t = eatList.get(i);
            if (finish[t]) {
                continue;
            }
            changeIndex = t;
            finish[t] = true;
            if (sharks.get(t).father == -1 || changedfs(sharks.get(t).father)) {
                sharks.get(t).father = index;
                return true;
            }
        }
        return false;
    }


    private static void compareShark(int i, int j) {
        if (sharks.get(i).compareTo(sharks.get(j)) == 1) {
            sharks.get(i).addEatList(j);
        }
        if (sharks.get(i).compareTo(sharks.get(j)) == -1) {
            sharks.get(i).addEatList(j);
            duplicate++;
        }
    }
}

class Shark implements Comparable<Shark> {
    List<Integer> eatList = new ArrayList<>();
    int size;
    int speed;
    int intel;
    int father = -1;

    Shark(int size, int speed, int intel) {
        this.size = size;
        this.speed = speed;
        this.intel = intel;
    }

    public void addEatList(int index) {
        eatList.add(index);
    }

    @Override
    public int compareTo(Shark o) {
        if ((size == o.size) && (speed == o.speed) && (intel == o.intel)) {
            return -1;
        }
        if ((size >= o.size) && (speed >= o.speed) && (intel >= o.intel)) {
            return 1;
        }

        return 0;
    }
}
