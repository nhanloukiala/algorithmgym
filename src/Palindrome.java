import java.util.*;

/**
 * Created by nhan on 7/16/16.
 */
public class Palindrome {
    public boolean solver(char[] arr) {
        if(arr.length == 0) return false;
        int lo = 0;
        int hi = arr.length - 1;

        while(hi > lo) {
            if(arr[hi] != arr[lo]) return  false;
            else {
                hi--;
                lo++;
            }
        }

        return true;
    }

    public Set<String> subString(String str){
        HashSet<String> set = new HashSet<String>();

        for(int i = 0 ; i < str.length(); i++) {
            for(int j = i + 1; j <= str.length(); j++) {
                set.add(str.substring(i,j));
            }
        }

        return set;
    }

    public static void main(String[] args) {
        Palindrome solver = new Palindrome();
        System.out.println(solver.solver("aaa".toCharArray()));

        Set<String> set = solver.subString("12345");
        for(String s : set) {
            System.out.println(s);
        }
    }
}
