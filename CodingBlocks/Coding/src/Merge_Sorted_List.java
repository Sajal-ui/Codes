import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Merge_Sorted_List {
   public static void main(String[] args) throws IOException {
	  Scanner sc=new Scanner(System.in);
	  int t=sc.nextInt();
	  sc.nextLine();
	  for(int test=0;test<t;test++) {
		  int n1=sc.nextInt();
		  sc.nextLine();
		  LinkedList<Integer> list1=new LinkedList<>();
		  LinkedList<Integer> list2=new LinkedList<>();
		  LinkedList<Integer> list3=new LinkedList<>();
		  for(int i=0;i<n1;i++) {
			  list1.offerLast(sc.nextInt());
		  }
		  sc.nextLine();
		  int n2=sc.nextInt();
		  sc.nextLine();
		  for(int i=0;i<n2;i++) {
			  list2.offerLast(sc.nextInt());
		  }
		  //System.out.println(list1+" "+list2);
		  int i=0,j=0;
		  while(i<n1 && j<n2) {
			  if(list1.get(i)<list2.get(j)) {
				  list3.offerLast(list1.get(i));
				  i++;
			  }
			  else {
				  list3.offerLast(list2.get(j));
				  j++;
			  }
		  }
		  while(i<n1) {
			  list3.offerLast(list1.get(i));
			  i++;
		  }
		  while(j<n2) {
			  list3.offerLast(list2.get(j));
			  j++;
		  }
		  for(Integer tl:list3) {
			  System.out.print(tl+" ");
		  }
		  System.out.println();
		  sc.close();
	  }
   }
}
