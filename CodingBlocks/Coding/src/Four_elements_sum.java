import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Four_elements_sum {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int target=sc.nextInt();
        HashMap<Integer,ArrayList<Integer>> hash=new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int sum=A[i]+A[j];
                ArrayList<Integer> al=new ArrayList<>();
                al.add(i);
                al.add(j);
                hash.put(sum,al);
            }
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int sum=A[i]+A[j];
                int s=target-sum;
                if(hash.containsKey(s)){
                    ArrayList<Integer> d=hash.get(s);
                    int ind1=d.get(0);
                    int ind2=d.get(1);
                    if(ind1==i || ind2==i || ind1==j || ind2==j){

                    }
                    else{
                        System.out.println("YES");
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}
