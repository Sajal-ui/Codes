import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Min_No_of_Platforms {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        int[] arrival=new int[n];
        int[] departure=new int[n];
        String[] arr=reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrival[i]=Integer.parseInt(arr[i]);
        }
        arr=reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            departure[i]=Integer.parseInt(arr[i]);
        }
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int max=1;
        int count=1;
        int i=1,j=0;
        while(i<n && j<n){
            if(arrival[i]<=departure[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            max=Math.max(max,count);
        }
        System.out.println(max);
    }
}
