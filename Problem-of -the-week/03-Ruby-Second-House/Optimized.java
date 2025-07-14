public class Optimized {
    public static int minCost(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[] prevRow = new int[k];

        for (int j = 0; j < k; j++) {
            prevRow[j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] currRow = new int[k];
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int idx1 = -1;

            // Find min and 2nd min in prevRow
            for (int j = 0; j < k; j++) {
                if (prevRow[j] < min1) {
                    min2 = min1;
                    min1 = prevRow[j];
                    idx1 = j;
                } else if (prevRow[j] < min2) {
                    min2 = prevRow[j];
                }
            }

            // Build current row
            for (int j = 0; j < k; j++) {
                currRow[j] = costs[i][j] + (j == idx1 ? min2 : min1);
            }

            prevRow = currRow;
        }

        int result = Integer.MAX_VALUE;
        for (int val : prevRow) {
            result = Math.min(result, val);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] costs = {{1, 5, 3}, {2, 9, 4}};
        System.out.println(minCost(costs));  // Output: 5
    }
}