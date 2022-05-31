import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Intersection_three_sorted_array {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int n3=sc.nextInt();
        int[] A=new int[n1];
        int[] B=new int[n2];
        int[] C=new int[n3];
        for (int i = 0; i < n1; i++) {
            A[i]=sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            B[i]=sc.nextInt();
        }
        for (int i = 0; i < n3; i++) {
            C[i]=sc.nextInt();
        }
        int i=0,j=0,k=0;
        //int count=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(i<n1 && j<n2 && k<n3){
            if(A[i]==B[j]){
              if(B[j]==C[k]){
                  list.add(B[j]);
                  i++;
                  j++;
                  k++;
              }
              else if(B[j]<C[k]){
                  i++;
                  j++;
              }
              else if(B[j]>C[k]){
                  k++;
              }
            }
            else if(A[i]<B[j]){
                if(A[i]<C[k]){
                    i++;
                }
                else{
                    k++;
                }
            }
            else{
                if(B[j]<C[k]){
                    j++;
                }
                else{
                    k++;
                }
            }
        }
        System.out.println(list);
        sc.close();
    }
}
