package dp;

import java.util.Arrays;

/**
 * Created by nhan on 7/26/17.
 */
public class LuckyNumberPasha {
    static public long luckyNumber(long N) {
        if (N < 47) return 0;
        if (N <= 99) return 1;

        long first2 = charArray2Long(Arrays.copyOf(long2CharArray(N), 2));

        if (first2 >)

            return 0;
    }

    static private char[] long2CharArray(long N) {
        return String.valueOf(N).toCharArray();
    }

    static private long charArray2Long(char[] arr) {
        return Long.valueOf(arr.toString());
    }

    static private boolean containsLuckyNumber(long N) {
        return (N + "").contains("47");
    }

    public static void main(String[] args) {
        String result = "";
        for (int i = 999; i < 1200; i++) {
            if (containsLuckyNumber(i)) {
                System.out.println(i);
            }

        }
    }
}
