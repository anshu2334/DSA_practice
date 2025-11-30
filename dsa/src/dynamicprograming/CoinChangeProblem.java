package dynamicprograming;

import java.util.*;

public class CoinChangeProblem {
    public static int coinChange(int[] coins, int amount){
        if(coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1; i<= amount; i++){
            for(int coin:coins) {
                if(i-coin >= 0){


                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                    System.out.printf("i-coin:%d new dp[i]:%d",i-coin,dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int coinChangeMyway(int[] coins, int amount){
        if(coins == null || coins.length == 0) return -1;
        int[] dp = new int[coins.length];
if(Arrays.stream(coins).anyMatch(s -> s==amount)){
    return 1;
}


        for(int i=0; i< coins.length; i++){
            if(coins[i] == amount){
                return 1;
            }
            int rowSum = amount/coins[i];
            dp[0] += amount/coins[i];
            for(int j=0; j<coins.length;j++) {
                if(coins[j] == amount){
                    return 1;
                }
                int columnSum = amount/coins[j];
                if(rowSum + columnSum > amount) {
                   // System.out.printf("old dp[i]:%d dp[j]:%d",dp[i],dp[j]);
                    //System.out.println();
                   //
                    dp[i] = Math.min(dp[i],rowSum);
                    rowSum += amount/coins[j];
                    System.out.printf("new dp[i]:%d",dp[i]);
                    System.out.println();
                }

            }
        }
        return dp[coins.length-1] > amount ? -1 : dp[coins.length-1] ;
    }

    public static int coinChangeBFS(int[] coins, int amount) {
        if (amount == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(amount);
        visited.add(amount);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int coin : coins) {
                    int next = curr - coin;

                    if (next == 0) {
                        return steps; // Found solution
                    }

                    if (next > 0 && !visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }

        return -1; // Not possible
    }


    public static void main(String[] args) {
        int[] coins = {1,3};
        int amount = 5;
        System.out.println(coinChangeBFS(coins,amount));
    }
}
