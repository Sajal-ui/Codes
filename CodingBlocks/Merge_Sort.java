import java.io.IOException;
import java.util.Scanner;

public class Merge_Sort{
    static void Merge(int[] A,int[] ans,int start,int mid,int end){
        int i=start;
        int j=mid+1;
        int index=start;
        while(i<=mid && j<=end){
            if(A[i]<=A[j]){
                ans[index++]=A[i++];
            }
            else{
                ans[index++]=A[j++];
            }
        }
        while(i<=mid){
            ans[index++]=A[i++];
        }
        while(j<=end){
            ans[index++]=A[j++];
        }
    }
    static void MergeSort(int[] A,int[] ans,int start,int end){
        if(start==end){
           return; 
        }
        int mid=(start+end)/2;
        MergeSort(A,ans,start,mid);
        MergeSort(A,ans,mid+1,end);
        Merge(A,ans,start,mid,end);
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        int[] ans=new int[n];
        MergeSort(A,ans,0,n-1);
    }
}