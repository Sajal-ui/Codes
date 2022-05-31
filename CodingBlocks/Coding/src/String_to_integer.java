import java.io.IOException;
import java.util.Scanner;

public class String_to_integer {
  static void String2Number(String str,int n,int index,long t,long number) {
	  if(index==n) {
		  System.out.println(number);
		  return;
	  }
	  int digit=str.charAt(index)-'0';
	  number+=digit*t;
	  t/=10;
	  String2Number(str,n,index+1,t,number);
  }
  public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	String str=sc.next();
	int n=str.length();
	long t=(long)Math.pow(10, n-1);
	long number=0;
	String2Number(str,n,0,t,number);
	sc.close();
  }
}
