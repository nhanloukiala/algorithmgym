import java.util.Collections;
/**
 * Created by nhan on 7/14/16.
 */
public class Ladder {
    public int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int max = 0;
        for(int i  = 0; i < A.length ; i ++) {
            if(A[i] > max) max = A[i];
        }

        int k = (int)Math.pow(2, 30);

        int[] org = new int[max + 1];
        org[1] = 1;
        org[2] = 2;

        int[] mod = new int[max + 1];
        mod[1] = 1;
        mod[2] = 2;

        int[] div = new int[max + 1];
        div[1] = 0;
        div[2] = 0;

        for( int i  = 3 ; i < max  + 1; i++) {
            mod[i] = (mod[i - 1] + mod[i - 2]) % k;
            div[i] = (div[i - 1] + div[i - 2])  + ((mod[i - 1] + mod[i - 2]) / k);
        }

        int[] result = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            int p = (int)Math.pow(2, B[i]);
            result[i] = (mod[A[i]] % p) + (k % p) * (div[A[i]] % p);
        }

        return result;
    }

    public static void main(String[] args) {
        Ladder solver = new Ladder();

        int[] i1 = new int[]{4,4,5,5,1};
        int[] i2 = new int[]{3,2,4,3,1};

        int[] x = solver.solution(i1, i2);
    }
}
