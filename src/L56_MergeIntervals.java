import java.util.LinkedList;
import java.util.List;

public class L56_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((i1,i2)->i1.start-i2.start);
        LinkedList<Interval> result = new LinkedList<>();
        for(Interval i:intervals){
            if(result.isEmpty() || result.getLast().end < i.start){
                result.add(i);
            }
            else {
                result.getLast().end = Integer.max(result.getLast().end, i.end);
            }
        }
        return result;
    }
}

