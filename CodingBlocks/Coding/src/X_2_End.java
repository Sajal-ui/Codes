import java.io.IOException;
import java.util.Scanner;

public class X_2_End {
  public static void main(String[] args)throws IOException {
	 Scanner sc=new Scanner(System.in);
	 String str=sc.next();
	 int n=str.length();
	 String X="";
	 String ans="";
	 for(int i=0;i<n;i++) {
		 if(str.charAt(i)=='x') {
			 X+='x';
		 }
		 else {
			 ans+=str.charAt(i);
		 }
	 }
	 ans+=X;
	 System.out.println(ans);
	 sc.close();
  }
}
