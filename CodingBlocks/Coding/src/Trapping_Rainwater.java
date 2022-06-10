import java.io.IOException;
import java.util.Scanner;
public class Trapping_Rainwater {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] arr=new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextLong();
        }
        long[] left=new long[n];
        long[] right=new long[n];
        left[0]=arr[0];
        right[n-1]=arr[n-1];
        for (int i = 1; i < n; i++) {
            left[i]=Math.max(left[i-1],arr[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            right[i]=Math.max(right[i+1],arr[i]);
        }
        Long sum=0L;
        for (int i = 0; i < n; i++) {
            sum+=Math.min(left[i],right[i])-arr[i];
        }
        System.out.println(sum);
        sc.close();
    }
}
