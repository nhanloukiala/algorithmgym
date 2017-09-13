/**
 * Created by nhan on 7/16/16.
 */
public class EquilibriumIndex {
    public int solution(int[] arr){
        long lo = 0;
        long hi = 0;
        long[] larr = new  long[arr.length];
        long[] harr = new  long[arr.length];

        for(int i = 0; i < arr.length; i++) {
            lo += arr[i];
            larr[i] = lo;
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            hi += arr[i];
            harr[i] = hi;
        }

        for(int i = 1 ; i < arr.length - 1; i++) {
            if(larr[i - 1] == harr[i + 1]) return i;
        }
        
        return -1;
    }


}
