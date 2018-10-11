package implementation;

import java.util.ArrayList;
import java.util.*;

public class LongestSubString {
  static public class Str {
    Set<Character> chars;
    int count;

    public Str(Character c) {
      chars = new HashSet<Character>();
      chars.add(c);
      count = 1;
    }
  }

  static public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if(s.length() == 0 && k == 0 && s.equals("")) return 0;
    char[] arr = s.toCharArray();
    List<Str> state = new ArrayList<Str>();
    int max = 1;

    for (int i = 0 ; i < arr.length; i++) {
      Str current = new Str(arr[i]);
      List<Str> removed = new ArrayList<Str>();
      for(Str str: state) {
        if(str.chars.size() == k && (!str.chars.contains(arr[i]))) {
          removed.add(str);
        } else {
          str.chars.add(arr[i]);
          ++str.count;
        }

        max = max > str.count ? max : str.count;
      }

      state.removeAll(removed);
      state.add(current);
    }

    return max;
  }

  public static void main(String[] args) {
    lengthOfLongestSubstringKDistinct("eceba", 2);
  }

}
