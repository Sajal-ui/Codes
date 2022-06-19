import java.io.IOException;
import java.util.Scanner;

public class Codeforces_469A {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n+1];
        int count=0;
        int p=sc.nextInt();
        for (int i = 0; i < p; i++) {
            int d=sc.nextInt();
            if(A[d]==0){
                count++;
                A[d]=1;
            }
        }
        int q=sc.nextInt();
        for (int i = 0; i < q; i++) {
            int d=sc.nextInt();
            if(A[d]==0){
                count++;
                A[d]=1;
            }
        }
        if(count==n){
            System.out.println("I become the guy.");
        }
        else{
            System.out.println("Oh, my keyboard!");
        }
        sc.close();
    } 
}
