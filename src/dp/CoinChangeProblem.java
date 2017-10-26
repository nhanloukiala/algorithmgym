package dp;

import java.util.*;

/**
 * Created by ntrinh on 15/10/17.
 */
public class CoinChangeProblem {
    private static class Pair {
        public List<Integer> set;
        public long value;
        public boolean unique;

        public Pair(long value, List<Integer> set) {
            this.value = value;
            this.set = set;
            this.unique = false;
        }

        public void update(long value) {
            this.value += value;
        }

        public void update(long value, int index) {
            this.value += value;
            set.add(index);
        }
    }

    private static long solve(int[] arr, int n) {
        Pair[] cache = new Pair[n + 1];
        cache[0] = new Pair(0, new ArrayList<>());
        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i < cache.length; i++) {

            cache[i] = new Pair(0, new ArrayList<>());
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] == 0) {
                    cache[i].update(1);
                    cache[i].unique = true;
                }
                if ((i - arr[j]) > 0) {
                    if (!visited.contains(i - arr[j])) {
                        cache[i].update(cache[i - arr[j]].value);
                        visited.add(i - arr[j]);
                    }

                    if (cache[i - arr[j]].unique) cache[i].value++;
                }
            }
        }

        return cache[n].value;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solve(arr, n));
    }
}
