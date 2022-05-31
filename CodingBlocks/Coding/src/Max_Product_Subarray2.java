import java.io.IOException;
import java.util.Scanner;
public class Max_Product_Subarray2 {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int max_so_far=0;
        int flag=0;
        int max_till_now=1;
        int min_till_now=1;
        for (int i = 0; i < n; i++) {
            if(arr[i]>0){
                max_till_now=max_till_now*arr[i];
                min_till_now=Math.min(min_till_now*arr[i],1);
                flag=1;
            }
            else if(arr[i]==0){
                max_till_now=1;
                min_till_now=1;
            }
            else{
                int temp=max_till_now;
                max_till_now=Math.max(min_till_now*arr[i],1);
                min_till_now=temp*arr[i];
            }
            if(max_so_far<max_till_now){
                max_so_far=max_till_now;
            }
        }
        if(flag==0 && max_so_far==0){
            System.out.println(0);
        }
        else{
            System.out.println(max_so_far);
        }
        sc.close();
    }
}
