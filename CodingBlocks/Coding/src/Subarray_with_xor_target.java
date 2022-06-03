import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Subarray_with_xor_target {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();            
        }
        HashMap<Integer,Integer> hash=new HashMap<>();
        int count=0;
        int res=0;
        for (int i = 0; i < n; i++) {
            res=res^A[i];
            int r=res^target;
            if(r==0){
                if(hash.containsKey(r)){
                    count+=hash.get(r);
                }
                count+=1;
            }
            else{
                if(hash.containsKey(r)){
                    count+=hash.get(r);
                }
            }
            hash.put(res,hash.getOrDefault(res,0)+1);
        }
        System.out.println(count);
        sc.close();
    }
}
