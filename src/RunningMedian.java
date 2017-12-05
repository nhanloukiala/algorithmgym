import java.util.Scanner;

/**
 * Created by nhan on 11/11/17.
 */
public class RunningMedian {
    // {1, 2} {3, 4}
    // {1,2} {3,4,5}
    // {1,2} {3,4,5,6}


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = "".split(" ");
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
    }
}
