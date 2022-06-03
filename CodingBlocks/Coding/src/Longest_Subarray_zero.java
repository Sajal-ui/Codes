import java.util.HashMap;
import java.util.Scanner;

public class Longest_Subarray_zero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        int sum=0;
        HashMap<Integer,Integer> hash=new HashMap<>();
        int max=0;
        hash.put(0,-1);
        for (int i = 0; i < n; i++) {
           sum+=A[i];
           if(hash.containsKey(sum)){
               int f=hash.get(sum);
               max=Math.max(max,i-f);
           }
           else{
               hash.put(sum,i);
           } 
        }
        System.out.println(max);
        sc.close();
    }
}
