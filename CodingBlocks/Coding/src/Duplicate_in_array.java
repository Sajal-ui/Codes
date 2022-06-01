import java.io.IOException;
import java.util.Scanner;

public class Duplicate_in_array {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            int[] A=new int[n];
            for(int j=0;j<n;j++){
                A[j]=sc.nextInt();
            }
            int slow=0;
            int fast=0;
            do{
               //fast=0; 
               slow=A[slow];
               fast=A[A[fast]];
            }while(slow!=fast);
            fast=0;
            do{
                slow=A[slow];
                fast=A[fast];
            }while(slow!=fast);
            System.out.println(slow);
        }
        sc.close();
    }
}
