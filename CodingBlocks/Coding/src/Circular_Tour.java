import java.io.IOException;
import java.util.Scanner;

public class Circular_Tour {
  static int Index(int[] petrol,int[] distance) {
	  int N=petrol.length;
	  int start=0;
	  int capacity=0;
	  int deficit=0;
	  for(int i=0;i<N;i++) {
		  capacity+=petrol[i]-distance[i];
		  if(capacity<0) {
			  start=i+1;
			  deficit=capacity;
			  capacity=0;
		  }
	  }
	  if(capacity+deficit>=0) {
		  return start;
	  }
	  else {
		  return -1;
	  }
	  
  }
  public static void main(String[] args) throws IOException {
	 Scanner sc=new Scanner(System.in);
	 int N=sc.nextInt();
	 int[] petrol=new int[N];
	 int[] distance=new int[N];
	 for(int i=0;i<N;i++) {
		 petrol[i]=sc.nextInt();
	 }
	 for(int i=0;i<N;i++) {
		 distance[i]=sc.nextInt();
	 }
	 System.out.println(Index(petrol,distance));
  }
}
