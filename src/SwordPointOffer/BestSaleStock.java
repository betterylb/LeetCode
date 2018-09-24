package SwordPointOffer;

public class BestSaleStock {
    public static int maxProfit(int [] prices){
        if(prices == null || prices.length <2){
            return 0;
        }

        int maxPrices = prices[0];
        int minPrices = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i] > maxPrices){
                maxProfit = Integer.max(maxProfit, prices[i] - minPrices);
                maxPrices = prices[i];
            }

            if (prices[i] < minPrices){
                minPrices = prices[i];
                maxPrices = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args){
        int[] a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
