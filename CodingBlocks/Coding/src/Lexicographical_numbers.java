import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Lexicographical_numbers {
  public static void main(String[] args) throws IOException{
	 Scanner sc=new Scanner(System.in);
	 int n=sc.nextInt();
	 PriorityQueue<String> queue=new PriorityQueue<>();
	 for(int i=0;i<=n;i++) {
		 queue.add(String.valueOf(i));
	 }
	 //System.out.println(queue);
	 while(!queue.isEmpty()) {
		 System.out.print(queue.poll()+" ");
	 }
  }
}
