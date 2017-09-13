/**
 * Created by nhan on 7/13/16.
 */
public class PrimeDivisor {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int count = 0;

        for(int i = 0; i < A.length ; i++) {
            int hi = Math.max(A[i], B[i]);
            int lo = Math.min(A[i], B[i]);
            int common = gcd(hi, lo);

            if(common % (hi / common) == 0) count++;
        }
        return count;
    }

    public int gcd(int a, int b) {
        if(b > a) {
            int t = b;
            b = a;
            a = t;
        }

        while (b > 0) {
            int t = b;
            b = a % b;
            a  = t;
        }

        return a;
    }

    public static void main(String[] args) {
        PrimeDivisor solver = new PrimeDivisor();

        int[] a = new int[]{15,10,9};
        int[] b = new int[]{75,30,5};

        solver.solution(a, b);
    }
}
