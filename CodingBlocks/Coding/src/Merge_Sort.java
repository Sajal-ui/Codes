import java.io.IOException;
import java.util.Scanner;

public class Merge_Sort{
    static void Merge(int[] A,int start,int mid,int end){
        int n1=mid-start+1;
        int n2=end-mid;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++) {
        	L[i]=A[start+i];
        }
        for(int j=0;j<n2;j++) {
        	R[j]=A[mid+1+j];
        }
        int i=0,j=0;
        int index=start;
        while(i<n1 && j<n2) {
        	if(L[i]<=R[j]) {
        		A[index++]=L[i++];
        	}
        	else {
        		A[index++]=R[j++];
        	}
        }
        while(i<n1) {
        	A[index++]=L[i++];
        }
        while(j<n2) {
        	A[index++]=R[j++];
        }
    }
    static void MergeSort(int[] A,int start,int end){
        if(start==end){
           return; 
        }
        int mid=(start+end)/2;
        MergeSort(A,start,mid);
        MergeSort(A,mid+1,end);
        Merge(A,start,mid,end);
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        //int[] ans=new int[n];
        MergeSort(A,0,n-1);
        for(int i=0;i<n;i++) {
        	System.out.print(A[i]+" ");
        }
        sc.close();
    }
}
