import java.util.Scanner;

public class q1003 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        int[][] dp = new int[41][2];
        int count = sc.nextInt();
        dp[0][0] = 1;
        dp[1][1] = 1;
        for(int i = 2; i< dp.length; i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for(int i = 0; i < count; i++){
            int x = sc.nextInt();
            System.out.println(dp[x][0]+" "+dp[x][1]);
        }
    }
}
