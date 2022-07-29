import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Codeforces_466C {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        long sum=0L;
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
            sum=sum+A[i];
        }
        if(sum%3!=0){
           System.out.println(0);
        }
        else{
            long one_third=sum/3;
            long two_third=2*one_third;
            //System.out.println(one_third+" "+two_third);
            int one_third_count=0;
            long sf=0L;
            long count=0L;
            for (int i = 0; i < A.length-1; i++) {
                sf+=A[i];
                if(sf==two_third){
                   count+=one_third_count;
                }
                if(sf==one_third){
                   one_third_count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
