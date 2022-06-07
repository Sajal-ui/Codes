import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
//import java.util.HashSet;
public class Main {
    static void dfs(LinkedList<Integer>[] list,int[] visited,Integer source){
        visited[source]=1;
        for(Integer sl:list[source]){
            if(visited[sl]!=1){
              dfs(list,visited,sl);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] str=reader.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        LinkedList<Integer>[] list1=new LinkedList[n];
        LinkedList<Integer>[] list2=new LinkedList[n];
        for (int i = 0; i < n; i++) {
            list1[i]=new LinkedList<>();
            list2[i]=new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            str=reader.readLine().split(" ");
            int source=Integer.parseInt(str[0]);
            int dest=Integer.parseInt(str[1]);
            list1[source-1].add(dest-1);
            list2[dest-1].add(source-1);            
        }
        int[] visited1=new int[n];
        int[] visited2=new int[n];
        dfs(list1,visited1,0);
        dfs(list2,visited2,0);
        int count1=0,count2=0;
        int f=-1,g=-1;
        for (int i = 0; i < n; i++) {
            if(visited1[i]==1){
                count1++;
            }
            else{
                f=i+1;
            }
        }
        for (int i = 0; i < n; i++) {
            if(visited2[i]==1){
                count2++;
            }
            else{
                g=i+1;
            }
        }
        //System.out.println(count1+" "+count2);
        if(count1==n && count2==n){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
            if(f!=-1){
                System.out.println("1 "+f);
            }
            else if(g!=-1){
                System.out.println(g+" 1");
            }
        }
    }
}
