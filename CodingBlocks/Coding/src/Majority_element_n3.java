import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Majority_element_n3 {
   static boolean find(int[] A,int s,int n){
       int count=0;
       for (int i = 0; i < n; i++) {
           if(A[i]==s){
               count++;
           }
       }
       int h=(int)Math.floor(n/3.0);
       if(count>h){
           return true;
       }
       return false;
   } 
   public static void main(String[] args) throws IOException{
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] A=new int[n];
       for (int i = 0; i < n; i++) {
           A[i]=sc.nextInt();
       }
       int cand1=0,cand2=0;
       int count1=0,count2=0;
       for (int i = 0; i < n; i++) {
          if(cand1==A[i]){
              //cand1=A[i];
              count1++;
          } 
          else if(cand2==A[i]){
              //cand2=A[i];
              count2++;
          }
          else if(count1==0){
              cand1=A[i];
              count1++;
          }
          else if(count2==0){
              cand2=A[i];
              count2++;
          }
          else{
              count1--;
              count2--;
          }
       }
       //System.out.println(cand1+" "+cand2);
       ArrayList<Integer> al=new ArrayList<>();
       if(find(A,cand1,n)){
           al.add(cand1);
       }
       if(find(A,cand2,n)){
           al.add(cand2);
       }
       System.out.println(al);
       sc.close();
   } 
}
