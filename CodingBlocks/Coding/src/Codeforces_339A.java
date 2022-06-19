import java.io.IOException;
import java.util.Scanner;

public class Codeforces_339A{
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split("\\+");
        int[] A=new int[str.length];
        for (int i = 0; i < A.length; i++) {
            A[i]=Integer.parseInt(str[i]);
        }
        int[] count=new int[3];
        for (int i = 0; i < A.length; i++) {
            count[A[i]-1]=count[A[i]-1]+1;
            //System.out.println(count[A[i]-1]+" "+A[i]);
        }
        int[] index=new int[3];
        index[0]=0;
        for (int i = 1; i < 3; i++) {
            index[i]=index[i-1]+count[i-1];
        }
        int[] B=new int[str.length];
        for (int i = 0; i < A.length; i++) {
            //System.out.println(A[i]+" "+index[A[i]-1]);
            B[index[A[i]-1]]=A[i];
            index[A[i]-1]=index[A[i]-1]+1;
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < B.length-1; i++) {
            sb.append(B[i]);
            sb.append("+");
        }
        sb.append(B[B.length-1]);
        System.out.println(sb.toString());
        sc.close();
    }
}