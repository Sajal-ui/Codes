import java.util.Scanner;

public class Array_Description{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] dp=new int[n][m+1];
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        if(arr[0]==0){
            for(int i=1;i<=m;i++){
                dp[0][i]=1;
            }
        }
        else{
            dp[0][arr[0]]=1;
        }
        int mod=1000000007;
        for(int i=1;i<n;i++){
            if(arr[i]==0){
                for (int j = 1; j <=m; j++) {
                    dp[i][j]=dp[i-1][j];
                    if(j-1>0){
                      dp[i][j]+=dp[i-1][j-1];
                      if(dp[i][j]>=mod){
                        dp[i][j]-=mod;
                      }
                    }
                    if(j+1<=m){
                        dp[i][j]+=dp[i-1][j+1];
                        if(dp[i][j]>=mod){
                            dp[i][j]-=mod;
                        }
                    }
                }
            }
            else{
                dp[i][arr[i]]=dp[i-1][arr[i]];
                if(arr[i]-1>0){
                    dp[i][arr[i]]+=dp[i-1][arr[i]-1];
                    if(dp[i][arr[i]]>=mod){
                        dp[i][arr[i]]-=mod;
                    }
                }
                if(arr[i]+1<=m){
                    dp[i][arr[i]]+=dp[i-1][arr[i]+1];
                    if(dp[i][arr[i]]>=mod){
                        dp[i][arr[i]]-=mod;
                    }
                }
            }
        }
        long ans=0L;
        for (int i = 1; i <=m; i++) {
            ans+=dp[n-1][i];
            if(ans>=mod){
                ans-=mod;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
