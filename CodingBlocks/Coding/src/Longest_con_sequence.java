import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Longest_con_sequence {
   public static void main(String[] args) throws IOException{
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] A=new int[n];
       for (int i = 0; i < n; i++) {
           A[i]=sc.nextInt();
       }
       HashMap<Integer,Integer> hash=new HashMap<>();
       for(int i=0;i<n;i++){
           if(hash.containsKey(A[i]-1)){
               hash.put(A[i]-1,A[i]);
           }
           if(hash.containsKey(A[i]+1)){
               hash.put(A[i],A[i]+1);
           }
           else{
               hash.put(A[i],-1);
           }
       }
       int max=Integer.MIN_VALUE;
       for (int i : hash.keySet()) {
           int count=0;
           int f=i;
           while(f!=-1){
              count++;
              f=hash.get(f); 
           } 
           max=Math.max(max,count);
       }
       System.out.println(max);
       sc.close();
   } 
}
