import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Large_factorials {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        for(int i=2;i<=n;i++){
           ArrayList<Integer> l=new ArrayList<>(); 
           int c=0;
           for(int j=list.size()-1;j>=0;j--){ 
              int h= list.get(j)*i+c;
              c=h/10; 
              l.add(0,h%10);

           }
           while(c!=0){
               l.add(0,c%10);
               c=c/10;
           }
           list.clear();
           list.addAll(l); 
           //System.out.println(list);
        }
        System.out.println(list);
        sc.close();
    }
}
