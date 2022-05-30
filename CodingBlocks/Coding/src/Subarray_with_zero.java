import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Subarray_with_zero {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        HashSet<Integer> hash=new HashSet<>();
        int sum=0;
        hash.add(0);
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
            if(hash.contains(sum)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            hash.add(sum);
        }
    }
}
