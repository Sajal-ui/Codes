import java.io.IOException;
import java.util.Scanner;

public class Flip_Bits {
  static int FlipBits(int[] A,int N) {
	  int start=0;
	  int end=0;
	  int ones=0;
	  int zeros=0;
	  int count=0;
	  int max_count=0;
	  for(int i=0;i<N;i++) {
		  if(A[i]==1) {
			  count++;
		  }
	  }
	  max_count=count;
	  for(int i=0;i<N;i++) {
		  if(A[i]==0) {
			  zeros++;
		  }
		  else {
			  ones++;
		  }
		  while(ones>zeros && start<end) {
			  if(A[start]==0) {
				  zeros--;
			  }
			  else {
				  ones--;
			  }
			  start++;
		  }
			  //System.out.println("//"+start+" "+end);
			  //System.out.println("||"+zeros+" "+ones);
			  max_count=Math.max(max_count,count+(zeros-ones));
		  end++;
		  
	  }
	  //System.out.println(start);
	  return max_count;
  }
  public static void main(String[] args) throws IOException{
	Scanner sc=new Scanner(System.in);
	int N=sc.nextInt();
	int[] A=new int[N];
	for(int i=0;i<N;i++) {
		A[i]=sc.nextInt();
	}
	System.out.println(FlipBits(A,N));
	sc.close();
  }
}
