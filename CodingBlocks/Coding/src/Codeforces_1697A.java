import java.util.Scanner;

public class Codeforces_1697A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int sum=0;
            for (int j = 0; j < n; j++) {
                sum+=sc.nextInt();
            }
            if(m>=sum){
                System.out.println(0);
            }
            else{
                System.out.println(sum-m);
            }
        }
        sc.close();
    }
}
