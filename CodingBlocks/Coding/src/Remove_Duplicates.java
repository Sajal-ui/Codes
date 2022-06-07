import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Remove_Duplicates {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        Arrays.sort(A);
        int length=1;
        int num=A[0];
        for (int i = 1; i < n; i++) {
            if(A[i]!=num){
               num=A[i]; 
               length++;
            }
        }
        System.out.println(length);
        sc.close();
    }
}
