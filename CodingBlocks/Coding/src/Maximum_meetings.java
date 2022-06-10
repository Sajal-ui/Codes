import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Maximum_meetings{
    static class Meeting{
        int start_t;
        int end_t;
        int meet_no;
        public Meeting(int start_t,int end_t,int no){
            this.start_t=start_t;
            this.end_t=end_t;
            this.meet_no=no;
        }
    }
    static class Sortify implements Comparator<Meeting>{
        public int compare(Meeting m1,Meeting m2){
            return m1.end_t-m2.end_t;
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Meeting> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start=sc.nextInt();
            int end=sc.nextInt();
            Meeting m=new Meeting(start,end,(i+1));
            list.add(m);
        }
        int s=-1;
        int e=-1;
        ArrayList<Integer> A=new ArrayList<>();
        Collections.sort(list,new Sortify());
        for (Meeting meet : list) {
            int start=meet.start_t;
            int end=meet.end_t;
            int number=meet.meet_no;
            if(start>=e){
                s=start;
                e=end;
                A.add(number);
            }
        }
        System.out.println(A);
        sc.close();
    }
}