import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Nested_Ranges_Count {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        ArrayList<int[]> array=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] A=new int[3];
            String[] arr=reader.readLine().split(" ");
            A[0]=Integer.parseInt(arr[0]);
            A[1]=Integer.parseInt(arr[1]);
            A[2]=i;
            array.add(A);
        }
        Collections.sort(array,new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            }
        });
        ArrayList<Integer> list=new ArrayList<>();
        list.add(array.get(0)[1]);
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        for (int i = 1; i < array.size(); i++) {
            int index=array.get(i)[2];
            int pos=Collections.binarySearch(list,array.get(i)[1]);
            if(pos<0){
                pos*=(-1);
                pos-=1;
            }
           // System.out.println(array.get(i)[1]+" "+pos);
            list.add(pos,array.get(i)[1]);
            arr2[index]=(list.size()-pos-1);
        }
        ArrayList<Integer> lp=new ArrayList<>();
        lp.add(array.get(array.size()-1)[1]);
        for (int i = array.size()-2; i >= 0; i--) {
            int index=array.get(i)[2];
            int pos=Collections.binarySearch(lp,array.get(i)[1]);
            if(pos>=0){
              lp.add(pos,array.get(i)[1]);
              arr1[index]=(pos+1);
            }
            if(pos<0){
                pos*=(-1);
                pos-=1;
                lp.add(pos,array.get(i)[1]);
                arr1[index]=(pos-0);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i]+" ");
        }
    }
}
