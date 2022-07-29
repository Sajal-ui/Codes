import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Codeforces_1706B {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            HashMap<Integer, Integer> hash = new HashMap<>();
            int[] count = new int[n + 1];
            for (int i = 0; i < n; i++) {
                count[A[i]] = 1;
            }
            for (int i = 0; i < n; i++) {
                if (hash.containsKey(A[i])) {
                    int pos=hash.get(A[i]);
                    if((i-pos)%2!=0){
                        count[A[i]]++;
                    }
                    hash.put(A[i], i);
                } else {
                    //ArrayList<Integer> list = new ArrayList<>();
                    hash.put(A[i], i);
                }
            }
            StringBuilder sb=new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(count[i]+" ");
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
