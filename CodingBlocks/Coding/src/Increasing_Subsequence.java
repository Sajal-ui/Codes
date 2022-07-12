import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Increasing_Subsequence {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        int[] tailTable=new int[n];
        tailTable[0]=A[0];
        int len=1;
        for(int i=1;i<n;i++){
            if(A[i]>tailTable[len-1]){
                tailTable[len++]=A[i];
            }
            else{
                int idx=Arrays.binarySearch(tailTable,0,len-1,A[i]);
                if(idx<0){
                    idx=idx*(-1)-1;
                }
                tailTable[idx]=A[i];
            }
        }
        System.out.println(len);
        sc.close();
    }
}
