package recursion;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;

/**
 * Created by nhan on 11/7/17.
 */
public class ThePowerSum {
    private static Set<Set<Integer>> globalState = new HashSet<>();

    private static void solveRec(Set<Integer> list, Set<Integer> current, int n, int m) {
        int sum = 0;
        for(Integer num : current) {
            sum+= num;
        }

        if(sum == n) {
            globalState.add(current);
        } else if (sum > n) {
            return;
        }

        for(Integer i : list) {
            Set<Integer> set = new HashSet<Integer>();
            set.addAll(current);

            set.add(i);

            Set<Integer> nList = new HashSet<>();
            nList.addAll(list);
            nList.removeIf(x -> x <= i);

            solveRec(nList, set, n, m);
        }
    }

    private static void solve(int n, int m) {
        Set<Integer> numbers = new HashSet<>();

        int num = 1;

        while(Math.pow(num, m) <= n) {
            numbers.add((int)Math.pow(num, m));
            num++;
        }

        solveRec(numbers, new HashSet<>(), n, m);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        solve(n, m);
        System.out.println(globalState.size());
    }
}
