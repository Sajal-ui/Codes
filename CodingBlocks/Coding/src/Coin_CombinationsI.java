import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin_CombinationsI{
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
        for(int i=1;i<=x;i++){
           for(int c:C){
              if(i>=c){
                dp[i]+=dp[i-c];
              }
              if(dp[i]>mod){
                dp[i]-=mod;
              }
           }
        }
        System.out.println(dp[x]);
    }
}
