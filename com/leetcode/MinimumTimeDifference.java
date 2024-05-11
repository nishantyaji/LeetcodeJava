package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumTimeDifference {

    public class ClockTime implements Comparable<ClockTime> {
        private int hour;
        private int minute;
        private final int HOURS_IN_A_DAY = 24;
        private final int HOURS_IN_HALF_DAY = HOURS_IN_A_DAY / 2;
        private final int MINUTES_IN_AN_HOUR = 60;
        private final int MINUTES_IN_HALF_DAY = HOURS_IN_HALF_DAY * MINUTES_IN_AN_HOUR;

        ClockTime(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        ClockTime(String input) {
            String[] tokens = input.split(":");
            hour = Integer.parseInt(tokens[0]);
            minute = Integer.parseInt(tokens[1]);
        }

        int getMinutes() {
            return hour * MINUTES_IN_AN_HOUR + minute;
        }

        ClockTime incrementByADayAndReturnCopy() {
            return new ClockTime(this.hour + HOURS_IN_A_DAY, this.minute);
        }

        int timeDiffInMinutes(ClockTime another) {
            int thisTime = this.getMinutes();
            int anotherTime = another.getMinutes();
            int lowerTime = anotherTime;
            int higherTime = thisTime;
            ClockTime lowerClock = another;
            if (thisTime < anotherTime) {
                lowerTime = thisTime;
                lowerClock = this;
                higherTime = anotherTime;
            }
            if (higherTime - lowerTime > MINUTES_IN_HALF_DAY) {
                lowerClock = lowerClock.incrementByADayAndReturnCopy();
                return lowerClock.getMinutes() - higherTime;
            } else {
                return higherTime - lowerTime;
            }
        }

        @Override
        public int compareTo(ClockTime o) {
            return this.getMinutes() - o.getMinutes();
        }
    }

    public static void main(String[] args) {
        MinimumTimeDifference m = new MinimumTimeDifference();
        System.out.println(m.findMinDifference(getListFromArray(new String[]{"23:59", "00:00"})));
        System.out.println(m.findMinDifference(getListFromArray(new String[]{"23:59", "00:00", "00:00"})));
    }

    private static List<String> getListFromArray(String[] arr) {
        List<String> res = new ArrayList<>();
        Collections.addAll(res, arr);
        return res;
    }

    public int findMinDifference(List<String> timePoints) {
        List<ClockTime> clockTimes = timePoints.stream().map(ClockTime::new).sorted().collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < clockTimes.size() - 1; i++) {
            int diff = clockTimes.get(i + 1).getMinutes() - clockTimes.get(i).getMinutes();
            if (diff < min) {
                min = diff;
            }
        }
        int diffAcross = clockTimes.get(clockTimes.size() - 1).timeDiffInMinutes(clockTimes.get(0));
        if (diffAcross < min) {
            min = diffAcross;
        }
        return min;
    }


}
