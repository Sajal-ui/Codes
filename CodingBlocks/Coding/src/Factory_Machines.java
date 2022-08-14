import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factory_Machines {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=reader.readLine().split(" ");
        int n=Integer.parseInt(arr[0]);
        int t=Integer.parseInt(arr[1]);
        arr=reader.readLine().split(" ");
        int[] a=new int[n];
        long max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(arr[i]);
            max=Math.max(max,a[i]);
        }
        long low=1L;
        long high=t*max;
        long ans=0L;
        while(low<=high){
           long mid=(low+high)/2;
           long sum=0L;
           for (int i = 0; i < n; i++) {
              sum+=(mid/a[i]);
              if(sum>=t){
                 break;
              }
           }
           if(sum>=t){
             ans=mid;
             high=mid-1;
           }
           else{
              low=mid+1;
           }
        }
        System.out.println(ans);
    }   
}
