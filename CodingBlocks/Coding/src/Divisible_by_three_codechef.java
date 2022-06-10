import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Divisible_by_three_codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] arr = reader.readLine().split(" ");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);
            if (A == 0 || B == 0) {
                System.out.println("0");
            } 
            else if(A%3==0 || B%3==0){
                System.out.println("0");
            }
            else {
                int max=Math.max(A,B);
                int min=Math.min(A,B);
                int l=(int)Math.floor(max/3.0);
                int count=0;
            }
        }
    }
}
