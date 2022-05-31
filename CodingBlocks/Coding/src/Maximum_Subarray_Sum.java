import java.io.IOException;
import java.util.Scanner;

public class Maximum_Subarray_Sum {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        int max_till_now=Integer.MIN_VALUE;
        int max_so_far=Integer.MIN_VALUE;
        int sum=0;
        int start=0;
        for (int i = 0; i < n; i++) {
            sum+=A[i];
            //System.out.println(A[i]+" "+sum);
            if(sum<0){
               while(start<=i && sum<0){
                   sum-=A[start];
                   start++;
               }
               max_till_now=Math.max(max_till_now, sum);
            }
            else{
               max_till_now=Math.max(max_till_now, sum);
            }
            max_so_far=Math.max(max_so_far,max_till_now);
        }
        System.out.println(max_so_far);
        sc.close();
    }
}
