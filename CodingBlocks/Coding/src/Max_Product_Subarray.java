import java.io.IOException;
import java.util.Scanner;

public class Max_Product_Subarray {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int[] count_neg=new int[n];
        count_neg[n-1]=0;
        for(int i=n-2;i>=0;i--){
            if(arr[i+1]<0){
               count_neg[i]=count_neg[i+1]+1;
            }
            else{
                count_neg[i]=count_neg[i+1];
            }
        }
        long s=1;
        long max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            s*=arr[i];
            max=Math.max(max,s);
            if(count_neg[i]==0){
               s=1;
            }
            if(s==0){
                s=1;
            }
        }
        System.out.println(max);
    }
}
