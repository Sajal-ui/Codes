import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Room_Allocation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //TreeMap<Long, Integer> tree = new TreeMap<>();
        int t = Integer.parseInt(reader.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(reader.readLine());
            long[] arrival=new long[n];
            long[] departure=new long[n];
            String[] arr=reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
               arrival[i]=Long.parseLong(arr[i]); 
            }
            arr=reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
               departure[i]=Long.parseLong(arr[i]); 
            }
            ArrayList<long[]> array = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //String[] arr = reader.readLine().split(" ");
                long[] A = new long[3];
                A[0] = arrival[i];
                A[1] = arrival[i]+departure[i];
                A[2] = i;
                array.add(A);
            }
            Collections.sort(array, new Comparator<long[]>() {
                public int compare(long[] a, long[] b) {
                    if (a[0] == b[0]) {
                        return (int)(a[1] - b[1]);
                    }
                    return (int)(a[0] - b[0]);
                }
            });
            PriorityQueue<long[]> queue=new PriorityQueue<>(new Comparator<long[]>() {
                public int compare(long[] a,long[] b){
                    return (int)(a[0]-b[0]);
                }
            });
            long room=1;
            queue.add(new long[]{array.get(0)[1],room});  
            for (int i = 1; i < n; i++) {
                long num=array.get(i)[0];
                long dest=array.get(i)[1];
                if(queue.peek()[0]<=num){
                    long h=queue.poll()[1];
                    queue.add(new long[]{dest,h});
                }
                else{
                    room+=1;
                    queue.add(new long[]{dest,room});
                }
            }
            System.out.println(room);
        }
    }
}
