public class BruteForc {
    public static int minCost(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];

        // Base case: cost for painting the first house
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (j != l) {
                        dp[i][j] = Math.min(dp[i][j], costs[i][j] + dp[i-1][l]);
                    }
                }
            }
        }

        int minTotal = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minTotal = Math.min(minTotal, dp[n-1][j]);
        }

        return minTotal;
    }

    public static void main(String[] args) {
        int[][] costs = {{1, 5, 3}, {2, 9, 4}};
        System.out.println(minCost(costs));  // Output: 5
    }
}