import java.io.*;
import java.util.*;
public class Count_Inversions{
	static int merge_Inver(int[] arr,int i,int mid,int j){
       int n=j-i+1;
	   int[] ans=new int[n];
	   int inv=0;
	   int k=0;
	   int l=i,r=j;
	   int h=mid+1;
	   while(i<=mid && h<=j){
		   if(arr[i]<=arr[h]){
			   ans[k++]=arr[i++];
		   }
		   else{
			   inv+=(mid-i)+1;
			   ans[k++]=arr[h++];
		   }
	   }
	   while(i<=mid){
		   ans[k++]=arr[i++];
	   }
	   while(h<=j){
		   ans[k++]=arr[h++];
	   }
	   for (int k2 = l; k2 <=r; k2++) {
		   //System.out.print("??"+k2+" "+ans[k2-l]+"\n");
		   arr[k2]=ans[k2-l];
	   }
	   return inv;
	}
	static int count_Inver(int[] arr,int i,int j){
		if(i==j){
           return 0;
		}
		int mid=(i+j)/2;
		int d1=count_Inver(arr, i, mid);
		int d2=count_Inver(arr, mid+1, j);
		int d3=merge_Inver(arr,i,mid,j);
		// for (int k = 0; k < arr.length; k++) {
		// 	System.out.print(arr[k]+" ");
		// }
		// System.out.println();
		return d1+d2+d3;
	}
	public static void main(String[] args) throws IOException{
	  Scanner sc=new Scanner(System.in);
	  int n=sc.nextInt();
	  int[] arr=new int[n];
	  for (int i=0;i<n;i++) {
	    arr[i]=sc.nextInt();		
	  }
	  System.out.println(count_Inver(arr,0,n-1));
	}
}