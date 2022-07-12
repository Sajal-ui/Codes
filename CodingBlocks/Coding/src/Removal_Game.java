import java.io.IOException;
import java.util.Scanner;

public class Removal_Game {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        long sum=0;
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
            sum+=A[i];
        }
        long[][] dp=new long[n][n];
        for (int i = n-1; i>=0; i--) {
            for (int j = i; j < n; j++) {
                if(i==j){
                    dp[i][j]=A[i];
                }
                else{
                    dp[i][j]=Math.max(A[i]-dp[i+1][j],A[j]-dp[i][j-1]);
                }
            }
        }
        System.out.println((sum+dp[0][n-1])/2);
        sc.close();
    }
}
