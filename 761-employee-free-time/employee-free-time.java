/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allWork = new ArrayList();
        for(List<Interval> sched : schedule) {
            for(Interval intv : sched) {
                allWork.add(intv);
            }
        }
        allWork.sort((a, b) -> a.start - b.start);
        Interval curr = null;
        List<Interval> ans = new LinkedList();
        for(Interval work : allWork) {
            if(curr == null) {
                curr = work;
                continue;
            }
            if(curr.end < work.start) {
                ans.add(new Interval(curr.end, work.start));
                curr.end = work.end;
            } else {
                curr.end = Math.max(curr.end, work.end);
            }
        }
        return ans;
    }
}