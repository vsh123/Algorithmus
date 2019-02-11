import java.util.Scanner;

public class TestMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        q2178 test = new q2178();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] maze = new int[N];

        for(int i = 0; i< N;i++){
            maze[i]=sc.nextInt();
        }

        int answer = test.findmaze(N,M,maze);
        System.out.println(answer);
    }
}
