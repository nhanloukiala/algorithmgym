package search;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.math.BigInteger;
import java.security.Key;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by ntrinh on 09/10/17.
 */
public class ShortPalindrome {
    private static int solve(String s) {
        int hash = (int) Math.pow(10.0, 9.0) + 7;
        int result = 0;

        char[] arr = s.toCharArray();

        HashMap<Character, TreeSet<Integer>> dict = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (dict.containsKey(arr[i])) {
                dict.get(arr[i]).add(i);
            } else {
                TreeSet<Integer> tree = new TreeSet<>();
                tree.add(i);
                dict.put(arr[i], tree);
            }
        }

        for (Character key : dict.keySet()) {
            TreeSet<Integer> tree = dict.get(key);
            Integer[] tarr = new Integer[tree.size()];
            tarr = tree.toArray(tarr);

            for (int i = 0; i < tarr.length - 1; i++) {
                for (int j = 1 + i; j < tarr.length; j++) {
                    for (Character otherKey : dict.keySet()) {

                            TreeSet<Integer> value = dict.get(otherKey);
                            int set_size = value.subSet(tarr[i], false, tarr[j], false).size();
                            if (set_size > 1) {
                                int possible = ((set_size * set_size - set_size) / 2) % hash;
                                result = (possible + result) % hash;
                            }

                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        System.out.println(solve(s));
    }
}
