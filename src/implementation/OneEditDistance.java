package implementation;

class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    if(Math.abs(s.length() - t.length()) > 1) return false;

    char[] arrs = s.toCharArray();
    char[] arrt = t.toCharArray();

    int diff = 0;
    int i = 0, j = 0;
    for(; i < s.length() && j < t.length() && diff < 2; ) {
      if(arrs[i] == arrt[j]) {i++; j++; continue;}

      if(j + 1 < t.length() && arrs[i] == arrt[j + 1]) {
        j++; diff++; continue;
      }

      if(i + 1 < s.length() && arrs[i + 1] == arrt[j]) {
        i++; diff++; continue;
      }

      i++; j++; diff++;
    }

    return (diff ==  1 && (i == s.length() && j == t.length())) ||
        (diff == 0 && (i == s.length() - 1 || j == t.length() - 1));
  }
}
