import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Codeforces_729B {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=reader.readLine().split(" ");
        int n=Integer.parseInt(arr[0]);
        int m=Integer.parseInt(arr[1]);
        int[][] matrix=new int[n][m];
        int[][] count=new int[n][m];
        for (int i = 0; i < n; i++) {
            arr=reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j]=Integer.parseInt(arr[j]);
            }
        }
        int[][] up=new int[n][m];
        int[][] down=new int[n][m];
        int[][] left=new int[n][m];
        int[][] right=new int[n][m];
        for (int j = 0; j < m; j++) {
            up[0][j]=matrix[0][j];
        }
        for (int j = 0; j < m; j++) {
            down[n-1][j]=matrix[n-1][j];
        }
        for (int j = 0; j < n; j++) {
            left[j][0]=matrix[j][0];
        }
        for (int j = 0; j < n; j++) {
            right[j][m-1]=matrix[j][m-1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(up[i-1][j]==1 || matrix[i][j]==1){
                    up[i][j]=1;
                }
            }
        }
        for (int i = n-2; i>=0; i--) {
            for (int j = 0; j < m; j++) {
                if(down[i+1][j]==1 || matrix[i][j]==1){
                    down[i][j]=1;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(left[j][i-1]==1 || matrix[j][i]==1){
                    left[j][i]=1;
                }
            }
        }
        for (int i = m-2; i >=0; i--) {
            for (int j = 0; j < n; j++) {
                if(right[j][i+1]==1 || matrix[j][i]==1){
                    right[j][i]=1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==0){
                   if(i-1>=0 && up[i-1][j]==1){
                      count[i][j]+=1;
                   }
                   if(i+1<n && down[i+1][j]==1){
                      count[i][j]+=1;
                   }
                   if(j-1>=0 && left[i][j-1]==1){
                      count[i][j]+=1;
                   }
                   if(j+1<m && right[i][j+1]==1){
                      count[i][j]+=1;
                   } 
                }
            }
        }
        long s=0L;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //System.out.println(i+" "+j+" "+count[i][j]);
                s+=count[i][j];
            }
        }
        System.out.println(s);
    }
}
