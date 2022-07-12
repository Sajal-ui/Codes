import java.io.IOException;
import java.util.Scanner;

public class Zero_One_Knapsackgfg {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int W=sc.nextInt();
        int[] val=new int[n];
        int[] wt=new int[n];
        for (int i = 0; i < n; i++) {
            val[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wt[i]=sc.nextInt();
        }
        int[][] dp=new int[n+1][W+1];
        for (int i = 0; i <=n; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <=W; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=W; j++) {
                dp[i][j]=dp[i-1][j];
                if(j>=wt[i-1]){
                    dp[i][j]=Math.max(dp[i][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        System.out.println(dp[n][W]);
        sc.close();
    }
}
