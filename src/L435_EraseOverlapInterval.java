import java.util.Arrays;

public class L435_EraseOverlapInterval {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (i1,i2)->i1.end-i2.end);
        int end = intervals[0].end;
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
}
