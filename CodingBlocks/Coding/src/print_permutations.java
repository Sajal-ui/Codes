import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.Scanner;

public class print_permutations {
    static String swap(String str,int i,int j){
        StringBuilder sb=new StringBuilder(str);
        sb.setCharAt(i,str.charAt(j));
        sb.setCharAt(j,str.charAt(i));
        return sb.toString();
    }
    static void Permut_String(ArrayList<String> A,String str,int index,int n){
        if(index==n){
            A.add(str);
            return;
        }
        for (int i = index; i < n; i++) {
            String d=swap(str,index,i);
            //System.out.println(index+" "+i+" "+d);
            //A.add(str);
            Permut_String(A,d,index+1, n);
        }
    }
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        ArrayList<String> A=new ArrayList<>();
        Permut_String(A,str,0,str.length());
        System.out.println(A);
        sc.close();
    }
}
