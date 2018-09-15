package stringmanipulation;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RepeatedStringMatch {
  private static boolean matchCheck(char[] aarr, char[] barr, int current) {
    for(Character b : barr) {
      if(aarr[current] != b) return false;
      current = (++current) % aarr.length;
    }

    return true;
  }
  public static int repeatedStringMatch(String A, String B) {
      char[] aArr = A.toCharArray();
      char[] bArr = B.toCharArray();

      for(int i = 0; i < aArr.length; i++) {
        if(aArr[i] == bArr[0]) {
          int current = i;
          if(matchCheck(aArr, bArr, current))
            return (int)Math.ceil(((double)bArr.length + i) / aArr.length);
        }
      }

      return -1;
  }

  public static void main(String[] args) {
    System.out.println(repeatedStringMatch("a", "aa"));
  }

}
