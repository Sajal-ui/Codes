import java.io.IOException;
import java.util.Scanner;

public class Sequential_Tuples {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int test = 0; test < t; test++) {
            int n=sc.nextInt();
            int[] arr=new int[5];
            arr[1]=1;
            arr[2]=4;
            arr[3]=10;
            arr[4]=18;
            System.out.println(n<=4?arr[n]:arr[4]+9*(n-4));
        }
        sc.close();
    }
}
