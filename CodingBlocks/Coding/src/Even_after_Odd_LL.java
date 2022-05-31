import java.io.IOException;
import java.util.Scanner;

public class Even_after_Odd_LL {
   static class LinkedList{
	   int value;
	   LinkedList next;
	   public LinkedList(int value) {
		   this.value=value;
		   this.next=null;
	   }
   }
   public static void main(String[] args) throws IOException {
	 Scanner sc=new Scanner(System.in);
	 int n=sc.nextInt();
	 LinkedList oddStart=null;
	 LinkedList oddEnd=null;
	 LinkedList evenStart=null;
	 LinkedList evenEnd=null;
	 LinkedList head=null;
	 for(int i=0;i<n;i++) {
		 int h=sc.nextInt();
		 if(h%2==1) {
			 if(oddStart==null) {
				 LinkedList l=new LinkedList(h);
		         oddStart=l;
		         oddEnd=oddStart;
			 }
			 else {
				 LinkedList l=new LinkedList(h);
				 oddEnd.next=l;
				 oddEnd=oddEnd.next;
			 }
		 }
		 else {
			 if(evenStart==null) {
				 LinkedList l=new LinkedList(h);
				 evenStart=l;
				 evenEnd=evenStart;
			 }
			 else {
				 LinkedList l=new LinkedList(h);
				 evenEnd.next=l;
				 evenEnd=evenEnd.next;
			 }
		 }
	 }
	 head=oddStart;
	 oddEnd.next=evenStart;
	 if(evenEnd!=null) {
	   evenEnd.next=null;
	 }
	 while(head!=null) {
		 System.out.print(head.value+" ");
		 head=head.next;
	 }
	 sc.close();
   }
}   
