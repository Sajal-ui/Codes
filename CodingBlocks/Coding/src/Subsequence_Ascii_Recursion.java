import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsequence_Ascii_Recursion {
  static void Subsequences(List<String> list,String str,String res,int index) {
	  if(index==str.length()) {
		 //System.out.println(res); 
		 String h="";
		 h+=res;
		 list.add(h);
		 return;
	  }
	  char ch=str.charAt(index);
	  Subsequences(list,str,res,index+1);
	  Subsequences(list,str,res+String.valueOf(ch),index+1);
	  Subsequences(list,str,res+String.valueOf((int)ch),index+1);
  }
  public static void main(String[] args) throws IOException {
	 Scanner sc= new Scanner(System.in);
	 String str=sc.next();
	 List<String> list=new ArrayList<>();
	 String res="";
	 int i=0;
	 Subsequences(list,str,res,i);
	 for(String sd:list) {
		 System.out.print(sd+" ");
	 }
	 System.out.println();
	 System.out.println(list.size());
  }
}
