import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Removing_Digits{
    static int Get_Answer(int[] count,int n){
        if(count[n]!=-1){
            return count[n];
        }
        String h=String.valueOf(n);
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < h.length(); i++) {
            int number=h.charAt(i)-'0';
            //System.out.println(n+" "+number);
            if(number!=0){
               min=Math.min(min,Get_Answer(count,n-number)+1);
            }
        }
        return count[n]=min;
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] count=new int[n+1];
        Arrays.fill(count,-1);
        count[0]=0;
        for(int i=1;i<10;i++){
            count[i]=1;
        }
        System.out.println(Get_Answer(count,n));
        sc.close(); 
    }
}