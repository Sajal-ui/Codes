import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Fractional_Knapsack {
    static class Pair{
       int weight;
       int value;
       double valperweight;
       public Pair(int weight,int value){
           this.weight=weight;
           this.value=value;
           this.valperweight=value/(weight*1.0);
       }
    }
    static class Sortify implements Comparator<Pair>{
        public int compare(Pair p1,Pair p2){
            if(p1.valperweight>=p2.valperweight){
                return -1;
            }
            else{
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int W=sc.nextInt();
        Pair[] items=new Pair[n];
        for (int i = 0; i < n; i++) {
            int w=sc.nextInt();
            int v=sc.nextInt();
            items[i]=new Pair(w,v);
        }
        Arrays.sort(items,new Sortify());
        double cost=0;
        for (int i = 0; i < items.length; i++) {
            Pair p=items[i];
            //System.out.println(p.value+" "+p.weight);
            if(W==0){
                break;
            }
            if(p.weight<=W){
              cost+=(p.value*1.0);
              W=W-p.weight;
            }
            else{
                cost+=(p.valperweight*W);
                W=0;
            }
            //System.out.println(cost);
        }
        System.out.println(cost);
        sc.close();
    }
}
