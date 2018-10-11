package implementation;

import java.util.*;

/**
 * Definition for an interval.
 *
 */
class Solution {
  public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
  public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, new Comparator<Interval>() {
      public int compare(Interval first, Interval second) {
        return first.start - second.start;
      }
    });

    List<Interval> result = new ArrayList<Interval>();

    for(int i = 0; i < intervals.size(); i++){
      Interval current = intervals.get(i);

      while(i < intervals.size() - 1 && current.end >= intervals.get(i+1).start){
        current = new Interval(current.start,
            current.end > intervals.get(i+1).end ? current.end : intervals.get(i+1).end);
        i++;
      }

      result.add(current);
    }

    return result;
  }
}
