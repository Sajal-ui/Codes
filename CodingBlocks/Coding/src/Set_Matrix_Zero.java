import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Set_Matrix_Zero{
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] A=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j]=sc.nextInt();
            }
        }
        HashSet<Integer> rows=new HashSet<>();
        HashSet<Integer> columns=new HashSet<>();
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(A[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(rows.contains(i) || columns.contains(j)){
                    A[i][j]=0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}