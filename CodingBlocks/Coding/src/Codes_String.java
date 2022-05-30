import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Codes_String {
   static void CodeUp(List<String> list,String str,String res,int start,int end,char[] alpha) {
	   if(start==end) {
		   String h="";
		   h+=res;
		   list.add(h);
		   return;
	   }
	   int index=str.charAt(start)-'1';
	   CodeUp(list,str,res+String.valueOf(alpha[index]),start+1,end,alpha);
	   if(start==end-1) {
		   return;
	   }
	   index=Integer.parseInt(str.substring(start,start+2))-1;
	   if(index<=25) {
		   CodeUp(list,str,res+String.valueOf(alpha[index]),start+2,end,alpha);
	   }
   }
   public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 String str=sc.nextLine();
	 List<String> list=new ArrayList<>();
	 String res="";
	 char[] alpha= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	 CodeUp(list,str,res,0,str.length(),alpha);
	 System.out.println(list);
   }
}
