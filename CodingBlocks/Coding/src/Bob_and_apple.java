import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bob_and_apple {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int test = 0; test < t; test++) {
            String[] arr = reader.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            long[][][] dp = new long[n + 1][m + 1][2];
            int[] weight = new int[n];
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                arr = reader.readLine().split(" ");
                values[i] = Integer.parseInt(arr[0]);
                weight[i] = Integer.parseInt(arr[1]);
            }
            for (int i = 0; i <= n; i++) {
                dp[i][0][0] = dp[i][0][1] = 0L;
            }
            for (int i = 0; i <= m; i++) {
                dp[0][i][0] = dp[0][i][1] = 0L;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    for (int k = 1; k >= 0; k--) {
                        if (k == 0) {
                            if (j >= weight[i - 1]) {
                                dp[i][j][k] = Math.max(values[i - 1] + dp[i - 1][j - weight[i - 1]][k],
                                        Math.max(dp[i - 1][j][k],
                                                values[i - 1] + dp[i - 1][j - (weight[i - 1] / 2)][k + 1]));
                            } else {
                                if (j >= weight[i - 1] / 2) {
                                    dp[i][j][k] = Math.max(values[i - 1] + dp[i - 1][j - (weight[i - 1] / 2)][k + 1],
                                            dp[i - 1][j][k]);
                                } else {
                                    dp[i][j][k] = dp[i - 1][j][k];
                                }
                            }
                        } else {
                            if (j >= weight[i - 1]) {
                                dp[i][j][k] = Math.max(values[i - 1] + dp[i - 1][j - weight[i - 1]][k],
                                        dp[i - 1][j][k]);
                            } else {
                                dp[i][j][k] = dp[i - 1][j][k];
                            }
                        }
                    }
                }
            }
            System.out.println(Math.max(dp[n][m][0], dp[n][m][1]));
        }
    }
}
