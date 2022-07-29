import java.util.HashSet;
import java.util.Scanner;

public class MemoryReader {
    static boolean Jumps_To(HashSet<Integer> hash, int pos, int jump, int last) {
        if(pos > last){
            return false;
        }
        if (pos == last) {
            return true;
        }
        //System.out.println(pos+" "+jump+" "+last);
        if (hash.contains(pos + jump + 1)) {
            int p = pos + jump + 1;
            int j = jump + 1;
            if (Jumps_To(hash, p, j, last)) {
                return true;
            }
        }
        if (hash.contains(pos + jump)) {
            int p = pos + jump;
            if (Jumps_To(hash, p, jump, last)) {
                return true;
            }
        }
        if (hash.contains(pos + jump - 1)) {
            int p = pos + jump - 1;
            int j = jump - 1;
            if (j>0 && Jumps_To(hash, p, j, last)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int[] Gm = new int[n];
            HashSet<Integer> hash = new HashSet<>();
            for (int i = 0; i < n; i++) {
                Gm[i] = sc.nextInt();
                hash.add(Gm[i]);
            }
            int pos = Gm[0];
            int jump = Gm[0];
            int last = Gm[n - 1];
            if (Jumps_To(hash, pos, jump, last)) {
               System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
