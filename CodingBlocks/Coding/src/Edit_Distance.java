import java.io.IOException;
import java.util.Scanner;

public class Edit_Distance {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        int n=str1.length();
        int m=str2.length();
        int[][] dp=new int[n+1][m+1];
        dp[0][0]=0;
        for (int i = 1; i <=n; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i <=m; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int s1=dp[i-1][j];
                    int s2=dp[i-1][j-1];
                    int s3=dp[i][j-1];
                    dp[i][j]=Math.min(s1,Math.min(s2,s3))+1;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
