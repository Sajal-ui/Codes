import java.io.IOException;
import java.util.Scanner;

public class Counting_Sort {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        int[] count=new int[3];
        for (int i = 0; i < n; i++) {
            count[A[i]]++;
        }
        int[] AP=new int[3];
        AP[0]=0;
        for (int i = 1; i < 3; i++) {
            AP[i]=AP[i-1]+count[i-1];
        }
        int[] C=new int[3];
        for (int i = 0; i < 3; i++) {
            C[i]=AP[i]+count[i];
        }
        for(int i=0;i<3;i++){
            while(AP[i]<C[i]){
                A[AP[i]++]=i;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
        sc.close();
    }
}
