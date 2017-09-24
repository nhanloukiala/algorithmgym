package stringmanipulation;

import java.util.*;

/**
 * Created by nhan on 9/20/17.
 */
public class TwoCharacters {
    private static int solve(String str) {
        char[] charArr = str.toCharArray();

        Set<Character> charSet = new HashSet<Character>();

        for(int i = 0; i < charArr.length; i++) {
            charSet.add(charArr[i]);
        }

        List<Character> listChar = new ArrayList<Character>();
        for(Character ch: charSet){
            listChar.add(ch);
        }

        int max = 0;

        for(int i = 0; i < listChar.size() - 1; i++) {
            for(int j = 1; j > i && j < listChar.size(); j++) {
                Character low = listChar.get(i);
                Character hi = listChar.get(j);

                max = Math.max(max, check(hi, low, charArr));
                max = Math.max(max, check(low, hi, charArr));
            }
        }
        return max;
    }

    private static int check(Character hi, Character lo, char[] arr){
        boolean flag = true;
        boolean flip = false; //true = last hi, false = last low
        int length = 0;

        for(int i = 0 ; i < arr.length; i++) {
            if(hi == arr[i] && flip == false) {
                length++;
                flip = true;
            }

            if (lo == arr[i] && flip == true) {
                length++;
                flip = false;
            }

            if((hi == arr[i] && flip == false) || (lo == arr[i] && flip == true)) {
                length = 0;
                break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        String str = "beabeefeab";
        System.out.println(solve(str));
    }
}
