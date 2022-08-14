import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array_opr {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        for(int test=0;test<t;test++){
           int n=Integer.parseInt(reader.readLine());
           String[] arr=reader.readLine().split(" ");
           int[] A=new int[n];
           for (int i = 0; i < n; i++) {
              A[i]=Integer.parseInt(arr[i]);
           } 
           long[] fwd=new long[n];
           long sum=0L;
           long max_sum=Integer.MIN_VALUE;
           for(int i=0;i<n;i++){
              sum=Math.max(A[i],sum+A[i]);
              max_sum=Math.max(max_sum,sum);
              fwd[i]=sum;
           }
           for (int i = 1; i < n; i++) {
              fwd[i]=Math.max(fwd[i-1],fwd[i]);
           }
           long[] bwd=new long[n];
           sum=0L;
           max_sum=Integer.MIN_VALUE;
           for(int i=n-1;i>=0;i--){
              sum=Math.max(A[i],sum+A[i]);
              max_sum=Math.max(max_sum,sum);
              bwd[i]=sum;
           }
           long x=max_sum;
           x=Math.max(0,x);
           for (int i = 1; i < n; i++) {
               x=Math.max(x,fwd[i-1]+bwd[i]);
           }
           System.out.println(x);
        }
    }
}
