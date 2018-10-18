package implementation;


public class ShortestPalindrome {

  static int palindromeOrNext(int lo, int hi, char[] arr) {
    int hiR = hi;
    while (hi > lo) {
      if (arr[hi] != arr[lo]) {
        return hi - 1;
      }
      hi--;
      lo++;
    }

    return hiR;
  }

  static int getLongestPalindrome(char[] arr) {
    int max = 1;

    for (int i = arr.length - 1; i > 0; ) {
      int lo = 0;
      int hi = i;

      int next = palindromeOrNext(lo, hi, arr);

      if (hi == next) {
        return hi;
      }

      i = next;
    }

    return -1;
  }

  static public String shortestPalindrome(String s) {
    char[] arr = s.toCharArray();

    int index = getLongestPalindrome(arr);

    String result = "";

    for (int i = arr.length - 1; i > index; i--) {
      result = result + arr[i];
    }

    return result + s;
  }

  public static void main(String[] args) {
    String s = "aacecaaa";

    System.out.println(shortestPalindrome(s));
  }
}

