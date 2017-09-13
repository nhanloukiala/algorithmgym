package greedy;

import java.util.Iterator;

/**
 * Created by nhan on 7/5/16.
 */
public class ProcastinatedIterator {
    public int solution(int[] arr) {
        // write your code in Java SE 8
        int maxSum = 0;
        int currentSum = 0;
        int start = 0;
        int end = 0;

        for(int i = 0; i < arr.length ; i++) {
            if(currentSum < 0) {
                start = i;
                end = i;
                currentSum = 0;
            }

            currentSum += arr[i];
            end = i;

            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}


