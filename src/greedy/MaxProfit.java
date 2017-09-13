package greedy;

/**
 * Created by nhan on 7/6/16.
 */
public class MaxProfit {
    public int solution(int[] arr) {
        // write your code in Java SE 8
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length ; i++){
            if(arr[i] > max) {
                max = arr[i];
            }

            if(arr[i] < min) {
                min = arr[i];
            }
        }

        return (max - min) > 0 ? (max - min) : 0;
    }
}
