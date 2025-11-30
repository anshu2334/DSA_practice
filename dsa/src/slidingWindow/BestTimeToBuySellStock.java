package slidingWindow;

public class BestTimeToBuySellStock {
    public static int maxProfitStock(int[] stockPrices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
/**
 * this algorithm is pretty straight forward
 * iterate over list of each day stock prices from left to right
 * compare if price of that that is less than currently hold min price, assign this value to min price
 * otherwise if difference is that day price and min price is greater than currently hold max price, update max price
 * by this value
 * after iteration return maxProfit which holds max difference between min price and max price
 *
 * **/

        for(int price : stockPrices) {
            if(price <  minPrice) {
                minPrice = price;
            }else if(price -minPrice > maxProfit) {
                maxProfit = price-minPrice;
            }
        }
        return maxProfit;
    }

    //greedy approch to find maximum profit when multiple transactions allowed
    public static int maxProfit(int[] stockPrices){
        /**
         * Approach (Greedy)
         * - You can think of this as collecting all upward slopes.
         * - Whenever prices[i] > prices[i-1], add the difference to profit.
         * - This works because multiple transactions are allowed, so you don’t need to find a single buy-sell
         * pair — just sum all gains.
         * Thumb rule: whenever iteration is from left to right and we have to
         * compare current value with previous value, start the counter with 1
         * **/
        int maxProfit =0;
        for(int i=1;i<stockPrices.length; i++){
            if(stockPrices[i] > stockPrices[i-1]) {
                maxProfit += stockPrices[i] - stockPrices[i-1];
            }
        }
        return maxProfit;
    }

    //with maximum number of trnsactions allowed k
    public static int maxProfit(int[] stockPrices, int k){
        if(stockPrices == null || stockPrices.length ==0 || k == 0) return 0;
        int n = stockPrices.length;

        //unlimited Scenario
        //same as multiple transactions allowed. greedy algo approch to collect all upward trends
        if(k >= n/2){
            int profit = 0;
            for(int i=1; i < n; i++){
                if(stockPrices[i] > stockPrices[i-1]){
                    profit += stockPrices[i] - stockPrices[i-1];
                }
            }
            return profit;
        }

        // general case scenario: Dynamic Programming
        //create a matrix of dimension of total number of transaction allow + 1 by total number of Elements in Array
        //key rule to remember in Dymanic matrix processing
        // in Dynamic matrix processing approach, we are always starting to iterate matrix starting at top left index
        // this assumption help us to assume that we current processing grid
        // always compares with top(dp[i-1][j], left[i][j-1], top left[i-1][j-1]

        //dp will hold maximum profit at a moment of time
        int[][] dp = new int[k+1][n];
        for(int t=1; t <=k; t++){
            //as there is no previous difference ,start the diff with -
            int maxDiff = - stockPrices[0];
            for(int d=1; d < n ; d++){

                //put max of previous max or current max profile (comparing with left node of current processing node)
                //with stock price for that day + different of another transactions max value executed on same
                // day(top node of current value)
                dp[t][d] = Math.max(dp[t][d-1],stockPrices[d]+maxDiff);
                System.out.printf("transaction: %d | maxdiff:%d | Current day stock price: {%d} | currentDpValue:%d | same transaction previous Day DP:{%d} | differnt transaction same Day: {%d} ",t,maxDiff,stockPrices[d],dp[t][d],dp[t][d-1],dp[t-1][d]);
                System.out.println();

                //calculate new maxDiff with new matrix (top - current price) where top is same day different transaction
                maxDiff =  Math.max(maxDiff, dp[t-1][d] - stockPrices[d]);
            }

        }
        /**
         * DP will hold the max profit from all transactions
         * at each point compare left node value with (stock price value at given day + maximum profile difference)
         * and assign the max value current dp node
         *  max profile difference is created at start of every iteration of transaction for loop and is getting assinged
         *  a default value of negative first day stock price
         *  this maxProfit is getting recalculated for every day iteration based on below rule
         *  if difference between same day immidiate maxProfit from another transaction executed on same day(top node) and stock price
         *  for that day is more than previously set maxProfit for that transaction then set this value to maxProfit otherwise
         *  maxProfit will remain same
         * **/

        return dp[k][n-1];

    }

