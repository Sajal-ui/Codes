import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class n_string {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            freq[index]++;
        }
        int ans = 0;
        HashMap<Character,Integer> hash=new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if(freq[i]!=0){
                if(freq[i]%n!=0){
                    ans=1;
                    break;
                }
                else{
                    hash.put((char)('a'+i),freq[i]/n);
                }
            }
        }
        if(ans==1){
            System.out.println(-1);
        }
        else{
            String st="";
            for (Character ch : hash.keySet()) {
                int d=hash.get(ch);
                while(d!=0){
                    st+=String.valueOf(ch);
                    d--;
                }
            }
            System.out.println(st.repeat(n));
        }
        sc.close();
    }
}
