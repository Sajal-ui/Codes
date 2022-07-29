import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Codeforces_197D {
    static class SegmentTrees{
        int[] tree;
        public SegmentTrees(int n){
           int maxSize=2*n+1;
           this.tree=new int[maxSize];
        }
    }
    static int create(SegmentTrees root,int[] arr,int left,int right,int index,int[] res){
        if(left==right){
            res[0]=0;
            return root.tree[index]=arr[left];
        }
        int mid=(left+right)/2;
        int l=create(root, arr, left, mid, 2*index+1,res);
        int r=create(root, arr, mid+1, right, 2*index+2,res);
        res[0]+=1;
        if(res[0]%2!=0){
           return root.tree[index]=l | r;
        }
        else{
           return root.tree[index]=l ^ r; 
        }
    }
    static int update(SegmentTrees root,int left,int right,int f,int n_index,int index,int[] res){
       if(left==right){
          if(left==n_index){
              res[0]=0;
              return root.tree[index]=f;
          }
       }
       int mid=(left+right)/2;
       int p=0;
       int q=0;
       if(n_index<=mid){
          p=update(root, left, mid, f, n_index, 2*index+1, res);
          q=root.tree[2*index+2]; 
       }
       else{
          q=root.tree[2*index+1];
          p=update(root, mid+1, right, f, n_index, 2*index+2, res);
       }
       res[0]+=1;
       if(res[0]%2!=0){
          return root.tree[index]=p | q;
       }
       else{
          return root.tree[index]=p ^ q;
       }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] A=reader.readLine().split(" ");
        int n=Integer.parseInt(A[0]);
        int m=Integer.parseInt(A[1]);
        int[] res=new int[1];
        int size=(int)Math.pow(2,n);
        A=reader.readLine().split(" ");
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=Integer.parseInt(A[i]);
        }
        SegmentTrees root=new SegmentTrees(size);
        create(root, arr, 0, size-1, 0,res);
        for (int i = 0; i < m; i++) {
            A=reader.readLine().split(" ");
            int p=Integer.parseInt(A[0])-1;
            int b=Integer.parseInt(A[1]);
            res[0]=0;
            System.out.println(update(root, 0, size-1, b, p, 0, res));
        }
    }
}
