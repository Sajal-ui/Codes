import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Merge_Intervals {
    static class SortBy implements Comparator<ArrayList<Integer>>{
        public int compare(ArrayList<Integer> a1,ArrayList<Integer> a2){
              return a1.get(0)-a2.get(0);
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<ArrayList<Integer>> queue=new PriorityQueue<>(new SortBy());
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> a=new ArrayList<>();
            a.add(sc.nextInt());
            a.add(sc.nextInt());
            queue.add(a);
        }
        int start=-1;
        List<ArrayList<Integer>> list=new ArrayList<>();
        int end=-1;
        while(!queue.isEmpty()){
            ArrayList<Integer> a=queue.poll();
            ArrayList<Integer> b=new ArrayList<>();
            if(start==-1 && end==-1){
                start=a.get(0);
                end=a.get(1);
            }
            else{
                if(start<=a.get(0) && a.get(0)<=end){
                    end=Math.max(end,a.get(1));
                    list.remove(list.size()-1);
                }
                else{
                    start=a.get(0);
                    end=a.get(1);
                }
            }
            b.add(start);
            b.add(end);
            list.add(b);
        }
        System.out.println(list);
        sc.close();
    }
}
