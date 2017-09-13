/**
 * Created by nhan on 7/31/16.
 */
public class BinaryIntevals {
    public int solution(int K, int M, int[] A) {
        // write your code in Java SE 8
        

        return 0;
    }

    private class Interval implements Comparable<Interval> {
        private int from;
        private int to;
        private int sum;

        public Interval(int from, int to, int sum){
            this.from = from;
            this.to = to;
            this.sum = sum;
        }

        public boolean seperable(){
            return from == to;
        }

        public int compareTo(Interval other){
            return this.sum = other.sum;
        }
    }
}
