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
        List<Interval> allUsers = new LinkedList();
        List<Interval> freeTime = new LinkedList();
        for(List<Interval> sched : schedule) {
            for(Interval interval : sched) allUsers.add(interval);
        }
        Collections.sort(allUsers, (a, b) -> a.start - b.start);
        
        Interval curr = null;
        for(Interval inv : allUsers) {
            if(curr == null) {
                curr = inv;
                continue;
            }
            if(inv.start > curr.end) {
                freeTime.add(new Interval(curr.end, inv.start));
                curr = inv;
            } else {
                curr.end = Math.max(curr.end, inv.end);
            }
        }
        return freeTime;
    }
}