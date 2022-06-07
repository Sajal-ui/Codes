import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class three_sum{
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int K=sc.nextInt();
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        for (int i = 0; i < n-2; i++) {
            int low=i+1;
            int high=n-1;
            int target=K-arr[i];
            while(low<high){
                if(arr[low]+arr[high]==target){
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[low]);
                    temp.add(arr[high]);
                    A.add(temp);
                    while(low<high && arr[low]==arr[low+1]){low++;}
                    while(low<high && arr[high]==arr[high-1]){high--;}
                    low++;
                    high--;
                }
                else if(arr[low]+arr[high]<target){
                    low++;
                }
                else{
                    high--;
                }
            }
        }
        System.out.println(A);
        sc.close();
    }
}