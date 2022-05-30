import java.io.IOException;
import java.util.Scanner;

public class Subset_Summed_zero {
   static boolean subsetSum(int[] arr,int n,int sum,int index) {
	  if(index==n) {
		return false;  
	  }
	  if(sum+arr[index]==0) {
		  return true;
	  }
	  return subsetSum(arr,n,sum+arr[index],index+1) || subsetSum(arr,n,sum,index+1);
   }
   public static void main(String[] args) throws IOException{
	  Scanner sc=new Scanner(System.in);
	  int t=sc.nextInt();
	  for(int test=0;test<t;test++) {
	    int n=sc.nextInt();
	    int[] arr=new int[n];
	    for(int i=0;i<n;i++) {
		  arr[i]=sc.nextInt();
	    }
	    if(subsetSum(arr,n,0,0)) {
		  System.out.println("Yes");
	    }
	    else {
		  System.out.println("No");
	    }
	  }
   }
}
