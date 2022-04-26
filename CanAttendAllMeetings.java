import java.util.Collections;
import java.util.Comparator;
import java.util.List;

 class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

public class CanAttendAllMeetings {

    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here

        Collections.sort(intervals, Comparator.comparingInt((interval) -> interval.start));
        for(int idx = 1; idx < intervals.size(); idx++){
            if(intervals.get(idx).start < intervals.get(idx-1).end){
                return false;
            }
        }

        return true;
    }
}
