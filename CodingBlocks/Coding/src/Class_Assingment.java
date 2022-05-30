import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Class_Assingment {
   public static void main(String[] args) throws IOException {
	   Scanner sc=new Scanner(System.in);
	   int[] A=new int[26];
	   int[] B=new int[26];
	   Arrays.fill(A, 0);
	   Arrays.fill(B, 0);
	   A[1]=1;
	   B[1]=1;
	   for(int i=2;i<26;i++) {
		  A[i]=A[i-1]+B[i-1];
		  B[i]=A[i-1];
	   }
	   int t=sc.nextInt();
	   for(int i=0;i<t;i++) {
		   int k=sc.nextInt();
		   System.out.println("#"+(i+1)+" : "+(A[k]+B[k]));
	   }
  }
}
