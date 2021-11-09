package LC.Contest_266;

public class ProductsDistributedtoAnyStore {
    
    public static void main(String[] args) {

    }

    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int low = 1, high = 0, maxProduct = Integer.MAX_VALUE;

        for(int quantity : quantities) {
            high = Math.max(quantity, high);
        }

        if(m == n) return high;

        while(low <= high) {
            int mid = (low + (high- low)/2);
            if(isDistributionPossible(quantities, n, mid)) {
                maxProduct = Math.min(maxProduct, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return maxProduct;
    }

    private boolean isDistributionPossible(int[] quantities, int n, int w) {
        int shopCount = 0;
        for(int quantity : quantities) {
            shopCount += (quantity/w);
            if((quantity % w) != 0) {
                shopCount++;
            }
        }

        return (shopCount <= n);
    }
}

