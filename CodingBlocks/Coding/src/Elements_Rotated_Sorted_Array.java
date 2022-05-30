import java.io.*;
import java.util.*;
public class Elements_Rotated_Sorted_Array {
    static int Binary_Search(int[] arr,int i,int j,int ele){
        if(i>j){
            return -1;
        }
        int mid=(i+j)/2;
        if(arr[mid]==ele){
            return mid;
        }
        if(arr[i]<=arr[mid]){
            if(arr[i]<=ele && arr[mid]>=ele){
                int d=Binary_Search(arr,i,mid-1,ele);
                if(d!=-1){
                   return d;
                }
            }
            return Binary_Search(arr,mid+1,j,ele);
        }
        if(arr[mid+1]<=ele && arr[j]>=ele){
            int d=Binary_Search(arr,mid+1,j,ele);
            if(d!=-1){
                return d;
            }
        }
        return Binary_Search(arr,i,mid-1,ele);
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        int ele=sc.nextInt();
        System.out.println(Binary_Search(arr,0,n-1,ele));
    }
}
