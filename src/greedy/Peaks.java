package greedy;

import java.util.ArrayList;

/**
 * Created by nhan on 7/9/16.
 */
public class Peaks {
    public int solution(int[] arr){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 1 ; i < arr.length - 1; i++) {
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
             list.add(i);
            }
        }

        //max number of peaks is (N / 2) - 1 if N % 2, or N / 2
//        for(int i = 2; i < arr.length / 3; i++) {
//            for()
//
//        }

        return 0;
    }
}
