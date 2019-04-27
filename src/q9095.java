import java.util.Scanner;

public class q9095 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[11];
        int count = sc.nextInt();
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i< dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for(int i = 0; i < count; i++){
            int x = sc.nextInt();
            System.out.println(dp[x]);
        }
    }
}
