//import java.util.PriorityQueue;
import java.util.Scanner;

public class Codeforces_1616B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String ans = "";
            if(str.length()==1){
                ans=str.substring(0, 1)+str.substring(0, 1);
                System.out.println(ans);
            }
            else if (str.charAt(0) == str.charAt(1)) {
                ans=str.substring(0, 1)+str.substring(0, 1);
                System.out.println(ans);
            } else {
                StringBuilder sb=new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j != 0 && (str.charAt(j)) > (str.charAt(j - 1))) {
                        break;
                    }
                    sb.append(str.charAt(j));
                }
                String h = sb.toString() + sb.reverse().toString();
                System.out.println(h);
            }
        }
        sc.close();
    }
}
