import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sprinklers {
    static void update(int[] diff,int left,int right,int val){
        diff[left]+=val;
        diff[right+1]-=val;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        for (int test = 0; test < t; test++) {
            String[] arr=reader.readLine().split(" ");
            int n=Integer.parseInt(arr[0]);
            int q=Integer.parseInt(arr[1]);
            int[] C=new int[n];
            int[] R=new int[n];
            arr=reader.readLine().split(" ");
            for(int i=0;i<n;i++){
                C[i]=Integer.parseInt(arr[i]);
            }
            arr=reader.readLine().split(" ");
            for(int i=0;i<n;i++){
                R[i]=Integer.parseInt(arr[i]);
            }
            int[] cord_plane=new int[4*n+1];
            int[] diff=new int[4*n+2];
            for (int i = 0; i < n; i++) {
                int corrdinates=(C[i]+2*n);
                int left=0;
                int right=0;
                if(corrdinates<2*n){
                   left=corrdinates-R[i];
                   right=Math.min(2*n,corrdinates+R[i]);               
                }
                else{
                    left=Math.max(2*n,corrdinates-R[i]);
                    right=corrdinates+R[i];
                }
                update(diff,left,right,1);
            }
            for (int i = 0; i <= 4*n; i++) {
                if(i==0){
                    cord_plane[i]=diff[i];
                }
                else{
                    cord_plane[i]=cord_plane[i-1]+diff[i];
                }
            }
            for (int i = 0; i < q; i++) {
                int k=Integer.parseInt(reader.readLine());
                System.out.println((cord_plane[k+2*n]<0)?0:cord_plane[k+2*n]);
            }
        }
    }
}
