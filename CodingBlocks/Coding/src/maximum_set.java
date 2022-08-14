import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class maximum_set {
    static int LCS(int[] B,int n){
        int len=1;
        int[] lcs=new int[n];
        lcs[0]=B[0];
        for (int i = 1; i < n; i++) {
            if(lcs[len-1]<B[i]){
               len++;
               lcs[len-1]=B[i];
            }
            else{
                int pos=Arrays.binarySearch(lcs,0,len-1,B[i]);
                if(pos<0){
                    pos=pos*(-1);
                    pos-=1;
                }
                lcs[pos]=B[i];
            }
        }
        return len;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        for (int test = 0; test < t; test++) {
            int n=Integer.parseInt(reader.readLine());
            int[] A=new int[n];
            int[] B=new int[n];
            String[] arr=reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                A[i]=Integer.parseInt(arr[i]);
            }
            for (int i = 0; i < n; i++) {
                B[i]=A[n-i-1];
            }
            System.out.println(LCS(B,n));
        }
    }
}
