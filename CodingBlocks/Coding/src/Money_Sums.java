import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Money_Sums {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max_sum = n * 1000;
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        boolean[][] dp = new boolean[n + 1][max_sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= max_sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=max_sum; j++) {
               if(j>=A[i-1]){
                 dp[i][j]=dp[i-1][j] || dp[i-1][j-A[i-1]];
               } 
               else{
                 dp[i][j]=dp[i-1][j];
               }
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 1; i <=max_sum; i++) {
            if(dp[n][i]){
                list.add(i);
            }
        } 
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        sc.close();
    }
}
