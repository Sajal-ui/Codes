import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task_Deadlines {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        ArrayList<int[]> array=new ArrayList<>();
        for(int i=0;i<n;i++){
           String[] arr=reader.readLine().split(" ");
           int[] a=new int[2];
           a[0]=Integer.parseInt(arr[0]);
           a[1]=Integer.parseInt(arr[1]);
           array.add(a);
        }
        Collections.sort(array,new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            }
        });
        long start=0L;
        long sum=0L;
        for (int i = 0; i < n; i++) {
            start+=array.get(i)[0];
            sum+=(array.get(i)[1]-start);
        }
        System.out.println(sum);
    }
}
