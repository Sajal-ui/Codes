import java.util.Scanner;

public class Also_Try_Minecraft{
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int q=sc.nextInt();
       long[] arr=new long[n];
       for (int i = 0; i < n; i++) {
          arr[i]=sc.nextLong();
       }
       long[] left=new long[n];
       long[] right=new long[n];
       left[0]=0L;
       right[n-1]=0L;
       for(int i=1;i<n;i++){
           if(arr[i]<arr[i-1]){
              left[i]=left[i-1]+(arr[i-1]-arr[i]);
           }
           else{
              left[i]=left[i-1];
           }
       }
       for (int i = n-2; i >=0; i--) {
           if(arr[i]<arr[i+1]){
              right[i]=right[i+1]+(arr[i+1]-arr[i]);
           }
           else{
              right[i]=right[i+1];
           }
       }
       //System.out.println(f);
       for (int i = 0; i < q; i++) {
           int x=sc.nextInt()-1;
           int y=sc.nextInt()-1;
           if(x<=y){
              System.out.println(left[y]-left[x]);
           }
           else{
              System.out.println(right[y]-right[x]);
           }
       }
       sc.close();
    }
}