import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Pair_Sum {
   public static void main(String[] args) throws IOException{
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] A=new int[n];
       for (int i = 0; i < A.length; i++) {
           A[i]=sc.nextInt();
       }
       int target=sc.nextInt();
       Arrays.sort(A);
       ArrayList<ArrayList<Integer>> list=new ArrayList<>();
       int i=0;
       int j=n-1;
       while(i<j){
           int sum=A[i]+A[j];
           if(sum==target){
            int limit=j;
            while(limit>i && A[i]+A[limit]==target){
              ArrayList<Integer> l=new ArrayList<>();   
              l.add(A[i]);
              l.add(A[j]);
              list.add(l);
              limit--;  
            }
            i++;
           }
           else if(sum>target){
               j--;
           }
           else{
               i++;
           }
       }
       System.out.println(list);
       sc.close();
   } 
}
