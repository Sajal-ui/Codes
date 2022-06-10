import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Min_Max_Codechef {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n=Integer.parseInt(reader.readLine());
            String[] arr=reader.readLine().split(" ");
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            int flag=0;
            for (int j = 0; j < n; j++) {
                int data=Integer.parseInt(arr[j]);
                if(data<=min){
                    min=data;
                }
                else if(data>=max){
                    max=data;
                }
                else{
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
