package collection;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static String largestElement(PriorityQueue<Integer> priorityQueue, int depth, String citation) {
        int result =0;
        for(int i=0; i<depth; i++){
            result = priorityQueue.poll();
        }
        return depth +"th "+citation+" is: "+  result;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeapPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeapPQ = new PriorityQueue<>();
        maxHeapPQ.offer(5);
        maxHeapPQ.offer(20);
        maxHeapPQ.offer(97);
        maxHeapPQ.offer(3);
        maxHeapPQ.offer(27);
        maxHeapPQ.offer(19);
        maxHeapPQ.offer(31);

        minHeapPQ.offer(5);
        minHeapPQ.offer(20);
        minHeapPQ.offer(97);
        minHeapPQ.offer(3);
        minHeapPQ.offer(27);
        minHeapPQ.offer(19);
        minHeapPQ.offer(31);
        System.out.println(largestElement(maxHeapPQ,3, "highest"));
        System.out.println(largestElement(minHeapPQ,3, "lowest"));
    }
}
