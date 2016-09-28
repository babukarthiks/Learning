package com.learning.algos.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.learning.ds.pojos.Interval;

public class IntervalProblems {

    public static List<Interval> mergeIntervals(List<Interval> intervals) {

        if (intervals.size() < 2) {
            return intervals;
        }
        // sort intervals in order according to start time
        Collections.sort(intervals, new Comparator<Interval>() {

            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int size = intervals.size();
        for (int i = 1; i < size; i++) {

            if (intervals.get(i - 1).end >= intervals.get(i).start) {

                intervals.get(i - 1).end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);

                intervals.remove(i);
                i--;
                size--;
            }
        }
        return intervals;
    }

    public static List<Interval> insertInterval(List<Interval> intervals, Interval intervalToMerge) {

        if (intervals.size() == 0) {
            intervals.add(intervalToMerge);
            return intervals;
        }
        intervals = mergeIntervals(intervals);
        int size = intervals.size();
        for (int i = 0; i < size; i++) {

            if (intervalToMerge.start <= intervals.get(i).end) {
                intervals.get(i).end = Math.max(intervalToMerge.end, intervals.get(i).end);
            }
            if (intervalToMerge.start <= intervals.get(i).start) {
                intervals.get(i).start = Math.min(intervalToMerge.start, intervals.get(i).start);
            }
        }

        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        // merge interval
        // intervals.add(new Interval(1, 3));
        // intervals.add(new Interval(2, 6));
        // intervals.add(new Interval(8, 10));
        // intervals.add(new Interval(15, 18));
        //

        // insertInterval

        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));

        Interval intervalToMerge = new Interval(4, 9);

        // intervals = mergeIntervals(intervals);

        intervals = insertInterval(intervals, intervalToMerge);

        for (Interval i : intervals) {
            System.out.println(i.start + " " + i.end);
        }
    }

}
