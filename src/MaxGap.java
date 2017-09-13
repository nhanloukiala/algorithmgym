/**
 * Created by nhan on 7/16/16.
 */
public class MaxGap {
    public int solution(int[] arr) {
        int lo[] = new int[arr.length];
        int hi[] = new int[arr.length];
        int maxlo = Integer.MIN_VALUE;
        int maxhi = Integer.MIN_VALUE;

        for (int i = 0; i < lo.length; i++) {
            if (arr[i] > maxlo) maxlo = arr[i];
            lo[i] = maxlo;
        }

        for (int i = hi.length - 1; i >= 0; i--) {
            if (arr[i] > maxhi) maxhi = arr[i];
            hi[i] = maxhi;
        }

        int max = Integer.MIN_VALUE;
        int k = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            int gap = (int) Math.abs(lo[i] - hi[i + 1]);
            if (gap > max) {
                max = gap;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxGap solver = new MaxGap();
        System.out.println(solver.solution(new int[]{4, 3, 2, 5, 1, 1}));
        System.out.println(solver.solution(new int[]{1, 3, -3}));
    }
}
