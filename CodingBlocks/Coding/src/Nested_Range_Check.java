import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Nested_Range_Check {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        ArrayList<int[]> array=new ArrayList<>();
        int[] ans1=new int[n];
        int[] ans2=new int[n];
        for (int i = 0; i < n; i++) {
            String[] arr=reader.readLine().split(" ");
            int[] A=new int[3];
            A[0]=Integer.parseInt(arr[0]);
            A[1]=Integer.parseInt(arr[1]);
            A[2]=i;
            array.add(A);
        }
        Collections.sort(array,new Comparator<int[]>(){
           public int compare(int[] a1,int[] a2){
              if(a1[0]==a2[0]){
                return a2[1]-a1[1];
              }
              return a1[0]-a2[0];
           }
        });
        int max_e=array.get(0)[1];
        //int index=array.get(0)[2];
        for(int i=1;i<array.size();i++){
            int ed=array.get(i)[1];
            int in=array.get(i)[2];
            if(ed<=max_e){
               //ans1[index]=1;
               ans2[in]=1;
            }
            if(ed>max_e){
                max_e=ed;
                //index=in;
            }
        }
        max_e=array.get(array.size()-1)[1];
        //index=array.get(array.size()-1)[2];
        for(int i=array.size()-2;i>=0;i--){
            int ed=array.get(i)[1];
            int in=array.get(i)[2];
            if(ed>=max_e){
                ans1[in]=1;
            }
            if(ed<max_e){
                max_e=ed;
               // index=in;
            }
        }
        for (int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i]+" ");
        }
        System.out.println();
    }
}
