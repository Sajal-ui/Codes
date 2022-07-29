import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loop_Problem {
    static long count(int n, int i) {
        //long m=(long)n+1;
        if((1<<i)>n){
            return 0L;
        }
        long pow=1<<i;
        long dist=n-pow+1;
        long ans=pow*(dist/2*pow);
        ans+=Math.min(pow,(dist%(2*pow)));
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] arr = reader.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            int d = Integer.parseInt(arr[3]);
            int mod=1000000007;
            long sum=0L;
            for (int j = 31; j>=0; j--) {
                //System.out.println(j+" "+count(b,j)+" "+count(a-1,j)+" "+count(d,j)+" "+count(c-1,j));
                long ones1=count(b,j)-count(a-1,j);
                long zeroes1=b-a+1-ones1;
                long ones2=count(d,j)-count(c-1,j);
                long zeroes2=d-c+1-ones2;
                long cont1=(ones1%mod*zeroes2%mod)%mod;
                long cont2=(ones2%mod*zeroes1%mod)%mod;
                long cont=(cont1%mod+cont2%mod)%mod;
                //System.out.println(j+" "+ones1+" "+ones2+" "+zeroes1+" "+zeroes2+" "+sum+" "+cont1+" "+cont2);
                sum=(sum%mod+(cont%mod*((long)Math.pow(2,j)%mod))%mod)%mod;
                //System.out.println(j+" "+sum);
            }
            System.out.println(sum);
        }
    }
}