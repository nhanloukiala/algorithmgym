package graph;

public class Perms {
  static int count = 0;

  static void genPerm(String s) {
    perm("", s);
  }

  static void perm(String pref, String current) {
    if (current.length() == 0) {
      System.out.println(pref);
      count++;
      return;
    }

    for (int i = 0; i < current.length(); i++) {
      perm(pref + current.charAt(i),
          current.substring(0, i) + current.substring(i + 1));
    }
  }

  static void genCombination(String s) {
    for(int i = 0; i < s.length(); i++)
      for (int j = i; j < s.length(); j++) {
        System.out.println(s.substring(i, j + 1));
      }
  }

  public static void main(String[] args) {
//    genPerm("abcd");
    genCombination("abc");
  }

}
