import java.io.IOException;
import java.util.Scanner;

public class Maximize_Number_of_1 {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] A=new int[N];
        for(int i=0; i<N;i++){
            A[i]=sc.nextInt();
        }
        int M=sc.nextInt();
        int start=0;
        int end=0;
        int size=Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            if(A[i]==0){
               if(M==0){
                 size=Math.max(size,(end-start));  
                 if(A[start]==0){
                     start++;
                     M++;
                 }
                 else{
                     start++;
                 } 
                 i--;
               }
               else{
                   M--;
                   end++;
               }
            }
            else{
                end++;
            }
        }
        size=Math.max(size,(end-start));
        System.out.println(size);
        sc.close();
    }
}
