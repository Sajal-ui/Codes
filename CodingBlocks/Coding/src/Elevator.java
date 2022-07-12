import java.io.IOException;
import java.util.Scanner;

public class Elevator {
    static int findNum(int[] table,int n,int num,int limit){
        for (int i = 0; i < n; i++) {
            if(table[i]+num<=limit){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
        }
        int[] table=new int[n];
        table[0]=A[0];
        int len=1;
        for (int i = 1; i < table.length; i++) {
            int pos=findNum(table,len,A[i],x);
            if(pos==-1){
                table[len++]=A[i];
            }
            else{
                table[pos]+=A[i];
            }
        }
        System.out.println(len);
    }
}
