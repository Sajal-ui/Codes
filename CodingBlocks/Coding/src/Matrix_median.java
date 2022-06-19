import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Matrix_median {
    static int calc(int[][] matrix,int mid,int r,int c){
        int get=0;
        for (int i = 0; i < r; i++) {
            int rd=Arrays.binarySearch(matrix[i],mid);
            if(rd<0){
                get+=Math.abs(rd)-1;
            }
            else{
                get+=(rd+1);
                int g=rd+1;
                while(g<c && matrix[g]==matrix[g-1]){
                   get++;
                }
            }
        }
        return get;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=reader.readLine().split(" ");
        int r=Integer.parseInt(arr[0]);
        int c=Integer.parseInt(arr[1]);
        int[][] matrix=new int[r][c];
        for (int i = 0; i < r; i++) {
            arr=reader.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                matrix[i][j]=Integer.parseInt(arr[j]);
            }
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int j=0;j<r;j++){
           min=Math.min(min,matrix[j][0]);
           max=Math.max(max,matrix[j][c-1]);
        }
        int number=(r*c)/2;
        while(min<max){
            int mid=(min+max)/2;
            if(calc(matrix,mid,r,c)>number){
                max=mid;
            }
            else{
                min=mid+1;
            }
        }
        System.out.println(min);
    }
}
