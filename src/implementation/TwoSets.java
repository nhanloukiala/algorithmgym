package implementation;

public class TwoSets {
  static int getTotalX(int[] a, int[] b){
    int min, max;
    min = Integer.MAX_VALUE;
    max = Integer.MIN_VALUE;

    for(Integer i : a) {
      min = min < i ? min : i;
    }

    for(Integer i : b) {
      max = max > i ? max : i;
    }

    int result = 0;

    for(int i = min; i <= max; i++) {
      if(check(i, a, b)) result++;
    }

    return result;
  }

  static boolean check(int n, int[] a, int[] b) {
    for(Integer i : a) if(n % i != 0) return false;
    for(Integer i : b) if(i % n != 0) return false;

    return true;
  }

}
