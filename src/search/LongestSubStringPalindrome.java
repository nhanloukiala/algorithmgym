package search;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestSubStringPalindrome {

  static public String longestPalindrome(String s) {
    HashSet<Character> set = new HashSet<>();
    char[] arr = s.toCharArray();

    for(Character c : arr) {
      set.add(c);
    }

    if(set.size() <= 1) return s;

    Set<String> prev = new TreeSet<>(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o2.length() - o1.length();
      }
    });

    String max = "";

    for(int i = 0 ; i < s.length(); i++) {
      Set<String> c = new TreeSet<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          return o2.length() - o1.length();
        }
      });
      for(String p : prev) {
        String current = "";
        int index = i - p.length() - 1;
        if(index >= 0 && s.charAt(i) == s.charAt(index)) {
          current = s.charAt(i) + p + s.charAt(i);
          max = max.length() > current.length() ? max : current;
          c.add(current);
        }

        if(("" + s.charAt(i)).equals(p))  {
          current = p + s.charAt(i);
          max = max.length() > current.length() ? max : current;
          c.add(current);
        }
      }

      max  = max.length() > ("" + s.charAt(i)).length() ? max : ("" + s.charAt(i));
      c.add("" + s.charAt(i));
      prev = c;
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"));
  }
}
