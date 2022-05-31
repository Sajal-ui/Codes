import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Split_Array_Recur {
  static int count=0;
  static void split_up(int[] A,int n,int s1,int s2,List<Integer> set1,List<Integer> set2,int index) {
	  if(index==n) {
		  if(s1==s2) {
			  for(Integer t:set1) {
				  System.out.print(t+" ");
			  }
			  System.out.print("and ");
			  for(Integer t:set2) {
				  System.out.print(t+" ");
			  }
			  count++;
			  System.out.println();
		  }
		  return;
	  }
	  int number=A[index];
	  set1.add(number);
	  split_up(A,n,s1+number,s2,set1,set2,index+1);
	  set1.remove(set1.size()-1);
	  set2.add(number);
	  split_up(A,n,s1,s2+number,set1,set2,index+1);
	  set2.remove(set2.size()-1);
  }
  public static void main(String[] args) throws IOException{
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int[] A=new int[n];
	int sum=0;
	for(int i=0;i<n;i++) {
		A[i]=sc.nextInt();
		sum+=A[i];
	}
	int s1=0,s2=0;
	List<Integer> set1=new ArrayList<>();
	List<Integer> set2=new ArrayList<>();
	if(sum%2==0) {
	  split_up(A,n,s1,s2,set1,set2,0);
	  System.out.println(count);
	}
	sc.close();
  }
}
