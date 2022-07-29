import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codeforces_313B {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str=reader.readLine();
        int n=str.length();
        int[] count=new int[n];
        for (int i = 1; i < n; i++) {
            if(str.charAt(i)==str.charAt(i-1)){
                count[i]=count[i-1]+1;
            }
            else{
                count[i]=count[i-1];
            }
        }
        int q=Integer.parseInt(reader.readLine());
        for (int i = 0; i < q; i++) {
            String[] arr=reader.readLine().split(" ");
            int left=Integer.parseInt(arr[0]);
            int right=Integer.parseInt(arr[1]);
            System.out.println(count[right-1]-count[left-1]);
        }
    }
}
