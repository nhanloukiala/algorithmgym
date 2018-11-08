package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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

  static ArrayList<int[]> extensions(String s) {
    char[] arr = s.toCharArray();
    Set<String> resultStr = new HashSet<>();
    ArrayList<int[]> result = new ArrayList();

    if(s.length() < 4) return result;

    int start = 0;

    for(int i = 0; i < arr.length; i++) {
        if(arr[i] != arr[start])
          start = i;

        if(i - start >= 3 &&
            !resultStr.contains(s.substring(start, i))) {
          resultStr.add(s.substring(start, i));
          result.add(new int[]{start, i});
        }
    }

    return result;
  }

  static void printResult(List<int[]> result) {
    for(int[] r: result) {
      System.out.println(Arrays.toString(r));
    }
  }

  public static void main(String[] args) {
//    printResult(extensions("aaaaal"));
//    printResult(extensions("haaaaal"));
//    printResult(extensions("haaaaallllllll"));
//    printResult(extensions("haaaaalllllllloooo"));
    printResult(extensions("abababa"));
  }
}
