import java.io.IOException;
import java.util.Scanner;

public class Counting_towers {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long[][] dp = new long[1000001][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        int mod = 1000000007;
        for (int i = 2; i <= 1000000; i++) {
            long d1 = ((dp[i - 1][0] % mod) * 4) % mod;
            dp[i][0] = (d1 + dp[i - 1][1] % mod) % mod;
            long d2 = ((dp[i - 1][1]) % mod * 2) % mod;
            dp[i][1] = (d2 + dp[i - 1][0] % mod) % mod;
        }
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            System.out.println((dp[n][0] % mod + dp[n][1] % mod) % mod);
            t--;
        }
        sc.close();
    }
}
