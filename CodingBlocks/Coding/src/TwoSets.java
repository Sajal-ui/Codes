import java.io.IOException;
import java.util.Scanner;

public class TwoSets {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = (n * (n + 1) / 2);
        if (sum % 2 != 0) {
            System.out.println(0);
        } else {
            sum=sum/2;
            int[][] dp = new int[n + 1][sum + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= sum; i++) {
                dp[0][i] = 0;
            }
            int mod = 1000000007;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= i) {
                        dp[i][j] += dp[i - 1][j - i];
                        if (dp[i][j] >= mod) {
                            dp[i][j] -= mod;
                        }
                    }
                }
            }
            System.out.println(dp[n][sum] / 2);
        }
        sc.close();
    }
}
