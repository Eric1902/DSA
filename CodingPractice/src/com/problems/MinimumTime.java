package com.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumTime {
    public static void main(String[] args) {

        List<Integer> dataList = new ArrayList<>();
        dataList.add(8);
        dataList.add(4);
        dataList.add(6);
        dataList.add(12);

        System.out.println(minimumTime(dataList.size(), null));

    }

    static int minimumTime(int numOfParts, List<Integer> parts) {

        if(parts == null || parts.size()==0 )
            return 0;

        if (parts.size() == 1)
            return parts.get(0);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(parts);
        int result =0;

        while (minHeap.size() > 1) {
            int smallest = minHeap.poll();
            int secondSmallest = minHeap.poll();
            int sum = smallest+secondSmallest;
            result+=sum;
            minHeap.add(sum);
        }
        return result;
    }
}
