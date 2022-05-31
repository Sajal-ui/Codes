import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Next_Permutation {
   public static void main(String[] args) throws IOException{
       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       for (int i = 0; i < t; i++) {
           int n=sc.nextInt();
           int[] A=new int[n];
           for (int j = 0; j < n; j++) {
               A[j]=sc.nextInt();
           }
           TreeMap<Integer,Integer> treeMap=new TreeMap<>();
           int index=-1;
           for (int j = n-1; j>=0; j--) {
               Integer d=treeMap.higherKey(A[j]);
               if(d!=null){
                  index=treeMap.get(d);
                  int temp=A[j];
                  A[j]=A[index];
                  A[index]=temp;
                  index=j;
                  break;
               }
               else{
                   treeMap.put(A[j],j);
               }
           }
           int low=index+1;
           int high=n-1;
           while(low<high){
               int temp=A[low];
               A[low]=A[high];
               A[high]=temp;
               low++;
               high--;
           }
           for (int j = 0; j < n; j++) {
               System.out.print(A[j]+" ");
           }
           System.out.println();
           sc.close();
       }
   } 
}
