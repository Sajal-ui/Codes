import java.io.IOException;
import java.util.Scanner;

public class Quick_Sort {
  static void swap(int[] A,int l,int r) {
	  int temp=A[l];
	  A[l]=A[r];
	  A[r]=temp;
  }
  static int partition(int[] A,int start,int end) {
	  int pivot=A[end];
	  int i=start-1;
	  for(int j=start;j<=end;j++) {
		 if(A[j]<pivot) {
			i++;
			swap(A,i,j);
		 }		 
	  }
	  swap(A,i+1,end);
	  return i+1;
  }
  static void QuickSort(int[] A,int start,int end) {
	  if(start<end) {
		  int p=partition(A,start,end);
		  QuickSort(A,start,p-1);
		  QuickSort(A,p+1,end);
	  }
  }
  public static void main(String[] args) throws IOException{
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int[] A=new int[n];
	for(int i=0;i<n;i++) {
		A[i]=sc.nextInt();
	}
	QuickSort(A,0,n-1);
	for(int i=0;i<n;i++) {
		System.out.print(A[i]+" ");
	}
	sc.close();
  }
}
