import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Good_String {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(reader.readLine());
        for(int test=0;test<t;test++){
            int n=Integer.parseInt(reader.readLine());
            long cnt0=0L,cnt1=0L,cnt2=0L;
            for (int i = 0; i < n; i++) {
                boolean f0=false,f1=false;
                String str=reader.readLine();
                for (int j = 0; j < str.length(); j++) {
                    if(str.charAt(j)=='0'){
                        f0=true;
                    }
                    else{
                        f1=true;
                    }
                }
                if(f0 && f1){
                    cnt2++;
                }         
                else if(f1){
                    cnt1++;
                }       
                else{
                    cnt0++;
                }
            }            
            System.out.println((cnt0*cnt2)+(cnt1*cnt2)+(cnt2*(cnt2-1)/2)+(cnt1*(cnt1-1)/2)+(cnt0*(cnt0-1)/2));
        }
    }
}
