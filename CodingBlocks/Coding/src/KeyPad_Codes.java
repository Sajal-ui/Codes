import java.io.IOException;
import java.util.Scanner;

public class KeyPad_Codes {
  static int count=0;	
  static void createCode(String str,String[] Codes,int index,int n,StringBuilder sb) {
	  if(index==n) {
		  System.out.print(sb.toString()+" ");
		  count++;
		  return;
	  }
	  int k=str.charAt(index)-'0';
	  String code=Codes[k];
	  for(int i=0;i<code.length();i++) {
		  sb.append(code.charAt(i));
		  createCode(str,Codes,index+1,n,sb);
		  sb.deleteCharAt(sb.toString().length()-1);
	  }
  }
  public static void main(String[] args) throws IOException {
	 Scanner sc=new Scanner(System.in);
	 String str=sc.next();
	 String[] Codes= {" ","abc","def","ghi","jkl","mno","pqrs","tuv","wx","yz"};
	 StringBuilder sb=new StringBuilder();
	 createCode(str,Codes,0,str.length(),sb);
	 System.out.println();
	 System.out.println(count);
	 sc.close();
  }
}
