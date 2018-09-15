package implementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class NextClosestTime {
  private static int toMinute(String input) {
    return 0;
  }

  private static SortedSet<Integer> distinctNumberList(String time){
    char[] chars = time.toCharArray();

    SortedSet<Integer> numbers = new TreeSet<>();
    numbers.add(Integer.parseInt(chars[0] + ""));
    numbers.add(Integer.parseInt(chars[1] + ""));
    numbers.add(Integer.parseInt(chars[3] + ""));
    numbers.add(Integer.parseInt(chars[4] + ""));

    return numbers;
  }

  public String nextClosestTime(String time) {


    return "";
  }
}
