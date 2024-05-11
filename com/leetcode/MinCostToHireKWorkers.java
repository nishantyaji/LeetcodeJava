package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//solution to the leet code problem 857
public class MinCostToHireKWorkers {
    public static void main(String[] args) {
        MinCostToHireKWorkers m = new MinCostToHireKWorkers();

        System.out.println(m.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
        System.out.println(m.mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            double ratio = ((double) (wage[i])) / ((double) (quality[i]));
            workers.add(new Worker(ratio, quality[i]));
        }

        Comparator<Worker> ascendingRatio = new WorkerComparator();
        workers.sort(ascendingRatio.reversed());

        double minSum = 0;
        List<Double> minPos = new ArrayList<>();
        double tempRatio = workers.get(workers.size() - k).ratio;
        for (int j = workers.size() - k; j < workers.size(); j++) {
            minPos.add(tempRatio * workers.get(j).quality);
            minSum += tempRatio * workers.get(j).quality;
        }
        Collections.sort(minPos);

        for (int i = workers.size() - k - 1; i >= 0; i--) {
            double newVal = workers.get(i).quality * workers.get(i).ratio;
            double sum = insertNewVal(minPos, newVal, workers.get(i).ratio, workers.get(i + 1).ratio);
            if (sum < minSum) {
                minSum = sum;
            }
        }

        return minSum;
    }

    private double insertNewVal(List<Double> list, Double newVal, Double newRatio, Double oldRatio) {
        double sum = newVal;
        for (int i = 0; i < list.size(); i++) {
            double elem = list.get(i) * newRatio / oldRatio;
            sum += elem;
            list.set(i, elem);
        }

        if (newVal < list.get(list.size() - 1)) {
            int index = binarySearch(list, newVal);
            list.add(index, newVal);
            double removed = list.remove(list.size() - 1);
            sum -= removed;
            return sum;
        }
        return sum - newVal;

    }

    private int binarySearch(List<Double> list, Double value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Double midVal = list.get(mid);
            int cmp = midVal.compareTo(value);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }

    private static class Worker {
        private double ratio;
        private int quality;

        Worker(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }

    public static class WorkerComparator implements Comparator<Worker> {

        @Override
        public int compare(Worker o1, Worker o2) {
            if (o1.ratio == o2.ratio) {
                return o1.quality - o2.quality;
            }
            double diff = o1.ratio - o2.ratio;
            return diff > 0 ? 1 : -1;
        }
    }
}
