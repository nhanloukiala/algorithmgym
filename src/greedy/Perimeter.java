package greedy;

/**
 * Created by nhan on 7/6/16.
 */
public class Perimeter {
    public int solution(int n) {
        // write your code in Java SE 8
        int sq = (int)Math.floor(Math.sqrt((double)n));

        while (n % sq != 0) {
            sq--;
        }

        return 2*(sq + (n / sq));
    }
}
