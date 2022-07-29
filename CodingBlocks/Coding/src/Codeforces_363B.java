import java.util.Scanner;

public class Codeforces_363B {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int k=sc.nextInt();
       int[] A=new int[n];
       for (int i = 0; i < n; i++) {
          A[i]=sc.nextInt();
       }
       int[] prefix_sum=new int[n];
       prefix_sum[0]=A[0];
       for (int i = 1; i < n; i++) {
          prefix_sum[i]=prefix_sum[i-1]+A[i];
       }
       int max=prefix_sum[k-1];
       int pos=0;
       for (int i = 1; i <=n-k; i++) {
          int h=prefix_sum[i+k-1]-(prefix_sum[i-1]);
          //System.out.println(i+" "+h); 
          if(max>h){
             max=h;
             pos=i;
          }
       }
       System.out.println(pos+1);
    }
}
