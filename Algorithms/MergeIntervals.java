// reference: https://oj.leetcode.com/problems/merge-intervals/

// 整个算法是先排序，然后再做一次线性遍历，时间复杂度是O(nlogn+n)=O(nlogn)，空间复杂度是O(1)，因为不需要额外空间，只有结果集的空间

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null|| intervals.size()==0) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        Comparator<Interval> comp = new Comparator<Interval>(){
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if(interval1.start==interval2.start) return interval1.end-interval2.end;
                return interval1.start-interval2.start;
            }
        };
        Collections.sort(intervals, comp);
        res.add(intervals.get(0));
        int idx = 1;
        while(idx<intervals.size()) {
            if(intervals.get(idx).start <=res.get(res.size()-1).end) {
                res.get(res.size()-1).end = Math.max(intervals.get(idx).end, res.get(res.size()-1).end);
            } else {
                res.add(intervals.get(idx));
            }
            idx++;
        }
        return res;
        
    }
}
