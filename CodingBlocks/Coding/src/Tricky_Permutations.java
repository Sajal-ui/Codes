import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Tricky_Permutations {
  static void check(HashSet<String> list,String str,int i,int n) {
	 if(i==n-1) {
		 return;
	 }
	 Character[] ch1=new Character[n];
	 Character[] ch2=new Character[n];
	 for(int k=0;k<n;k++) {
		 ch1[k]=str.charAt(k);
		 ch2[k]=ch1[k];
	 }
	 for(int j=i+1;j<n;j++) {
		 char temp=ch2[i];
		 ch2[i]=ch2[j];
		 ch2[j]=temp;
		 StringBuilder sb=new StringBuilder();
		 for(int k=0;k<n;k++) {
			 sb.append(ch2[k]);
			 ch2[k]=ch1[k];
		 }
		 list.add(sb.toString());
		 check(list,sb.toString(),i+1,n);
	 }
  }
  public static void main(String[] args)throws IOException {
	Scanner sc=new Scanner(System.in);
	String str=sc.next();
	int n=str.length();
	HashSet<String> list=new HashSet<>();
    check(list,str,0,n);
    ArrayList<String> l=new ArrayList<>();
    l.addAll(list);
    Collections.sort(l);
	for(String h:l) {
		System.out.println(h);
	}
  }
}
