import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Codeforces_61D {
    static long Binoial_Coeff(int a,int b){
        long res=1L;
        for(int i=0;i<b;i++){
            res*=(a-i);
            res/=(i+1);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        int[] smaller_right=new int[n];
        ArrayList<Integer> c=new ArrayList<>();
        c.add(A[n-1]);
        smaller_right[n-1]=0;
        for (int i = n-2; i >=0; i--) {
           int pos=Collections.binarySearch(c,A[i]);
           if(pos<0){
              pos=pos*(-1);
              pos-=1;
           }
           smaller_right[i]=pos;
           c.add(pos,A[i]);            
        }
        c.clear();
        int[] greater_left=new int[n];
        c.add(A[0]);
        greater_left[0]=0;
        for (int i = 1; i < n; i++) {
           int pos=Collections.binarySearch(c,A[i]);
           if(pos<0){
             pos=pos*(-1);
             pos-=1;
           }
           greater_left[i]=c.size()-pos; 
           c.add(pos,A[i]);
        }
        long sum=0L;
        for (int i = 0; i < n; i++) {
            //System.out.println(greater_left[i]+" "+smaller_right[i]);
            sum+=(greater_left[i])*(smaller_right[i]);
        }
        System.out.println(sum);
        sc.close();
    }
}
