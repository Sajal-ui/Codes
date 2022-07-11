import java.io.IOException;
import java.util.Scanner;

public class GridPaths {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] Grid = new char[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                Grid[i][j] = str.charAt(j);
            }
        }
        int mod=1000000007;
        if (Grid[0][0] == '*') {
            System.out.println(0);
        } else {
            long[][] dp = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Grid[i][j] == '*') {
                        dp[i][j] = 0;
                    }
                    else if(i==0 && j==0){
                        dp[i][j]=1;
                    }
                    else {
                        if (i > 0) {
                            dp[i][j]+=dp[i - 1][j];
                            if(dp[i][j]>=mod){
                                dp[i][j]-=mod;
                            }
                        }
                        if (j > 0) {
                            dp[i][j]+=(dp[i][j - 1]);
                            if(dp[i][j]>=mod){
                                dp[i][j]-=mod;
                            }
                        }
                    }
                }
            }
            System.out.println(dp[n - 1][n - 1]);
        }
        sc.close();
    }
}
