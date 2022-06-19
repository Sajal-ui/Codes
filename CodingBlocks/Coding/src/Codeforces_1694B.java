import java.io.IOException;
import java.util.Scanner;

public class Codeforces_1694B {
   public static void main(String[] args) throws IOException{
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      for (int i = 0; i < t; i++) {
         int n=sc.nextInt();
         sc.nextLine();
         String str=sc.nextLine();
         long total_ways=1L;
         for (int j = 1; j < n; j++) {
            if(str.charAt(j)==str.charAt(j-1)){
                total_ways+=1;
            }
            else{
                total_ways+=(j+1);
            }
         }
         System.out.println(total_ways);
      }
      sc.close();
   } 
}
