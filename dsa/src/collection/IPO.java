package collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static int findMaximizeCapital(int k, int currentCapital, int[] capitals, int[] profits) {
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        //PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        //put all element in minCapitalHeap
        for(int i=0; i< capitals.length; i++) {
            minCapitalHeap.offer(new int[]{capitals[i],profits[i]});
            //minCapitalHeap.stream().peek(System.out::println);
        }


        //choose upto k projects
        for(int i=0; i< k; i++) {
            /**
             *
             * Why the while loop is inside the for loop
             * - At each iteration, your capital w increases after picking a project.
             * - That means new projects may become affordable in the next round.
             * - The while loop checks affordability every time before picking a project.
             * - If you move the while loop outside, you only check affordability once at the beginning,
             * missing projects that become affordable later
             * **/
            //move all affordable projects into maxProfit heap
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= currentCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            if(maxProfitHeap.isEmpty()) {
                break;
            }

            //pick the most profitable project
            currentCapital += maxProfitHeap.poll()[1];
        }

        return currentCapital;
    }

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1,2,3};
       int[]  capital = {0,1,1};
        System.out.println(findMaximizeCapital(k,w,capital,profits));

    }
}
