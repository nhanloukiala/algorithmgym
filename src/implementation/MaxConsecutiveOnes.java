package implementation;

class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int current = 0;
    int prev = 0;

    int gap = 0;
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == 1) {
        current++;
        prev++;

        max = max > current ? max : current;
        max = max > prev ? max : prev;
        continue;
      }

      if(nums[i] == 0) {
        if(gap == 1 && nums[i-1] == 0) {
          prev = 1;
          current = 0;
          gap = 0;
        } else if ( gap == 1 && nums[i-1] == 1) {
          prev = current + 1;
          current = 0;
        }
        else {
          gap++;
          prev = ++current;

          max = max > prev ? max : prev;
          current = 0;
        }
      }
    }

    return max;
  }
}
