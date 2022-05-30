import java.io.IOException;
import java.util.Scanner;
public class Replace_al_pi {
   static String Answer_Split(String h,String pattern) {
	   String[] arr=h.split(pattern,2);
	   if(arr.length==1) {
		 return arr[0];  
	   }
	   return arr[0]+"3.14"+Answer_Split(arr[1],pattern);
   }
   public static void main(String[] args) throws IOException{
	  Scanner sc=new Scanner(System.in);
	  int n=sc.nextInt();
	  sc.nextLine();
	  for(int i=0;i<n;i++) {
		 String h=sc.nextLine();
		 String pattern="pi";
		 String ans="";
		 String[] arr=h.split(pattern,2);
		 //System.out.println(arr.length);
		 if(arr.length!=1) {
		   ans=arr[0]+"3.14"+Answer_Split(arr[1],pattern);
		 }
		 System.out.println(ans);
	  }
   }
}
