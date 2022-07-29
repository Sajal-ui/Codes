import java.util.HashMap;
import java.util.Scanner;
public class Codeforces_459D {
    static void update(int[] tree,int n,int index,int x){
        int i=index;
        while(i<=n){
            tree[i]+=x;
            i+=(i&(-i));
        }
    }
    static long sum_BIT(int[] tree,int index){
        int i=index;
        long h=0L;
        while(i>0){
           h+=tree[i];
           i-=(i&(-i));
        }
        return h;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int[] freq=new int[n];
        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(hash.containsKey(arr[i])){
                int temp=hash.get(arr[i]);
                freq[i]=temp+1;
                hash.put(arr[i],temp+1);
            }
            else{
                freq[i]=1;
                hash.put(arr[i],1);
            }
        }
        hash.clear();
        int[] tree=new int[n+1];
        long max=0L;
        for(int i=n-1;i>=0;i--){
            if(hash.containsKey(arr[i])){
                int temp=hash.get(arr[i]);
                //freq[i]=temp+1;
                hash.put(arr[i],temp+1);
            }
            else{
                //freq[i]=1;
                hash.put(arr[i],1);
            }
            max+=sum_BIT(tree,freq[i]-1);
            update(tree, n,hash.get(arr[i]), 1);
        }
        System.out.println(max);
        sc.close();
    }
}
