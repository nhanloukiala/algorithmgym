/**
 * Created by nhan on 7/16/16.
 */
public class LongestValid {
    public int solution(String S) {
        // write your code in Java SE 8
        char[] arr = S.toCharArray();
        int start = -1;
        int max = Integer.MIN_VALUE;
        boolean containUpper = false;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= 'Z' && arr[i] >= 'A') containUpper = true;

            if((arr[i] >= '0' && arr[i] <= '9')) {
                if(containUpper) {
                    int dist = i - start - 1;
                    if(dist > max) max = dist;
                }

                start = i;
                containUpper = false;
            }
        }

        if(containUpper) {
            int dist = arr.length - start - 1;
            if(dist > max) max = dist;
        }

        if(max > 0) return max;
        else return - 1;
    }

    public static void main(String[] args) {
        LongestValid solver = new LongestValid();
        String s = "a0Ba";
        System.out.println(solver.solution(s));
    }
}
