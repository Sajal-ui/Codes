import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pascal_triangle {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();
        l.add(1);
        list.add(l);
        if(n==1){
            System.out.println(list);
        }
        else{
            for (int i = 1; i < n; i++) {
                ArrayList<Integer> al=new ArrayList<>();
                al.add(1);
                for (int j = 0; j < i-1; j++) {
                    ArrayList<Integer> ap=list.get(i-1);
                    int h=ap.get(j)+ap.get(j+1);
                    al.add(h);
                }
                al.add(1);
                list.add(al);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i));
        }
        sc.close();
    }
}
