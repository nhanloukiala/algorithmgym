/**
 * Created by nhan on 7/7/16.
 */
public class MaxDoubleSlide {
    public int solution(int[] arr) {
        // write your code in Java SE 8
        int[] hi = new int[arr.length];
        int[] low = new int[arr.length];

        for(int i = 1 ; i < arr.length - 2 ; i ++){
            hi[i] = Math.max(hi[i - 1] + arr[i], 0);
        }

        for(int i = arr.length -  2; i >=  1; i--) {
            low[i] = Math.max(low[i + 1] + arr[i] , 0);
        }

        int max = 0;

        for(int i = 1 ; i < hi.length - 1; i ++){
            max = Math.max(max, hi[i - 1] + low[i + 1]);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxDoubleSlide slice = new MaxDoubleSlide();
        int[] data = {3,2,6,-1,2,-30,-90,4,5,-1,2};

        slice.solution(data);
    }
}
