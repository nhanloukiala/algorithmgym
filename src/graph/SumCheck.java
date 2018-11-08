package graph;

public class SumCheck {
    static int nonDivisibleSubset(int n, int[] arr) {
      int[] sum = new int[arr.length];

      for(int i = 1; i < arr.length; i++) {
        sum[i] = sum[i-1] + arr[i];
      }

      int max = 0;

      for(int i = 0; i < arr.length; i++) {
        for(int j = i; j < arr.length; j++) {
          int s = sum[j] - sum[i] + arr[i];
          if(s % n != 0) max = max > i - j ? max  : i - j;
        }
      }

      return max;
    }

  public static void main(String[] args) {

  }
}
