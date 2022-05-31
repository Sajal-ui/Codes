import java.io.IOException;
import java.util.Scanner;

public class Seperate_by_Star {
  public static void main(String[] args) throws IOException{
	Scanner sc=new Scanner(System.in);
	String str=sc.next();
	char ch=str.charAt(0);
	String res=String.valueOf(ch);
	for(int i=1;i<str.length();i++) {
		if(ch==str.charAt(i)) {
			res+=String.valueOf('*');
		}
		ch=str.charAt(i);
		res+=String.valueOf(ch);
	}
	System.out.println(res);
	sc.close();
  }
}
