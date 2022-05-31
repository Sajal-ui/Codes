import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Subset_sum_equals_k {
   static class SortBy implements Comparator<List<Integer>>{
	   public int compare(List<Integer> l1,List<Integer> l2) {
		   return l1.size()-l2.size();
	   }
   }
   public static void main(String[] args) throws IOException{
	 Scanner sc=new Scanner(System.in);
	 int n=sc.nextInt();
	 int[] A=new int[n];
	 for(int i=0;i<n;i++) {
		 A[i]=sc.nextInt();
	 }
	 int k=sc.nextInt();
	 int limit=(int)Math.pow(2,n);
	 List<String> list=new ArrayList<>();
	 for(int i=1;i<limit;i++) {
		 StringBuilder sb=new StringBuilder();
		 for(int j=0;j<n;j++) {
			 sb.append(String.valueOf((i>>j)&1));
		 }
		 list.add(sb.reverse().toString());
	 }
	 List<List<Integer>> ans=new ArrayList<>();
	 for(String str:list) {
		 int len=str.length();
		 int sum=0;
		 List<Integer> lp=new ArrayList<>();
		 for(int i=len-1;i>=0;i--) {
			 if(str.charAt(i)=='1') {
				 sum+=A[i];
				 lp.add(A[i]);
			 }
		 }
		 //Collections.sort(lp,Collections.reverseOrder());
		 if(sum==k) {
			ans.add(lp);
		 }
	 }
	 Collections.sort(ans,new SortBy());
	 for(List<Integer> lk:ans) {
		 for(Integer j:lk) {
			 System.out.print(j+" ");
		 }
		 System.out.println();
	 }
	 sc.close();
   }
}
