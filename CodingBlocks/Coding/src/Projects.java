import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Projects {
    static class Pair{
        int start;
        int end;
        int weight;
        public Pair(int start,int end,int weight){
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
    }
    static int binarySearch(Pair[] pairs,int index){
        int low=0;
        int high=index-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(pairs[index].start>pairs[mid].end){
                  if(pairs[index].start>pairs[mid+1].end){
                      low=mid+1;
                  }
                  else{
                    return mid;
                  }
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Pair[] pairs=new Pair[n];
        for (int i = 0; i < n; i++) {
            int start=sc.nextInt();
            int end=sc.nextInt();
            int weight=sc.nextInt();
            pairs[i]=new Pair(start, end, weight);
        }
        Arrays.sort(pairs,new Comparator<Pair>() {
            public int compare(Pair p1,Pair p2){
                return p1.end-p2.end;
            }
        });
        long[] table=new long[n];
        table[0]=pairs[0].weight;
        for (int i = 1; i < n; i++) {
            //System.out.println(pairs[i].start+"/"+pairs[i].end+"/"+pairs[i].weight);
            long inclProf=pairs[i].weight;
            int l=binarySearch(pairs,i);
            //System.out.println(pairs[i].start+"/"+pairs[i].end+"/"+pairs[i].weight+"/"+l);
            if(l!=-1){
                inclProf+=table[l];
            }
            table[i]=Math.max(inclProf,table[i-1]);
        }
        System.out.println(table[n-1]);
        sc.close(); 
    }
}
