import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Length_of_Valley {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        for (int test = 0; test < t; test++) {
            int n=Integer.parseInt(reader.readLine());
            int[] A=new int[n];
            int[] left=new int[n];
            int[] right=new int[n];
            String[] arr=reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                A[i]=Integer.parseInt(arr[i]);
            }
            left[0]=0;
            for (int i = 1; i < n; i++) {
                if(A[i-1]>A[i]){
                    left[i]=left[i-1];
                }
                else{
                    left[i]=i;
                }
            }
            right[n-1]=n-1;
            for (int i = n-2; i >= 0; i--) {
                if(A[i+1]>A[i]){
                    right[i]=right[i+1];
                }
                else{
                    right[i]=i;
                }
            }
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < n; i++) {
                int h=right[i]-left[i]+1;
                sb.append(h+" ");
            }
            System.out.println(sb.toString());
        }
    }
}
