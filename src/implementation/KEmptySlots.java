package implementation;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class KEmptySlots {
  private boolean checkExist(int flower, TreeSet<Integer> bloomed, int k) {
    return ((bloomed.contains(flower + (k + 1)) && (bloomed.headSet(flower + k + 1, false).isEmpty() || (bloomed.headSet(flower + k +  1, false).last() < flower )))
        || ((bloomed.contains(flower - (k + 1)) && (bloomed.tailSet(flower - k - 1, false).isEmpty() || bloomed.tailSet(flower - k -  1, false).first() > flower ))));
  }

  public int kEmptySlots(int[] flowers, int k) {
    TreeSet<Integer> bloomed = new TreeSet<Integer>();

    for(int i = 0; i < flowers.length; i++) {
      if(checkExist(flowers[i], bloomed, k))
        return i + 1;
      else
        bloomed.add(flowers[i]);
    }

    return -1;
  }

  public static void main(String[] args) {

  }

}
