import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class String_Queries {
    static class Pair{
        int[] alphabets;
        public Pair(){
            this.alphabets=new int[26];
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=reader.readLine().split(" ");
        int n=Integer.parseInt(arr[0]);
        int q=Integer.parseInt(arr[1]);
        String str=reader.readLine();
        Pair[] pairs=new Pair[n];
        for (int i = 0; i < n; i++) {
            if(i==0){
                int index=str.charAt(i)-'a';
                pairs[i]=new Pair();
                pairs[i].alphabets[index]++;
            }
            else{
                int index=str.charAt(i)-'a';
                pairs[i]=new Pair();
                for (int j = 0; j < 26; j++) {
                    if(j==index){
                        pairs[i].alphabets[index]=pairs[i-1].alphabets[index]+1;
                    }
                    else{
                        pairs[i].alphabets[j]=pairs[i-1].alphabets[j];
                    }
                }
            }
        }
        for(int i=0;i<q;i++){
            arr=reader.readLine().split(" ");
            int left=Integer.parseInt(arr[0])-1;
            int right=Integer.parseInt(arr[1])-1;
            HashMap<Integer,Integer> hash=new HashMap<>();
            //HashMap<Integer,Integer> hash1=new HashMap<>();
            //int d=0;
            if(left==0){
                for (int j = 0; j < 26; j++) {
                    if(pairs[right].alphabets[j]!=0){
                        if(hash.containsKey(pairs[right].alphabets[j])){
                          int temp=hash.get(pairs[right].alphabets[j]);
                          hash.put(pairs[right].alphabets[j],temp+1);  
                        }
                        else{
                           hash.put(pairs[right].alphabets[j],1); 
                        }
                    }
                }
            }    
            else{
                for (int j = 0; j < 26; j++) {
                    if(pairs[right].alphabets[j]-pairs[left-1].alphabets[j]>0){
                        if(hash.containsKey(pairs[right].alphabets[j]-pairs[left-1].alphabets[j])){
                          int temp=hash.get(pairs[right].alphabets[j]-pairs[left-1].alphabets[j]);
                          hash.put(pairs[right].alphabets[j]-pairs[left-1].alphabets[j],temp+1);  
                        }
                        else{
                           hash.put(pairs[right].alphabets[j]-pairs[left-1].alphabets[j],1); 
                        }
                    }
                }
            }
        }
    }
}
