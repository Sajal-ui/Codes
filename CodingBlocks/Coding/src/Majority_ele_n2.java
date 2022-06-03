import java.io.IOException;
import java.util.Scanner;

public class Majority_ele_n2{
    static boolean check(int[] A,int s,int n){
        int count=0;
        for (int i = 0; i < n; i++) {
            if(A[i]==s){
                count++;
            }
        }
        int h=(int)Math.floor(n/2.0);
        if(count>h){
            return true;
        }  
        else{
            return false;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        int count=0;
        int s=0;
        for (int i = 0; i < n; i++) {
            if(s==A[i]){
                count++;
            }
            else if(count==0){
                s=A[i];
                count++;
            }
            else{
                count--;
            }            
        }
        //System.out.println(s+" "+count);
        if(check(A,s,n)){
             System.out.println(s);
        }
        sc.close();
    }
}