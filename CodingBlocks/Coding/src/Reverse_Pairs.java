import java.io.IOException;
import java.util.Scanner;

public class Reverse_Pairs {
    static int Merge(int[] A,int i,int mid,int j){
        int count=0;
        int high=mid+1;
        for (int low = i; low<=mid; low++) {
            while(high<=j && A[low]>(2*A[high])){
                high++;
            }
            count+=(high-(mid+1));
        }
        int l1=i;
        int l2=mid+1;
        int k=0;
        int[] B=new int[j-i+1];
        while(l1<=mid && l2<=j){
            if(A[l1]>A[l2]){
                B[k++]=A[l2++];
            } 
            else{
                B[k++]=A[l1++];
            }
        }
        while(l1<=mid){
            B[k++]=A[l1++];
        }
        while(l2<=j){
            B[k++]=A[l2++];
        }
        for(int k2=i;k2<=j;k2++){
            A[k2]=B[k2-i];
        }
        return count;
    }
    static int Rev_pairs(int[] A,int i,int j){
        if(i==j){
           return 0; 
        }
        int mid=(i+j)/2;
        int s1=0,s2=0;
        s1=Rev_pairs(A, i, mid);
        s2=Rev_pairs(A,mid+1,j);
        return s1+s2+Merge(A,i,mid,j);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        System.out.println(Rev_pairs(A,0,n-1));
        sc.close();
    }
}
