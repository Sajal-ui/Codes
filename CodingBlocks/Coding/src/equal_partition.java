import java.io.IOException;
import java.util.Scanner;

public class equal_partition {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] A=new int[N];
        int sum=0;
        for (int i = 0; i < N; i++) {
            A[i]=sc.nextInt();
            sum+=A[i];
        }
        if(sum%2!=0){
            System.out.println(false);
        }
        else{
            sum=sum/2;
            boolean[][] dp=new boolean[N+1][sum+1];
            for (int i = 0; i <=N; i++) {
                dp[i][0]=true;
            }
            for (int i = 1; i <=sum; i++) {
                dp[0][i]=false;
            }
            for (int i = 1; i <=N; i++) {
                for (int j = 1; j <=sum; j++) {
                    if(j>=A[i-1]){
                        dp[i][j]=dp[i-1][j] || dp[i-1][j-A[i-1]];
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            System.out.println(dp[N][sum]);
        }
    }
}
