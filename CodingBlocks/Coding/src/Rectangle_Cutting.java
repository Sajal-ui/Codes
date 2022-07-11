import java.io.IOException;
import java.util.Scanner;

public class Rectangle_Cutting {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int[][] dp=new int[a+1][b+1];
        for(int i=1;i<=a;i++){
            for (int j = 1; j <=b; j++) {
                if(i==j){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=Integer.MAX_VALUE;
                    for (int j2 = 1; j2 < i; j2++) {
                        dp[i][j]=Math.min(dp[i][j],dp[j2][j]+dp[i-j2][j]+1);
                    }
                    for (int j2 = 1; j2 < j; j2++) {
                        dp[i][j]=Math.min(dp[i][j],dp[i][j2]+dp[i][j-j2]+1);
                    }
                }
            }
        }
        System.out.println(dp[a][b]);
        sc.close();
    }
}
