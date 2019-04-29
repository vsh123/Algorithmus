package Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NumberOfLand {
    static List<Integer> answer = new ArrayList<>();
    static int[] moveX = {1, -1, 0, 0, 1, 1, -1, -1};   //오른쪽, 왼쪽 , 아래, 위
    static int[] moveY = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[][] maze;

    public static void run() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (x == 0 && y == 0) {
                    break;
                }
                maze = new int[y][x];
                for (int y1 = 0; y1 < y; y1++) {
                    st = new StringTokenizer(bf.readLine());
                    for (int x1 = 0; x1 < x; x1++) {
                        int temp = Integer.parseInt(st.nextToken());
                        maze[y1][x1] = temp;
                    }
                }
                int count = 0;
                for (int y1 = 0; y1 < y; y1++) {
                    for (int x1 = 0; x1 < x; x1++) {
                        if (maze[y1][x1] == 1) {
                            maze[y1][x1] = 2;
                            findLand(y1, x1);
                            count++;
                        }
                    }
                }
                answer.add(count);
            }
            for(int x : answer){
                System.out.println(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findLand(int y, int x) {
        for (int i = 0; i < 8; i++) {
            int newX = x + moveX[i];
            int newY = y + moveY[i];
            if (newX >= 0 && newX < maze[0].length && newY >= 0 && newY < maze.length) {
                if (maze[newY][newX] == 1) {
                    maze[newY][newX] = 2;
                    findLand(newY, newX);
                }
            }
        }
    }
}