    public static int maxProfitPractice(int[] stockprices, int k){
        if(stockprices == null || stockprices.length == 0) return 0;
        int n = stockprices.length;
        k = k%n;

        //unlimited scenario
        if(k > n/2){
            int profit =0;
            for(int i=1; i<n; i++){
                if(stockprices[i] > stockprices[i-1]){
                    profit += stockprices[i] - stockprices[i-1];
                }
            }
            return profit;
        }

        //general case scenario
        //create dp matrix to hold maximum profit
        int[][] dp = new int[k+1][n];
        for(int i=1; i<=k;i++){
            int maxProfit = - stockprices[0];
            for(int j=1; j<n; j++){
                dp[i][j] = Math.max(dp[i][j-1],stockprices[j]+maxProfit);
                maxProfit = Math.max(maxProfit,dp[i-1][j]-stockprices[j]);
            }
        }
        return dp[k][n-1];
    }

    public static int maxProfitUsingDpArray(int[] stockPrices, int k){
        if(stockPrices == null || stockPrices.length ==0 || k == 0) return 0;
        int n = stockPrices.length;

        if(k==2) {
            int buy1 = Integer.MIN_VALUE,buy2= Integer.MIN_VALUE;;
            int profit1 = 0,   profit2 = 0;
            for(int price: stockPrices) {
                buy1 = Math.max(buy1, -price);
                profit1 = Math.max(profit1, buy1 + price);
                buy2 = Math.max(buy2, profit1-price);
                profit2 = Math.max(profit2, buy2+price);
            }
            return  profit2;

        }

        //unlimited Scenario
        if(k >= n/2){
            int profit = 0;
            for(int i=1; i < n; i++){
                if(stockPrices[i] > stockPrices[i-1]){
                    profit += stockPrices[i] - stockPrices[i-1];
                }
            }
            return profit;
        }

        // general case scenario: Dynamic Programming
        /**
         *
         * Space-Optimized DP Idea
         * - In the full DP, we had dp[t][d] = max profit up to day d with at most t transactions.
         * - Notice: to compute dp[t][d], we only need:
         * - dp[t][d-1] (same transaction, previous day)
         * - dp[t-1][d-1] (previous transaction, previous day)
         * - That means we only need two rows at a time: the current transaction row and the previous one.
         * - We can collapse the DP into two 1D arrays of length n.
         * **/
        int[] current = new int[n];
        int[] previous = new int[n];
        for(int t=1; t <=k; t++){
            int maxDiff = - stockPrices[0];
            for(int d=1; d < n ; d++){

                //put max of previous max or current max profile
                current[d] = Math.max(current[d-1],stockPrices[d]+maxDiff);

                //calculate new maxDiff with new matrix
                maxDiff =  Math.max(maxDiff, previous[d] - stockPrices[d]);
            }
            previous = current.clone();
        }

        /**
         * Complexity
         * - Time: O(k\cdot n)
         * - Space: O(k\cdot n) (can be optimized to O(n) with rolling arrays).
         *
         * **/

        return previous[n-1];

    }


    public static void main(String[] args) {
        int[] stockPrice = {7,1,5,6,7,12};
        int[] prices = {3,2,6,5,0,3};
        int[] sprices = {3,3,5,0,0,3,1,4};
        //int[] uptoTwoPrices = {3,3,5,0,0,3,1,4}

        //System.out.println(maxProfit(stockPrice));
        System.out.println(maxProfitPractice(prices,2));
        //System.out.println(maxProfitUsingDpArray(prices,2));
       // System.out.println(maxProfit(sprices));
        //System.out.println(maxProfitUsingDpArray(sprices,2));

    }

}
