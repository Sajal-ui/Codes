import java.io.IOException;
import java.util.Scanner;

public class Tower_of_Hanoi {
  static int count=0;	
  static void Steps(int n,String from,String aux,String to){
     if(n==0) {
    	 return;
     }
     Steps(n-1,from,to,aux);
     count+=1;
     System.out.println("Move "+n+"th disc from "+from+" to "+to);
     Steps(n-1,aux,from,to);
  }
  public static void main(String[] args) throws IOException{
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	Steps(n,"T1","T3","T2");
	System.out.println(count);
  }
}
