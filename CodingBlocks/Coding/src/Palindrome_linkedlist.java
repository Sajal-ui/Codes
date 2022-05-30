import java.io.IOException;
import java.util.Scanner;

public class Palindrome_linkedlist {
  static class LinkedList{
	  int value;
	  LinkedList next;
	  public LinkedList(int value) {
		  this.value=value;
		  this.next=null;
	  }
  }
  static boolean isPalin(LinkedList head) {
	  LinkedList curr=head;
	  //LinkedList l1=head;
	  LinkedList prev=null;
	  LinkedList next=null;
	  while(curr!=null) {
		  next=curr.next;
		  curr.next=prev;
		  prev=curr;
		  curr=next;
	  }
	  while(head!=null && prev!=null) {
		  if(prev.value!=head.value) {
			  return false;
		  }
		  head=head.next;
		  prev=prev.next;
	  }
	  return true;
  }
  public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	LinkedList head=null;
	LinkedList curr=null;
	for(int i=0;i<n;i++) {
		int d=sc.nextInt();
		LinkedList l=new LinkedList(d);
		if(i==0) {
			head=l;
			curr=head;
		}
		else {
			curr.next=l;
			curr=curr.next;
		}
	}
	System.out.println(isPalin(head));
  }
}
