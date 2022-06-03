import java.io.IOException;
import java.util.Scanner;

public class Modular_Exponential {
    static int Modular_exp(int a,int b,int m){ 
       if(b==0){
           return 1;
       }
       if(b%2==0){
           long f=Modular_exp(a, b/2, m);
           System.out.println("** "+f);
           return (int)(((f%m)*(f%m))%m);
       }
       else{
           long f=Modular_exp(a, b-1, m);
           System.out.println(">> "+f);
           return (int)(((a%m)*(f%m))%m);
       }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int m=sc.nextInt();
        System.out.println(Modular_exp(a,b,m));
        sc.close();
    }
}
