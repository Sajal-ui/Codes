import java.util.Arrays;
//import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Interesting_Drink {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        TreeMap<Integer,Integer> hash=new TreeMap<>();
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            hash.put(arr[i],i);
        }
        int q=sc.nextInt();
        for (int i = 0; i < q; i++) {
            int m=sc.nextInt();
            Integer f=hash.floorKey(m);
            if(f==null){
                System.out.println(0);
            }
            else{
                int pos=hash.get(f);
                System.out.println(pos+1);
            }
        }
        sc.close();
    }
}
