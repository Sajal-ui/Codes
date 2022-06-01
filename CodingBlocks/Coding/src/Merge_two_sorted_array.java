import java.io.IOException;
import java.util.Scanner;

public class Merge_two_sorted_array {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m=sc.nextInt();
            int n=sc.nextInt();
            int[] A=new int[m+n];
            int[] B=new int[n];
            for (int j = 0; j < m; j++) {
                A[j]=sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                B[j]=sc.nextInt();
            }
            for (int j = m; j < m+n; j++) {
                A[j]=B[j-m];
            }
            int gap;
            int limit=(int)Math.ceil((Math.log((m+n))/Math.log(2)));
            if((m+n)%2==0){
                gap=(m+n)/2;
            }
            else{
                gap=((m+n)/2)+1;
            }
            while(limit>0){
                int start=0;
                int end=start+gap;
                while(end<m+n){
                  if(A[start]>A[end]){  
                    int temp=A[start];
                    A[start]=A[end];
                    A[end]=temp;
                  }
                  start++;
                  end++;
                }
                if(gap%2==0){
                    gap=gap/2;
                }
                else{
                    gap=(gap/2)+1;
                }
                limit--;
            }
            for (int j = 0; j < m+n; j++) {
                System.out.print(A[j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
