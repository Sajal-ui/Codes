import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BookShop {
    static int Get_Ans(int[][] dp,int[] price,int[] pages,int n,int x){
        if(n==0){
            return 0;
        }
        if(dp[n][x]!=-1){
            return dp[n][x];
        }
        dp[n][x]=Integer.MIN_VALUE;
        if(price[n-1]<=x){
            dp[n][x]=Math.max(dp[n][x],pages[n-1]+Get_Ans(dp, price, pages, n-1, x-price[n-1]));
        }
        return dp[n][x]=Math.max(dp[n][x],Get_Ans(dp, price, pages, n-1, x));
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] price=new int[n];
        int[] pages=new int[n];
        for (int i = 0; i < n; i++) {
            price[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pages[i]=sc.nextInt();
        }
        int[][] dp=new int[n+1][x+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(Get_Ans(dp,price,pages,n,x));
        sc.close();
    }
}
