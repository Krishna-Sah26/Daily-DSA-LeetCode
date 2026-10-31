class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      // traversing of the aray
      List<int[]> result = new ArrayList<>();
      int i = 0;
      int n = intervals.length;
      // where add all the intervals that come completly befor it

      while(i<n && intervals[i][1]<newInterval[0]){
        result.add(intervals[i]);
        i++;
      }   
      // merge all the overlaping intervals with newInterval
      while(i<n && intervals[i][0]<=newInterval[1]){
         newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
          newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
      }
      result.add(newInterval);// merged intp the new intervals
      // add all the remaining intervals that come after
      while(i<n){
        result.add(intervals[i]);
        i++;
      }
      // 
      return result.toArray(new int[result.size()][]);
    }
}