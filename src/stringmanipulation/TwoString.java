package stringmanipulation;

import java.util.HashSet;
import java.util.Set;

public class TwoString {
  public static String twoStrings(String a, String b) {
    if(a == null || b == null || a.length() == 0 || b.length() == 0)
      return "NO";

    Set<Character> state = new HashSet<>();
    char[] arr = a.toCharArray();
    for(Character c : arr) {
      state.add(c);
    }

    char[] arr1 = b.toCharArray();
    for(Character c : arr1) {
      if(state.contains(c)) return "YES";
    }

    return "NO";
  }

  public static void main(String[] args) {
    System.out.println(twoStrings("hello", "world"));
    System.out.println(twoStrings("hello", "aaaa"));
    System.out.println(twoStrings("hello", ""));
  }
}
