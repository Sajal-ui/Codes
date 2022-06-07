import java.io.IOException;
import java.util.Scanner;

public class Reverse_a_LL {
    static class LinkedList{
        int value;
        LinkedList next;
        public LinkedList(int value){
            this.value=value;
            this.next=null;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int d=sc.nextInt();
        LinkedList head=new LinkedList(d);
        LinkedList t=head;
        while((d=sc.nextInt())!=-1){
           LinkedList l=new LinkedList(d);
           t.next=l;
           t=l;
        }
        t.next=null;
        LinkedList first=head;
        LinkedList second=head.next;
        while(second!=null){
            LinkedList temp=second.next;
            second.next=first;
            first=second;
            second=temp;
        }
        head.next=null;
        head=first;
        while(head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }
        System.out.println();
        sc.close();
    }
}
