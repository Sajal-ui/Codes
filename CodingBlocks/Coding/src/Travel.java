import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Travel {
   public static void main(String[] args) throws IOException{
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       int t=Integer.parseInt(reader.readLine());
       for (int test = 0; test < t; test++) {
          String[] arr=reader.readLine().split(" ");
          int n=Integer.parseInt(arr[0]);
          int k=Integer.parseInt(arr[1]);
          int[] A=new int[n];
          arr=reader.readLine().split(" ");
          for (int i = 0; i < n; i++) {
             A[i]=Integer.parseInt(arr[i]);
          }
          long[][] dp=new long[n][2];
          long[][] pos=new long[k][2];
          for (long[] is : pos) {
            Arrays.fill(is,Integer.MAX_VALUE);
          }
          for (long[] is : dp) {
            Arrays.fill(is,0L);
          }
          for (int i = 0; i < n; i++) {
             pos[A[i]-1][0]=Math.min(pos[A[i]-1][0],i);
             pos[A[i]-1][1]=i;
          }
          for (int i = 1; i < k; i++) {
             for (int j = 0; j < 2; j++) {
                dp[i][j]=Math.max(dp[i-1][1-j]+Math.abs(pos[i][j]-pos[i-1][1-j]),dp[i-1][j]+Math.abs(pos[i][j]-pos[i-1][j]));
            }
          }
          System.out.println(Math.max(dp[k-1][0],dp[k-1][1]));
       }
   }    
}
