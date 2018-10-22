package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSquares {

  void backtrack(List<String> current, HashMap<String, Set<String>> dict,
      Set<List<String>> result) {
    if (current.size() == current.get(0).length()) {
      ArrayList<String> r = new ArrayList();
      for (String s : current) {
        r.add(new String(s));
      }
      result.add(r);
      return;
    }

    String pref = "";
    for (int row = 0; row < current.size(); row++) {
      pref += current.get(row).charAt(current.size());
    }

    Set<String> candidates = dict.get(pref);

    if (candidates != null) {
      for (String c : candidates) {
        current.add(c);
        backtrack(current, dict, result);
        current.remove(current.size() - 1);
      }
    }
  }

  public List<List<String>> wordSquares(String[] words) {
    HashMap<String, Set<String>> prefix = new HashMap();

    for (String w : words) {
      for (int i = 0; i < w.length(); i++) {
        String pref = w.substring(0, i);

        if (prefix.containsKey(pref)) {
          prefix.get(pref).add(w);
        } else {
          prefix.put(pref, new HashSet());
          prefix.get(pref).add(w);
        }
      }
    }

    Set<List<String>> result = new HashSet();
    for (String w : words) {
      List<String> seed = new ArrayList();
      seed.add(w);
      backtrack(seed, prefix, result);
    }

    List<List<String>> r = new ArrayList();
    for (List<String> l : result) {
      r.add(l);
    }

    return r;
  }
}
