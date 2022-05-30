import java.util.ArrayList;
import java.util.Scanner;

public class Alternate_position_positive_negative {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        ArrayList<Integer> positive=new ArrayList<>();
        ArrayList<Integer> negative=new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if(A[i]>=0){
                positive.add(A[i]);
            }
            else{
                negative.add(A[i]);
            }
        }
        if(positive.size()<=negative.size()){
           int i=0,j=1;
           int k1=0,k2=0;
           while(k1<positive.size()){
               A[j]=positive.get(k1++);
               j+=2;
           }
           while(k2<positive.size()){
               A[i]=negative.get(k2++);
               i+=2;
           }
           while(k2<negative.size()){
               A[i++]=negative.get(k2++);
           }
        }
        else if(positive.size()>negative.size()){
            int i=1,j=0;
            int k1=0,k2=0;
            while(k1<negative.size()){
                A[j]=negative.get(k1++);
                j+=2;
            }
            while(k2<negative.size()){
                A[i]=positive.get(k2++);
                i+=2;
            }
            while(k2<positive.size()){
                A[i++]=positive.get(k2++);
            }
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
}
