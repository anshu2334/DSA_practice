package collection;

public class Candy {
    public static int candy(int[] ranks){
        int n = ranks.length;
        int[] candies = new int[n];

        /**
         * have new array to hold student wise (index wise) candies
         * initially assign one candy to all indexes
         * iterate from left to right and if right indexed value is more than left index value
         * increment candy at that index by one
         * have second pass from right to left and starting second last index from right . compare if current indexed
         * value is greater than value one before that index ( i > i+1)
         * assign candy at that index to maximum of cadies at that index  and cadies (i+1) +1
         *
         * finally iterate cadies list and add all to get totals candies
         *
         * **/

        //set one candy to each
        for(int i=0; i < candies.length;i++) {
            candies[i]=1;
        }

        //left to right - if higher than its neighbour, give one more candy
        for(int i=1; i <ranks.length ; i++) {
            if(ranks[i] > ranks[i-1]) {
                candies[i] =candies[i] + 1;
            }
        }

        //right to left
        for(int i=n-2; i>=0; i--){
            if(ranks[i] > ranks[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1] + 1);
            }
        }

        //Sum
        int total =0;
        for(int c:candies) {
            total +=c;
        }
        /**
         *
         * Complexity
         * - Time: O(n) → two passes.
         * - Space: O(n) → candies array.
         * - Can be optimized to O(1) space with careful tracking, but O(n) is fine for interviews.
         *
         * ⚡ Takeaway
         * - This is a classic greedy two-pass problem.
         * - It demonstrates how to enforce constraints in both directions.
         * - Very common in interviews to test your ability to reason about fairness and local/global constraints.
         *
         *
         * **/
        return total;
    }

    public static void main(String[] args) {
        int[] ratings1 = {1,0,2};
        int[] ratings2 = {1,2,2};

        System.out.println(candy(ratings1)); // 5
        System.out.println(candy(ratings2)); // 4
    }

}
