import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobSchedulling {
    static class Sortify implements Comparator<int[]> {
        public int compare(int[] a1, int[] a2) {
            return a2[1] - a1[1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] jobs = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] arr = reader.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                jobs[i][j] = Integer.parseInt(arr[j]);
                //System.out.println(jobs[i][j]);
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Sortify());
        for (int i = 0; i < n; i++) {
            queue.add(jobs[i]);
        }
        int[] done_job = new int[n];
        int profit = 0;
        while (!queue.isEmpty()) {
            int[] ans = queue.poll();
            int deadline=ans[0]-1;
            int to_target=-1;
            for (int i = 0; i <=deadline; i++) {
                if(done_job[i]!=-1){
                   to_target=i;
                }
            }
            //System.out.println(to_target+" "+ans[0]+" "+deadline+" "+ans[1]);
            if(to_target!=-1){
                profit+=ans[1];
                done_job[to_target]=-1;
            }
        }
        System.out.println(profit);
    }
}
