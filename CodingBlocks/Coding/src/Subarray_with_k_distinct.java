import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Subarray_with_k_distinct {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        int distinct_counts=0;
        int sum=0;
        int start=0;
        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!hash.containsKey(A[i])){ 
               distinct_counts++;
               hash.put(A[i],1);
            }
            else{
                hash.put(A[i],hash.get(A[i])+1);
            }
            //System.out.println(A[i]+"/"+distinct_counts+"/"+i);
            if(distinct_counts<=k){
               //System.out.println(i+" "+start); 
               int np=(i-start+1);
               sum+=np;
            }
            else{
                //System.out.println(i+"*"+start);  
               while(distinct_counts>k && start<i){
                   hash.put(A[start],hash.get(A[start])-1);
                   if(hash.get(A[start])==0){
                       //System.out.println("MM "+A[start]);
                       hash.remove(A[start]);
                       distinct_counts--;
                   }
                   start++;
               }
               int np=(i-start+1);
               sum+=np;
            }
        }
        //sum+=(n-start);
        System.out.println(sum); 
    }
}
