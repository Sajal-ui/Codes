import java.io.IOException;
import java.util.Scanner;

public class Missing_Repeating {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            int[] A=new int[n];
            for (int j = 0; j < n; j++) {
                A[j]=sc.nextInt();
            }
            int repeating=0;
            for (int j = 0; j < n; j++) {
                if(A[Math.abs(A[j])-1]>0){
                    A[Math.abs(A[j])-1]=0-A[Math.abs(A[j])-1];
                }
                else{
                    repeating=Math.abs(A[j]);
                }
            }
            int missing=0;
            for (int j = 0; j <n; j++) {
                if(A[j]>0){
                    missing=j+1;
                }
            }
            System.out.println(repeating+" "+missing);
        }
        sc.close();
    }
}
