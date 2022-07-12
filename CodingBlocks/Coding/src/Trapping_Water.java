import java.util.Scanner;
import java.util.Stack;

public class Trapping_Water {
    private static Integer push;
    static long trappingWater(int[] A,int n){
        Stack<Integer> stack1=new Stack<Integer>();
        Stack<Integer> stack2=new Stack<Integer>();
        int[] prev=new int[n];
        int[] next=new int[n];
        prev[0]=-1;
        next[n-1]=-1;
        stack1.push(0);
        stack2.push(n-1);
        for(int i=1;i<n;i++){
           if(A[stack1.peek()]>A[i]){
               prev[i]=stack1.peek();
           }
           else{
               prev[i]=-1;
               stack1.push(A[i]);
           }
        }
        for (int i = n-1; i>=0; i--) {
            if(A[stack2.peek()]>A[i]){
                next[i]=stack2.peek();
            }
            else{
                next[i]=-1;
                stack2.push(A[i]);
            }
        }
        long sum=0L;
        for (int i = 1; i < n-1; i++) {
            if(prev[i]!=-1 && next[i] !=-1){
                int f=Math.min(A[prev[i]],A[next[i]]);
                sum+=(f-A[i]);
            }
        }
        return sum;
    }    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        System.out.println(trappingWater(A, n));
        sc.close();
    }
}