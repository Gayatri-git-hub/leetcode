class Solution {
    public int maxProfit(int[] prices) {

       Integer largestProfitSoFar= Integer.MIN_VALUE;
       Integer minPriceSoFar = Integer.MAX_VALUE;

       for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPriceSoFar) minPriceSoFar = prices[i];

            largestProfitSoFar = Math.max(largestProfitSoFar, prices[i] - minPriceSoFar);
       }

        return largestProfitSoFar;
        // Brute force - it fails on submission for - Time limit  exceeded
        /*
        Map<Integer, Integer> profitMap = new HashMap<>();

        for (Integer i = 0; i < prices.length; i++) {
            Integer profit = 0;
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j] - prices[i] > profit)
                    profit = prices[j] - prices[i];
            }
            profitMap.put(i, profit);   
        }

        Integer maxProfInteger =0;
        for (Map.Entry<Integer, Integer> e : profitMap.entrySet()) {
            maxProfInteger = e.getValue() > maxProfInteger? e.getValue(): maxProfInteger;
        }
        return maxProfInteger;
        */

        
    }
}