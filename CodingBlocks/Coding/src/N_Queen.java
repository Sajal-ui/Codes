import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class N_Queen {
  static boolean goAhead(int[][] chess,int i,int j,int n) {
	  for(int p=0;p<j;p++) {
		  if(chess[i][p]==1) {
			  return false;
		  }
	  }
	  int p=i,q=j;
	  while(p>=0 && q>=0) {
		  if(chess[p][q]==1) {
			  return false;
		  }
		  p--;
		  q--;
	  }
	  p=i;
	  q=j;
	  while(p<n && q>=0) {
		 if(chess[p][q]==1) {
			 return false;
		 }
		 p++;
		 q--;
	  }
	  return true;
  }
  static void Queens(int[][] chess,int n,int j,ArrayList<ArrayList<Integer>> list,ArrayList<ArrayList<ArrayList<Integer>>> list_f){
	 if(j==n) {
		ArrayList<ArrayList<Integer>> l=new ArrayList<>();
		l.addAll(list);
		list_f.add(l);
		return;
	 }
	 for(int i=0;i<n;i++) {
		 if(!goAhead(chess,i,j,n)) {
			 continue;
		 }
		 chess[i][j]=1;
		 ArrayList<Integer> h=new ArrayList<>();
		 h.add(i);
		 h.add(j);
		 list.add(h);
		 Queens(chess,n,j+1,list,list_f);
		 list.remove(list.size()-1);
		 chess[i][j]=0;
	 }
  }
  public static void main(String[] args) throws IOException{
	 Scanner sc=new Scanner(System.in);
	 int n=sc.nextInt();
	 ArrayList<ArrayList<Integer>> list=new ArrayList<>();
	 ArrayList<ArrayList<ArrayList<Integer>>> list_f=new ArrayList<>();
	 int[][] chess=new int[n][n]; 
	 Queens(chess,n,0,list,list_f);
	 for(ArrayList<ArrayList<Integer>> jl:list_f) {
		 for(ArrayList<Integer> l:jl) {
			 System.out.print("{"+l.get(0)+"-"+l.get(1)+"} ");
		 }
		 System.out.print(" ");
	 }
	 System.out.println();
	 System.out.println(list_f.size());
  }
}
