package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javafx.util.Pair;

/*
* SP = SymetricPair
*/

public class ThreeSum {
  static class SP {
    public int l, r;
    public SP(int l, int r) {
      this.l = l;
      this.r = r;
    }

    @Override
    public boolean equals(Object obj) {
      SP sp = (SP)obj;
      return compareTriple(this, (SP)obj) || compareTriple(this, new SP(sp.l, 0 - sp.r - sp.l));
    }

    private boolean compareTriple(SP left, SP right) {
      int l = right.l;
      int r = right.r;
      return (left.r == r && left.l == l) || (left.l == r && left.r == l);
    }

    @Override
    public int hashCode() {
      return l*r;
    }
  }

  static private Hashtable<Integer, Set<SP>> pairs = new Hashtable<>();
  static private Set<Integer> numbers = new HashSet<>();
  static private Set<List<Integer>> results = new HashSet<>();

  static public List<List<Integer>> threeSum(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        if(pairs.containsKey(0 - nums[i])) {
          List<List<Integer>> yeah  = pairs
              .get(0 - nums[i])
              .stream()
              .map(sp -> new ArrayList<Integer>(Arrays.asList(sp.l, sp.r, 0 - sp.l - sp.r)))
              .map(list -> {Collections.sort(list); return list;})
              .collect(Collectors.toList());
          results.addAll(yeah);
          pairs.remove(0 - nums[i]);
        }

        for(int j : numbers) {
          int s = nums[i] + j;

          if(!pairs.containsKey(s)){
            Set<SP> p = new HashSet<>();
            p.add(new SP(nums[i], j));
            pairs.put(s, p);
          } else {
            pairs.get(s).add(new SP(nums[i], j));
          }
        }

        numbers.add(nums[i]);
      }

      Set<List<Integer>> finalResults = new HashSet<>();

      for(List<Integer> pair : results) {
        finalResults.add(new ArrayList<Integer>(pair));
      }

      pairs.clear();
      numbers.clear();
      results.clear();

      return new ArrayList<>(finalResults);
  }

  public static void main(String[] args) {
      List<List<Integer>> vals = threeSum(new int[]{3,-2,1,0});
      System.out.println(vals.toString());
  }
}
