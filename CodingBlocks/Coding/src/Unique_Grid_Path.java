import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Unique_Grid_Path {
   static int count=0; 
   static void Grid_Path(int[][] visited,int i,int j,int m,int n){
      if(i==m && j==n){
          count+=1;
      }
      visited[i][j]=1;
      if(i+1<=m && visited[i+1][j]==0){
          Grid_Path(visited, i+1, j, m, n);
      }
      if(j+1<=n && visited[i][j+1]==0){
          Grid_Path(visited, i, j+1, m, n);
      }
      visited[i][j]=0;
   }
   public static void main(String[] args) throws IOException{
       Scanner sc=new Scanner(System.in);
       int m=sc.nextInt();
       int n=sc.nextInt();
       int[][] visited=new int[m][n];
       for(int[] rows:visited){
           Arrays.fill(rows,0);
       }
       Grid_Path(visited,0,0,m-1,n-1);
       System.out.println(count);
       sc.close();
   } 
}
