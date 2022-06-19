import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Word_Break_ii {
    static void Word_Break(ArrayList<String> A,ArrayList<String> B,String str,HashSet<String> hash,int index,int n){
        if(index==n){
            String s="";
            for(String a:B){
                s=s+(a+" ");
            }
            A.add(s);
        }
        for(int i=index;i<n;i++){
            if(hash.contains(str.substring(index,i+1))){
                //System.out.println(str.substring(index,i+1));
                B.add(str.substring(index,i+1));
                Word_Break(A, B, str, hash, i+1, n);
                B.remove(B.size()-1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hash=new HashSet<>();
        int n=Integer.parseInt(reader.readLine());
        String[] arr=reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            hash.add(arr[i]);
        }
        String str=reader.readLine();
        int len=str.length();
        ArrayList<String> A=new ArrayList<>();
        ArrayList<String> B=new ArrayList<>();
        Word_Break(A,B,str,hash,0,len);
        System.out.println(A);
    }
}
