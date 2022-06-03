import java.io.IOException;
import java.util.Scanner;

public class Search_2D_matrix {
    static boolean find(int[] B,int n,int target){
        int i=0;
        int j=n-1;
        while(i<=j){
           int mid=(i+j)/2;
           if(B[mid]==target){
               return true;
           }
           else if(B[mid]<target){
               j=mid-1;
           }
           else{
               i=mid+1;
           }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[][] A=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j]=sc.nextInt();
            }
        } 
        int flag=0;
        for (int i = 0; i < m; i++) {
            int j=n-1;
            if(A[i][j]==target){
                System.out.println("TRUE");
                flag=1;
                break;
            }
            else if(A[i][j]>target){
                flag=1;
                if(find(A[i],n,target)){
                    System.out.println("TRUE");
                }
                else{
                    System.out.println("FALSE");
                }
                break;
            }
        }
        if(flag==0){
           System.out.println("FALSE");
        }
        sc.close();

    }
}
