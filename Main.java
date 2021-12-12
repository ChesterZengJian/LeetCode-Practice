import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int max = Main.lengthOfLongestSubstring("vdva");
        System.out.println(max);
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] dic = new int[128];
        Arrays.fill(dic, -1);
        int res = 0, i = -1;
        for (int j = 0; j < s.length(); j++) {
            System.out.println("j=" + j);
            i = Math.max(dic[s.charAt(j)], i);
            System.out.println("i=" + i);
            dic[s.charAt(j)] = j;
            res = Math.max(res, j - i);
            System.out.println("j-i=" + (j - i) + ";res=" + res);
        }
        return res;
    }
}
