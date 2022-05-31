import java.io.IOException;
//import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Longest_Consecutive_Subsequence{
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(arr[i]);
        }
        int len=1;
        int max=1;
        int last_num=queue.poll();
        while(!queue.isEmpty()){
            int d=queue.poll();
            if(last_num==d-1){
                len++;
                last_num=d;
            }
            else if(last_num==d){

            }
            else{
                max=Math.max(max,len);
                len=1;
                last_num=d;
            }
        }
        max=Math.max(max,len);
        System.out.println(max);
        sc.close();
    }
}