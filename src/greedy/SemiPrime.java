package greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by nhan on 7/11/16.
 */
public class SemiPrime {
    public int[] solution(int N, int[] P, int[] Q) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> checkList = new ArrayList<Integer>();

        for(int i = 0 ; i <= N ; i++) {
            if(isPrime(i)) list.add(i);
        }

        if(list.isEmpty()) return new int[P.length];

        for(int i = 0; i < list.size(); i++) {
            for (int j = 0 ; j < list.size() ; j++ ) {
                if(j >= i) {
                    if(list.get(i) * list.get(j) > N) break;
                    checkList.add(list.get(i) * list.get(j));
                }
            }
        }

        if(checkList.isEmpty()) return new int[P.length];

        Collections.sort(checkList);

        int count = 0;
        int second_count = 0;
        int[] total_count = new int[N  + 2];
        int[] result = new int[P.length];
        for(int i  = 1; i <= N; i++) {
            if(i == checkList.get(second_count)) {
                count++;
                second_count++;
            }
            total_count[i] = count;
        }

        total_count[N + 1] = total_count[N] + 1;

        for(int i = 0 ; i < P.length ; i++) {
            result[i] = total_count[Q[i]] - total_count[P[i] - 1];
        }

        return result;
    }

    public boolean isPrime(int n) {
        if(n < 2) return false;

        if(n == 2) return true;

        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        SemiPrime solver = new SemiPrime();
        int N = 26;

        int[] P = new int[] {1,4,16};

        int[] Q = new int[] {26, 10, 20};

        solver.solution(N, P, Q);
    }
}
