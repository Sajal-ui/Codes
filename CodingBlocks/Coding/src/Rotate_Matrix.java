import java.io.IOException;
import java.util.Scanner;

public class Rotate_Matrix {
    static void rotate_matrix(int[][] A,int i,int j,int rows,int cols){
        if(i>=rows || j>=cols){
            return;
        }
        int s_r=i;
        int s_c=j;
        int t=A[s_r][s_c];
        for (int k = s_c+1; k <=cols; k++) {
            int temp=A[s_r][k];
            A[s_r][k]=t;
            t=temp;
        }
        for (int k = 1; k <=rows; k++) {
            int temp=A[k][cols];
            A[k][cols]=t;
            t=temp;
        }
        for (int k = cols-1; k>=s_c; k--) {
            int temp=A[rows][k];
            A[rows][k]=t;
            t=temp;
        }
        for (int k = rows-1; k >=s_r ; k--) {
            int temp=A[k][s_c];
            A[k][s_c]=t;
            t=temp;
        }
        rotate_matrix(A, i+1, j+1, rows-1, cols-1);
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] A=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j]=sc.nextInt();
            }
        }
        rotate_matrix(A,0,0,n-1,m-1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    } 
}
