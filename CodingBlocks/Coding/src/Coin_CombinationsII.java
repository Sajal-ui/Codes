import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin_CombinationsII{
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=reader.readLine().split(" ");
        int n=Integer.parseInt(arr[0]);
        int x=Integer.parseInt(arr[1]);
        arr=reader.readLine().split(" ");
        int[] C=new int[n];
        for (int i = 0; i < arr.length; i++) {
            C[i]=Integer.parseInt(arr[i]);
        } 
        int[] dp=new int[x+1];
        int mod=1000000007;
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=x;j++){
                if(j>=C[i-1]){
                    dp[j]+=dp[j-C[i-1]];
                }
                if(dp[j]>=mod){
                    dp[j]-=mod;
                }
            }
        }
        System.out.println(dp[x]);
    }
}
