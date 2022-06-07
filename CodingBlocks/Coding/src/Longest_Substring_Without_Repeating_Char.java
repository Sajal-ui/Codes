import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Longest_Substring_Without_Repeating_Char {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character,Integer> hash = new HashMap<>();
        int max = Integer.MIN_VALUE;
        //int count = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (hash.containsKey(str.charAt(i))) {
                int indx=hash.get(str.charAt(i));
                if(indx>=start){
                  start=indx+1;
                  hash.put(str.charAt(i),i);
                }
                else{
                  hash.put(str.charAt(i),i); 
                }
            } else {
                hash.put(str.charAt(i),i);
            }
            max=Math.max(max,i-start+1);
        }
        System.out.println(max);
        sc.close();
    }
}
