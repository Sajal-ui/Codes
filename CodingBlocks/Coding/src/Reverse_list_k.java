import java.io.IOException;
import java.util.Scanner;

public class Reverse_list_k {
  static class LinkedList{
	  int value;
	  LinkedList next;
	  public LinkedList(int value) {
		  this.value=value;
		  this.next=null;
	  }
  }
  static LinkedList reverse(LinkedList head,int k) {
	  if(head==null) {
		  return null;
	  }
	  //System.out.println(head.value);
	  LinkedList current=head;
	  LinkedList prev=null;
	  LinkedList next=null;
	  int count=0;
	  while(count<k && current!=null) {
		next=current.next;
		current.next=prev;
		prev=current;
		current=next;
		count++;
	  }
	  if(next!=null) {
		  head.next=reverse(next,k);
//		  if(head.next==null) {
//			  System.out.println("&&");
//		  }
//		  else {
//			  System.out.println("*&"+head.value+" "+head.next.value);
//		  }
	  }
	  return prev;
  }
  public static void main(String[] args)throws IOException {
	 Scanner sc=new Scanner(System.in);
	 int n=sc.nextInt();
	 int k=sc.nextInt();
	 LinkedList head=null;
	 LinkedList curr=null;
	 for(int i=0;i<n;i++) {
		 LinkedList l=new LinkedList(sc.nextInt());
		 if(i==0) {
			 head=l;
			 curr=head;
		 }
		 else {
			 curr.next=l;
			 curr=curr.next;
		 }
	 }
	 head=reverse(head,k);
	 //int f=0;
	 while(head!=null) {	 
	   System.out.print(head.value+" ");
	  // f++;
	   head=head.next;
	 }
	 sc.close();
  }
}
