/**
 * Created by nhan on 7/15/16.
 */
public class BinarySearch {
    public int solution(int[] arr, int n){
        int hi = arr.length;
        int lo = 0;
        int mid = (hi + lo) / 2;

        while(hi > lo) {
            if(arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

            mid = (hi + lo) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7};

        BinarySearch solver = new BinarySearch();

        System.out.println(solver.solution(arr, 4));
    }
}
