package graph;

public class RemovedOnePalindrome {

  static int palindromeIndex(String s) {
    if (s.equals("") || s.length() == 1) {
      return -1;
    }

    return p(s, -1, 0, s.length() - 1);
  }

  static int p(String s, int flipped, int x, int y) {
    if (s.equals("") || s.length() == 1) {
      return flipped;
    }

    int first = -1, second = -1, third = -1;
    if (s.charAt(0) == s.charAt(s.length() - 1)) {
      first = p(s.substring(1, s.length() - 1), flipped, x + 1, y -1);
    } else if (flipped != -1) {
      return -1;
    } else {
      if (s.charAt(0) == s.charAt(s.length() - 2)) {
        second = p(s.substring(0, s.length() - 1), y,x, y-1);
      }

      if (s.charAt(1) == s.charAt(s.length() - 1)) {
        third = p(s.substring(1), x, x+1, y);
      }
    }

    if(third > -1) return third;
    if(second > -1) return second;
    return first;
  }

//  static int palindromeIndex(String s) {
//    if (s.length() == 1 || s.equals("")) {
//      return -1;
//    }
//    int lo, hi;
//    lo = 0;
//    hi = s.length() - 1;
//    int removed = -1;
//
//    while (hi > lo) {
//      if (s.charAt(hi) != s.charAt(lo)) {
//        if (removed != -1) {
//          return -1;
//        }
//
//        if (s.charAt(hi) == s.charAt(lo + 1)) {
//          removed = lo;
//          lo++;
//        } else if (s.charAt(hi - 1) == s.charAt(lo)) {
//          removed = hi;
//          hi--;
//        }
//      }
//
//      hi--;
//      lo++;
//    }
//
//    return removed;
//  }

  public static void main(String[] args) {
    System.out.println(palindromeIndex("ba"));
    System.out.println(palindromeIndex("baaab"));
    System.out.println(palindromeIndex("aaaab"));
    System.out.println(palindromeIndex("baaa"));
    System.out.println(palindromeIndex("aaca"));
    System.out.println(palindromeIndex("hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh"));
  }
}
