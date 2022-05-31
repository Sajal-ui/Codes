import java.io.IOException;
import java.util.Scanner;

public class kth_element_from_last {
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
	 int count=0;
	 LinkedList head=null;
	 LinkedList curr=null;
	 int h;
	 while((h=sc.nextInt())!=-1) {
		 //System.out.println(h);
		 LinkedList l=new LinkedList(h);
		 if(head==null) {
			 head=l;
			 curr=head;
		 }
		 else {
			 curr.next=l;
			 curr=curr.next;
		 }
		 count++;
	 }
	 int k=sc.nextInt();
	 int n=count-k;
	 int i=0;
//	 if(head==null) {
//		 System.out.println("**");
//	 }
	 while(i<n) {
		 head=head.next;
		 i++;
	 }
	 System.out.println(head.value);
	 sc.close();
   }
}
