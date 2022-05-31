import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Subsequence_Recursion {
  public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in); 
	//int n=sc.nextInt();
	sc.nextLine();
	String str=sc.nextLine();
	int len=str.length();
	List<String> list=new ArrayList<>();
	int limit=(int)Math.pow(2, len);
	for(int i=0;i<limit;i++) {
		StringBuilder sb=new StringBuilder();
		for(int j=0;j<len;j++) {
			sb.append(String.valueOf((i>>j)&1));
		}
		list.add(sb.reverse().toString());
	}
	//System.out.println(list);
	List<String> ans=new ArrayList<>();
	for(String h:list) {
		int n1=h.length();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n1;i++) {
		  if(h.charAt(i)=='1') {
			  sb.append(str.charAt(i));
		  }
		}
		ans.add(sb.toString());
	}
	Collections.sort(ans);
	for(String t:ans) {
		System.out.println(t);
	}
	System.out.println(ans.size());
	sc.close();
  }
}
