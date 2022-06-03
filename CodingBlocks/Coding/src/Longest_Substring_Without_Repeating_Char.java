import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Longest_Substring_Without_Repeating_Char {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashSet<Character> hash = new HashSet<>();
        int max = Integer.MIN_VALUE;
        //int count = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (hash.contains(str.charAt(i))) {
                while (hash.contains(str.charAt(i))) {
                    hash.remove(str.charAt(start));
                    //hash.add(str.charAt(i));
                    start++;
                }
                hash.add(str.charAt(i));
            } else {
                hash.add(str.charAt(i));
            }
            max=Math.max(max,i-start+1);
        }
        System.out.println(max);
        sc.close();
    }
}
