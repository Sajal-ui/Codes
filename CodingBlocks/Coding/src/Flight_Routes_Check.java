import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Flight_Routes_Check {
    static void dfs(HashMap<Integer,ArrayList<Integer>> hash,HashSet<Integer> hs,int source){
        ArrayList<Integer> al=hash.get(source);
        if(al==null){
            return;
        }
        if(hs.contains(source)){
            return;
        }
        hs.add(source);
        for(Integer sl:al){
            dfs(hash,hs,sl);
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        HashMap<Integer,ArrayList<Integer>> hash=new HashMap<>();
        for (int i = 0; i < m; i++) {
            int source=sc.nextInt();
            int dest=sc.nextInt();
            if(hash.containsKey(source)){
               ArrayList<Integer> al=hash.get(source);
               al.add(dest);
               hash.put(source,al); 
            }     
            else{
                ArrayList<Integer> al=new ArrayList<>();
                al.add(dest);
                hash.put(source,al);
            }
        }
        HashSet<Integer> hs=new HashSet<>();
        dfs(hash,hs,1);
        if(hs.size()==n){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
        sc.close();
    }
}
