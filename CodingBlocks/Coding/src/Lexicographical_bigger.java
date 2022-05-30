import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lexicographical_bigger {
   public static void main(String[] args)throws IOException{
	  Scanner sc=new Scanner(System.in);
	  String str=sc.next();
	  int n=str.length()-1;
	  Character[] a=new Character[n+1];
	  for(int i=0;i<=n;i++) {
		  a[i]=str.charAt(i);
	  }
	  int par=n;
	  for(int i=n-1;i>=0;i--) {
		 int k1=str.charAt(i)-'a';
		 int k2=str.charAt(i+1)-'a';
		 if(k1>k2) {
			 //System.out.println((char)(k1+'a')+" "+(char)(k2+'a'));
			 par=i;
			 break;
		 }
	  }
	  //System.out.println(par);
	  if(par!=n) {
		 for(int i=n;i>=0;i--) {
			 int k1=str.charAt(i)-'a';
			 int k2=str.charAt(par)-'a';
			 if(k1<k2) {
				 Character temp=a[i];
				 a[i]=a[par];
				 a[par]=temp;
				 break;
			 }
		 }
		 int i=par+1;
		 int j=n;
		 while(i<j) {
			 Character temp=a[i];
			 a[i]=a[j];
			 a[j]=temp;
			 i++;
			 j--;
		 }
		 StringBuilder sb=new StringBuilder();
		 for(int k=0;k<=n;k++) {
			 sb.append(a[k]);
		 }
		 System.out.println(sb.toString());
	  }
	  else {
		  System.out.println(str);
	  }
   }
}
